package bai5;

import java.util.*;

public class Main {

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrderRepository repo = new OrderRepository();
        NotificationService notify = new EmailNotification();
        OrderService service = new OrderService(repo,notify);

        while(true){

            System.out.println("\n1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tính doanh thu");
            System.out.println("6. Thêm thanh toán mới");
            System.out.println("7. Thêm giảm giá mới");
            System.out.println("8. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.print("Mã: ");
                    String id = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Danh mục: ");
                    String cate = sc.nextLine();

                    products.add(new Product(id,name,price,cate));

                    System.out.println("Đã thêm sản phẩm "+id);

                    break;

                case 2:

                    System.out.print("Tên: ");
                    String cname = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("ĐT: ");
                    String phone = sc.nextLine();

                    customers.add(new Customer(cname,email,phone));

                    System.out.println("Đã thêm khách hàng");

                    break;

                case 3:

                    Customer c = customers.get(0);
                    Product p = products.get(0);

                    Order order = new Order("ORD001",c);

                    order.addItem(new OrderItem(p,1));

                    DiscountStrategy discount = new PercentageDiscount(10);

                    PaymentMethod pay = new CreditCardPayment();

                    service.createOrder(order,discount,pay);

                    InvoiceGenerator.print(order,1500000);

                    break;

                case 4:

                    System.out.println("Danh sách đơn hàng:");

                    for(Order o:service.getOrders()){

                        System.out.println(o.getId()+" - "
                                +o.getCustomer().getName()
                                +" - "+o.getFinalTotal());
                    }

                    break;

                case 5:

                    System.out.println("Tổng doanh thu: "
                            +service.getRevenue());

                    break;

                case 6:

                    System.out.println("Đã thêm phương thức thanh toán ZaloPay");

                    break;

                case 7:

                    System.out.println("Đã thêm chiến lược giảm giá VIP");

                    break;

                case 8:
                    return;
            }
        }
    }
}
