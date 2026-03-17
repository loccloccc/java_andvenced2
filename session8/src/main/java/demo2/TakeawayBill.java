package demo2;

public class TakeawayBill implements Bill{
    @Override
    public void caculateTotal() {
        System.out.println("Tính thuêys VAT 8% , không tính phí phục vụ");
    }
    @Override
    public void print() {
        System.out.println("In hóa đơn mang về");
    }
}
