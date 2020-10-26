package starter;

import java.util.Objects;

public class Order {

    private final long customerId;
    private final int quantity;
    private final String product;
    private int eraInMinutes;

    public Order(long customerId, int quantity, String product) {
        this.customerId = customerId;
        this.quantity = quantity;
        this.product = product;
    }

    public OrderReceipt getReceipt() {
        return new OrderReceipt(customerId, quantity, product);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId &&
                quantity == order.quantity &&
                eraInMinutes == order.eraInMinutes &&
                Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, quantity, product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerId=" + customerId +
                ", quantity=" + quantity +
                ", product='" + product + '\'' +
                ", eraInMinutes=" + eraInMinutes +
                '}';
    }
}
