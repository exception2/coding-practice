package sense.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class OpenOrders {
    private List<Order> buyOrders;
    private List<Order> sellOrders;

    public OpenOrders() {
        this.buyOrders = new ArrayList<>();
        this.sellOrders = new ArrayList<>();
    }

    public List<Order> getBuyOrders() {
        return buyOrders;
    }
    public List<Order> getSellOrders() {
        return sellOrders;
    }
}
