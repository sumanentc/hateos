package ai.cuddle.hateos.entity;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by suman.das on 10/10/17.
 */
public class Customer extends ResourceSupport {
    private String customerId;
    private String customerName;
    private String companyName;

    public Customer(){

    }
    public Customer(String id,String name,String companyName){
        this.customerId=id;
        this.customerName=name;
        this.companyName=companyName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
