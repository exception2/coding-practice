package sense.service;

import sense.model.OpenOrders;
import sense.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockServiceImpl implements StockService {
    Map<String, OpenOrders> stockMap;

    public StockServiceImpl() {
        stockMap = new HashMap<>();
    }

    @Override
    public boolean addStock(String stockName) {
        if(!stockMap.containsKey(stockName)) {
            stockMap.put(stockName, new OpenOrders());
            return true;
        }
        return false;
    }

    @Override
    public void buyStock(String stockName, double price, int quantity) {
        if(stockMap.containsKey(stockName)) {
            List<Order> sellStocks = stockMap.get(stockName).getSellOrders();
            Order sellOrder = null;
            double diff = Integer.MIN_VALUE;
            for(Order order : sellStocks) {
                if(order.getPrice() <= price && diff < price - order.getPrice()) {
                    sellOrder = order;
                    diff = Math.max(diff, price - order.getPrice());
                }
            }
            if(sellOrder != null) {
                if(sellOrder.getQuantity() == quantity) {
                    sellStocks.remove(sellOrder);
                } else if(sellOrder.getQuantity() > quantity) {
                    sellOrder.setQuantity(sellOrder.getQuantity() - quantity);
                } else {
                    Order buyOrder = new Order(price, quantity - sellOrder.getQuantity());
                    stockMap.get(stockName).getBuyOrders().add(buyOrder);
                }
            } else {
                Order buyOrder = new Order(price, quantity);
                stockMap.get(stockName).getBuyOrders().add(buyOrder);
            }
        }
    }

    @Override
    public void sellStock(String stockName, double price, int quantity) {
        if(stockMap.containsKey(stockName)) {
            List<Order> buyStocks = stockMap.get(stockName).getBuyOrders();
            Order buyStock = null;
            double diff = Integer.MIN_VALUE;
            for(Order order : buyStocks) {
                if(price <= order.getPrice() && diff < order.getPrice() - price) {
                    buyStock = order;
                    diff = Math.max((order.getPrice() - price), diff);
                }
            }
            if(buyStock != null) {
                if(buyStock.getQuantity() == quantity) {
                    buyStocks.remove(buyStock);
                } else if(buyStock.getQuantity() > quantity) {
                    buyStock.setQuantity(buyStock.getQuantity() - quantity);
                } else {
                    Order sellOrder = new Order(price, quantity - buyStock.getQuantity());
                    stockMap.get(stockName).getSellOrders().add(sellOrder);
                }
            } else {
                Order sellOrder = new Order(price, quantity);
                stockMap.get(stockName).getSellOrders().add(sellOrder);
            }
        }
    }

    @Override
    public OpenOrders getAllOpenOrderForStock(String stockName) {
        return stockMap.get(stockName);
    }
}
