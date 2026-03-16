package bai1;

public class EmailService implements  NotificationService{

    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui email den: " + recipient);
        System.out.println("Noi dung: " + message);
    }
}
