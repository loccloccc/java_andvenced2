package demo2;

public class DineInBill implements Bill{
    @Override
    public void caculateTotal() {
        System.out.println("Tính thuế VAT 10% + phí phục vụ");
    }

    @Override
    public void print() {
        System.out.println("In hóa đơn ăn tại chỗ");
    }
}
