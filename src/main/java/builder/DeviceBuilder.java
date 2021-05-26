package builder;

public class DeviceBuilder {
    private int ram;
    private double screenSize;
    private int battery;
    private String os;

    public DeviceBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public DeviceBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public DeviceBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public DeviceBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public Device build() {
        return new Device(ram, screenSize, battery, os);
    }

}
