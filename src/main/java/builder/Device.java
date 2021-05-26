package builder;

public class Device {

    private int ram;
    private double screenSize;
    private int battery;
    private String os;

    public Device(int ram, double screenSize, int battery, String os) {
        super();
        this.ram = ram;
        this.screenSize = screenSize;
        this.battery = battery;
        this.os = os;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Device{" +
                "ram=" + ram +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                ", os='" + os + '\'' +
                '}';
    }
}
