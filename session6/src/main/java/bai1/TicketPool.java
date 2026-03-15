package bai1;


import java.util.List;

public class TicketPool {
    protected String roomName;
    protected List<Ticket> tickets ;

    public TicketPool() {
    }

    public TicketPool(String roomName , List<Ticket> tickets) {
        this.roomName = roomName;
        this.tickets = tickets;
    }
    public synchronized Ticket sellTicket() {

        while (true) {

            for (Ticket t : tickets) {
                if (!t.isSold()) {
                    t.setSold(true);
                    return t;
                }
            }

            try {
                wait(); // hết vé → chờ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {

            String id;

            if (roomName.equals("A"))
                id = "A-" + String.format("%03d", start + i);
            else
                id = "B-" + String.format("%03d", start + i);

            tickets.add(new Ticket(id, roomName, false));
        }

        notifyAll(); // đánh thức các quầy đang chờ
    }
}
