package bai1.Factory;

public class FanFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        return new Fan();
    }
}
