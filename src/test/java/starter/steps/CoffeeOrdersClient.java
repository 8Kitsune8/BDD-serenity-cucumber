package starter.steps;

import net.thucydides.core.annotations.Steps;
import starter.Order;
import starter.OrderReceipt;
import starter.Receipt;
import starter.UnknownProductException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrdersClient {
    List<Order> orders = new ArrayList<>();


    @Steps(shared = true)
    ProductCatalog productCatalog;

    public OrderReceipt placeOrder(long customerId, int quantity, String product) {
        Order order = new Order(customerId,quantity,product);
        orders.add(order);
        return order.getReceipt();
    }

    public Receipt getRecipeFor(long customerId) {
        double subTotal = orders.stream()
                .filter(order -> order.getCustomerId() == customerId)
                .mapToDouble(this::subtotalFor)
                .sum();
        double serviceFee = subTotal * 5 / 100;
        double total = subTotal + serviceFee;
        return new Receipt(roundedTo2DecimalPlaces(subTotal),
                roundedTo2DecimalPlaces(serviceFee),
                roundedTo2DecimalPlaces(total));
    }

    private double roundedTo2DecimalPlaces(double value) {
        return new BigDecimal(Double.toString(value)).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    private double subtotalFor(Order order)  {
        try {
            return productCatalog.priceOf(order.getProduct()) * order.getQuantity();
        } catch (UnknownProductException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
