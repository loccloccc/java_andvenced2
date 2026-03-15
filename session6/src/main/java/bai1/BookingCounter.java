package bai1;

public class BookingCounter implements Runnable {

    protected String counterName;
    protected TicketPool roomA;
    protected TicketPool roomB;
    protected int soldCount = 0;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {

        while (true) {
            sellComboDeadlock();
        }
    }

    // tạo deadlock
    public void sellComboDeadlock() {

        if (counterName.equals("1")) {

            synchronized (roomA) {

                Ticket tA = roomA.sellTicket();
                System.out.println("Quầy 1: Đã lấy vé " + tA.getTicketId());

                System.out.println("Quầy 1: Đang chờ vé B...");

                synchronized (roomB) {

                    Ticket tB = roomB.sellTicket();

                    soldCount++;

                    System.out.println("Quầy 1 bán combo thành công: "
                            + tA.getTicketId() + " & " + tB.getTicketId());
                }
            }

        } else {

            synchronized (roomB) {

                Ticket tB = roomB.sellTicket();
                System.out.println("Quầy 2: Đã lấy vé " + tB.getTicketId());

                System.out.println("Quầy 2: Đang chờ vé A...");

                synchronized (roomA) {

                    Ticket tA = roomA.sellTicket();

                    soldCount++;

                    System.out.println("Quầy 2 bán combo thành công: "
                            + tA.getTicketId() + " & " + tB.getTicketId());
                }
            }
        }
    }
}