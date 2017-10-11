package ai.cuddle.hateos.entity;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by suman.das on 10/11/17.
 */
public class Order extends ResourceSupport {
    private String orderId;
    private double price;
    private int quantity;

    public Order(){

    }

    public Order(String orderId,double price,int quantity){
        this.orderId=orderId;
        this.price=price;
        this.quantity=quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
