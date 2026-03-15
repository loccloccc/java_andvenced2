package bai1;

import java.util.ArrayList;
import java.util.List;


public class Bai1 {
    public static void main(String[] args) {

        List<Ticket> ticketsA = new ArrayList<>();
        List<Ticket> ticketsB = new ArrayList<>();

        // tạo 10 vé ban đầu
        for (int i = 1; i <= 10; i++) {
            ticketsA.add(new Ticket("A-" + String.format("%03d", i), "A", false));
            ticketsB.add(new Ticket("B-" + String.format("%03d", i), "B", false));
        }

        TicketPool roomA = new TicketPool("A", ticketsA);
        TicketPool roomB = new TicketPool("B", ticketsB);

        // quầy 1 lock A -> B
        Thread quay1 = new Thread(() -> {
            while (true) {
                synchronized (roomA) {

                    System.out.println(Thread.currentThread().getName() + " locked roomA");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (roomB) {

                        System.out.println(Thread.currentThread().getName() + " locked roomB");

                        Ticket tA = roomA.sellTicket();
                        Ticket tB = roomB.sellTicket();

                        if (tA != null && tB != null) {
                            System.out.println("Combo sold: " + tA.getId() + " & " + tB.getId());
                        }
                    }
                }
            }
        }, "Counter 1");


        // quầy 2 lock B -> A (tạo deadlock)
        Thread quay2 = new Thread(() -> {
            while (true) {
                synchronized (roomB) {

                    System.out.println(Thread.currentThread().getName() + " locked roomB");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (roomA) {

                        System.out.println(Thread.currentThread().getName() + " locked roomA");

                        Ticket tA = roomA.sellTicket();
                        Ticket tB = roomB.sellTicket();

                        if (tA != null && tB != null) {
                            System.out.println("Combo sold: " + tA.getId() + " & " + tB.getId());
                        }
                    }
                }
            }
        }, "Counter 2");


        // supplier thêm vé
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 1);
        Thread tSupplier = new Thread(supplier);

        quay1.start();
        quay2.start();
        tSupplier.start();
    }
}