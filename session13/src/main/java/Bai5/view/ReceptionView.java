package Bai5.view;


import Bai5.controller.PatientController;

import java.util.Scanner;

public class ReceptionView {

    Scanner sc = new Scanner(System.in);
    PatientController controller = new PatientController();

    public void start() {

        while (true) {

            System.out.println("===== RIKKEI HOSPITAL =====");
            System.out.println("1. Admit Patient");
            System.out.println("2. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    admit();
                    break;

                case 2:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void admit() {

        try {

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Bed ID: ");
            String bedId = sc.nextLine();

            System.out.print("Advance payment: ");
            double amount = Double.parseDouble(sc.nextLine());

            controller.admitPatient(name, age, bedId, amount);

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }
}