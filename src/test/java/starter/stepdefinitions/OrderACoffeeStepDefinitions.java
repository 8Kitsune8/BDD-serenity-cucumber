package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import starter.*;
import starter.steps.ProductCatalog;
import starter.steps.Barista;
import starter.steps.Customer;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class OrderACoffeeStepDefinitions {


    @Steps(shared = true)
    Customer customer;

    @Steps
    Barista barry;

    OrderReceipt orderReceipt;

    @Steps(shared = true)
    ProductCatalog productCatalog;

    @Given("^(?:.*) (?:orders|has ordered) an? (.*)$")
    public void saraHasOrdered(String order) {
        orderReceipt = customer.placeAnOrderFor(1,order);
        Serenity.setSessionVariable("orderReceipt").to(orderReceipt);
    }

    @Given("^Sara has ordered:$")
    public void saraHasOrdered(List<OrderItem> orderItems) {
        System.out.println("Orders from table:" + orderItems);
        orderItems.forEach(
                order -> {
                    customer.placeAnOrderFor(order.getQuantity(), order.getProduct());
                }
        );
       // Serenity.setSessionVariable("orderReceipt").to(orderReceipt);


    }

    Receipt receipt;
    @When("^she asks for a receipr$")
    public void sheAsksForAReceipr() {
        receipt = customer.requestsAReceipt();
    }

    @Then("^she should receive a receipt totalling:$")
    public void sheShouldReceiveAReceiptTotalling(List<Receipt> expectedreceipts ) {
        Receipt expectedReceipt = expectedreceipts.get(0);

        assertThat(receipt).isEqualToIgnoringNullFields(expectedReceipt);
    }

    @And("^the following prices:$")
    public void theFollowingPrices(List<ProductPrice> productPrices) {

        productCatalog.addProductsWithPrices(productPrices);
    }
}
