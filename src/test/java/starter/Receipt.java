package starter;

import java.util.List;

public class Receipt {

    private double subtotal;
    private double serviceFee;
    private double total;



    private List<ReceiptItem> items;

    public double getSubtotal() {
        return subtotal;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public double getTotal() {
        return total;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public Receipt(double subtotal, double serviceFee, double total, List<ReceiptItem> items) {
        this.subtotal = subtotal;
        this.serviceFee = serviceFee;
        this.total = total;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "subtotal=" + subtotal +
                ", serviceFee=" + serviceFee +
                ", total=" + total +
                ", items=" + items +
                '}';
    }

}
