package starter.steps;

import starter.Order;
import starter.OrderReceipt;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrdersClient {
    List<Order> orders = new ArrayList<>();

    public OrderReceipt placeOrder(long customerId, int quantity, String product) {
        Order order = new Order(customerId,quantity,product);
        orders.add(order);
        return order.getReceipt();
    }
}
