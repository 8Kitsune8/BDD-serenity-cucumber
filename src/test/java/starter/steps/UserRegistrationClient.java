package starter.steps;

public class UserRegistrationClient {

    long customerIdCounter = 1;
    public void registerUser(Customer newCustomer) {
        newCustomer.hasACustomerIdOf(customerIdCounter++);
    }
}
