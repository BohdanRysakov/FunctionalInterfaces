import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;

public class UsingBuiltInInterfaces {
    public static void main(String[] args) {
        //Reverse StringBuilder
        Consumer<StringBuilder> reverse = StringBuilder::reverse;

        //Predicate to observe fulfillment of any condition
        Predicate<String> isPolindrom = s -> {
            StringBuilder stringBuilder = new StringBuilder(s);
            reverse.accept(stringBuilder);
            return s.equalsIgnoreCase(stringBuilder.toString());
        };
        System.out.println(isPolindrom.test("Harry"));
        System.out.println(isPolindrom.test("Hannah"));

        //Returns array of ASCII numbers from input string
        Function<String, Integer[]> getBytes = (s) -> {
            List<Integer> list = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                list.add((int) ch);
            }
            return list.toArray(Integer[]::new);
        };
        System.out.println(Arrays.toString(getBytes.apply("Hello!")));

        //Creates polite string, that introduces herself to developer
        Supplier<String> makePoliteString = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write your impolite String: ");
            String impoliteString = scanner.nextLine();
            SimpleDateFormat timeOfBirth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            System.out.println("Hi! I am polite String \"" + impoliteString + "\"\n" +
                    "but my friend call me " + impoliteString.hashCode()
                    + "\n" +
                    "i was born at: " + timeOfBirth.format(new Date()) + " so i am still too young " + "\n" +
                    "Ill be happy to serve at your application!+\n");

            return impoliteString;
        };
        System.out.println(makePoliteString.get() + "\n");


        //Creates Copy of Robo-Cat, writes that it is only copy and updates version of robot
        UnaryOperator<RoboCat> roboCatCopier = (rc) -> new RoboCat(rc.getRoboName() + " copy", rc.getVersion() + 1);
        RoboCat roboCat = new RoboCat("Murzilka", 1);
        System.out.println(roboCat);
        RoboCat roboCatCopy = roboCatCopier.apply(roboCat);
        System.out.println(roboCatCopy);
        RoboCat roboCatCopyCopy = roboCatCopier.apply(roboCatCopy);
        System.out.println(roboCatCopyCopy);


    }

}
