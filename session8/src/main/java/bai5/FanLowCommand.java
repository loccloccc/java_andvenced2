package bai5;

public class FanLowCommand implements Command {

    private Fan fan;

    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.setLow();
    }
}
