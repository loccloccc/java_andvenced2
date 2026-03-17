package demo2;

public class DeliveryBill implements Bill{
    @Override
    public void caculateTotal() {
        System.out.println("Tính thuế VAT 5% + phí ship");
    }

    @Override
    public void print() {
        System.out.println("In hóa đơn gia hàng");
    }
}
