package BTTH.model;

public class Light implements Device{
    private boolean isOn;

    public Light(boolean isOn) {
        this.isOn = isOn;
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Tat den");
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Bat den");
    }
}
