package sense.model;

import lombok.Data;

import java.util.Date;

public class Order {
    private double price;
    private int quantity;
    private Date createdDate;

    public Order(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.createdDate = new Date();
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
