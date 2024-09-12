package sense.service;

import sense.model.OpenOrders;

import java.util.List;

interface StockService {
    boolean addStock(String stockName);
    void buyStock(String stockName, double price, int quantity);
    void sellStock(String stockName, double price, int quantity);
    OpenOrders getAllOpenOrderForStock(String stockName);
}
