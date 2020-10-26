package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import starter.OrderReceipt;
import starter.steps.Barista;
import starter.steps.Customer;

import java.util.List;


public class OrderACoffeeStepDefinitions {


    @Steps(shared = true)
    Customer customer;

    @Steps
    Barista barry;

    OrderReceipt orderReceipt;

    @Given("^(?:.*) (?:orders|has ordered) an? (.*)$")
    public void saraHasOrdered(String order) {
        orderReceipt = customer.placeAnOrderFor(1,order);
        Serenity.setSessionVariable("orderReceipt").to(orderReceipt);
    }

    @Given("^Sara has ordered:$")
    public void saraHasOrdered(List<String> orders) {
        System.out.println("Orders from table:" + orders);
    }
}
