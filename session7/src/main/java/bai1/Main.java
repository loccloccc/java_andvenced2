package bai1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Product p1 , p2 ;
        p1 = new Product("SP01" , "Laptop" , 15000000.0 );
        p2 = new Product("SP02" , "chuot" ,300000.0);
        System.out.println("Them san pham thanh cong");


        Customer customer = new Customer("KH01","Nguyen Van A" , "a@gmail.com","Ha Noi");
        System.out.println("Them khach hang thanh cong");
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        Order o1 = new Order("ORD001",customer,list,0.0);
        OrderCalculator orderCalculator;

        PercentageDiscount percentageDiscount = new PercentageDiscount(10);
        orderCalculator = new OrderCalculator(percentageDiscount);
        double money_1 = orderCalculator.totalCaculateMoney(o1);
        System.out.println("Gia tien giam lan 1 : " + percentageDiscount.applyDiscount(money_1));


        FixedDiscount fixedDiscount = new FixedDiscount(50000);
        orderCalculator = new OrderCalculator(fixedDiscount);
        double money_2 = orderCalculator.totalCaculateMoney(o1);
        System.out.println("Gia ten sau khi giam lan 3 : " + fixedDiscount.applyDiscount(money_2));

        NoDiscount noDiscount = new NoDiscount();
        orderCalculator = new OrderCalculator(noDiscount);
        System.out.println("Gia tien sau khi giam lan 3 : " + noDiscount.applyDiscount(orderCalculator.totalCaculateMoney(o1)));


        OrderRepository repository = new OrderRepository();
        repository.save(o1);
        System.out.println("Da luu don hang " + o1.getOrderID());

        EmailService emailService = new EmailService();
        emailService.send("Don hang " + o1.getOrderID() + " da duoc tao" ,  o1.customer.getEmail());

        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        PaymentProcessor processor1 = new PaymentProcessor(cod);
        PaymentProcessor processor2 = new PaymentProcessor(card);
        PaymentProcessor processor3 = new PaymentProcessor(momo);

        processor1.pay(50000);
        processor2.pay(500000);
        processor3.pay(7000000);


    }
}
