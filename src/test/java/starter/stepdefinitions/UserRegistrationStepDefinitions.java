package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StateNode;
import net.thucydides.core.annotations.Steps;
import starter.steps.Customer;
import starter.steps.UserRegistrationClient;

public class UserRegistrationStepDefinitions {

    @Steps(shared = true)
    Customer customer;
    @Steps
    UserRegistrationClient userRegistration;

    @Given("^(.*) has a Caffeinate-Me account$")
    public void customerHasACaffeinateMeAccount(String userName) {

        userRegistration.registerUser(customer);
        customer.isCalled(userName);
    }
}
