public class RoboCat {
    private String roboName;
    private long version;

    public RoboCat(String roboName, long serialNumber) {
        this.roboName = roboName;
        this.version = serialNumber;
    }

    public String getRoboName() {
        return roboName;
    }

    public void setRoboName(String roboName) {
        this.roboName = roboName;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoboCat{" +
                "roboName='" + roboName + '\'' +
                ", version=" + version +
                '}';
    }
}
