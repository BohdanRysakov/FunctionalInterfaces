import java.util.*;
import java.util.regex.Pattern;

public class MySimpleFuncInterface {
    public static void main(String[] args) {
        MyAmazingFunctionalInterface graphFactoryFromConsole = () -> {
            Scanner scanner = new Scanner(System.in);
            Map<String, List<String>> graph = new HashMap<>();
            System.out.println("Write a graph's edge in format: X-Y, where x,y - node's");
            System.out.println("When finished - type exit");
            String s;
            String[] tmpS;
            while (true) {
                s = scanner.nextLine();
                if (s.equals("exit")) {
                    break;
                }
                while (!Pattern.matches("\\w+[-]\\w+", s)) {
                    System.out.println("Write a graph's edge in format: X-Y, where x,y - node's");
                    s = scanner.nextLine();
                }
                tmpS = s.split("-", 2);
                if (graph.containsKey(tmpS[0])) {
                    graph.get(tmpS[0]).add(tmpS[1]);
                } else {
                    graph.put(tmpS[0], new ArrayList<>(List.of(tmpS[1])));
                }
                if (!graph.containsKey(tmpS[1])) {
                    graph.put(tmpS[1], new ArrayList<>());
                }
            }
            return graph;
        };
        Map<String, List<String>> testGraph = graphFactoryFromConsole.doGraph();
        System.out.println(testGraph);
    }
}