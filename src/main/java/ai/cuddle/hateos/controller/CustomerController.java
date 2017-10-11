package ai.cuddle.hateos.controller;

import ai.cuddle.hateos.entity.Customer;
import ai.cuddle.hateos.entity.Order;
import ai.cuddle.hateos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by suman.das on 10/10/17.
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String customerId) {
        Customer customer= customerService.getCustomerDetail(customerId);
        Link selfLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
        customer.add(selfLink);
        return customer;
    }

    @RequestMapping(value = "/{customerId}/orders", method = RequestMethod.GET)
    public List<Order> getOrdersForCustomer(@PathVariable String customerId) {
        return customerService.getAllOrdersForCustomer(customerId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List getAllCustomers() {
        List<Customer> allCustomers = customerService.allCustomers();

        for (Customer customer : allCustomers) {
            Link selfLink = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
            customer.add(selfLink);

            if (customerService.getAllOrdersForCustomer(customer.getCustomerId())!= null) {
                List<Order> methodLinkBuilder =  ControllerLinkBuilder.methodOn(CustomerController.class).getOrdersForCustomer(customer.getCustomerId());
                Link ordersLink = linkTo(methodLinkBuilder).withRel("allOrders");
                customer.add(ordersLink);
            }
        }
        return allCustomers;
    }
}
