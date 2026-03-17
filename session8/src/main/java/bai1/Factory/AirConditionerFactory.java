package bai1.Factory;

public class AirConditionerFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        return new AirConditioner();
    }
}
