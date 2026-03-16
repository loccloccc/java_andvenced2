package bai5;

public class InvoiceGenerator {

    public static void print(Order order,double discount){

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: " + order.getCustomer().getName());

        for(OrderItem item:order.getItems()){

            System.out.println(item.getProduct().getId()
                    +" - Số lượng: "+item.getQuantity()
                    +" - Đơn giá: "+item.getProduct().getPrice()
                    +" - Thành tiền: "+item.getTotal());
        }

        System.out.println("Tổng tiền: "+order.getTotal());
        System.out.println("Giảm giá: "+discount);
        System.out.println("Cần thanh toán: "+order.getFinalTotal());
    }
}
