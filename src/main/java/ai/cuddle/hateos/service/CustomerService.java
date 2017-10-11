package ai.cuddle.hateos.service;

import ai.cuddle.hateos.entity.Customer;
import ai.cuddle.hateos.entity.Order;

import java.util.List;

/**
 * Created by suman.das on 10/10/17.
 */
public interface CustomerService {
    Customer getCustomerDetail(String customerId);
    List<Customer> allCustomers();
    List<Order> getAllOrdersForCustomer(String customerId);
}
