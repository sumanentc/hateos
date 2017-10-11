package ai.cuddle.hateos.service;

import ai.cuddle.hateos.entity.Customer;
import ai.cuddle.hateos.entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suman.das on 10/10/17.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<String,Customer> map = new HashMap<String,Customer>();

    private Map<String,List<Order>> orderMap = new HashMap<>();

    public CustomerServiceImpl(){
        Customer customer = new Customer("10A","Jane","ABC Company");
        map.put("10A",customer);
        Customer customer1 = new Customer("20B","Bob","XYZ Company");
        map.put("20B",customer1);
        Customer customer2 = new Customer("30C","Jane","ABC Company");
        map.put("30C",customer2);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1",1.0,10));

        orderMap.put("10A",orders);
    }

    @Override
    public Customer getCustomerDetail(String customerId) {
        return map.get(customerId);
    }

    @Override
    public List<Customer> allCustomers() {
        List<Customer> list = new ArrayList<>();
        for(Map.Entry<String,Customer>  ent: map.entrySet()){
            list.add(ent.getValue());
        }
        return list;
    }

    @Override
    public List<Order> getAllOrdersForCustomer(String customerId) {
        return orderMap.get(customerId);
    }
}
