package view;

import service.TransferServic;

import java.util.Scanner;

public class AccountsView {
    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap id nguoi chuyen : ");
        String idFrom = input.nextLine();
        System.out.println("nhap id nguoi nhan : ");
        String idTo = input.nextLine();
        System.out.println("nhap tien muon chuyen : ");
        double money = input.nextDouble();
        input.nextLine();
        TransferServic ts = new TransferServic();
        ts.transfer(idFrom, idTo, money);

    }

}
