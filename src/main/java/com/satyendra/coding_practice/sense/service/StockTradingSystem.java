package sense.service;

import sense.model.OpenOrders;
import sense.model.Order;

public class StockTradingSystem {
    public static void main(String[] args) {
        StockService stockService = new StockServiceImpl();

        stockService.addStock("Apple");
        stockService.addStock("Samsung");
        stockService.addStock("Sense");

        stockService.buyStock("Apple", 10.0, 5);
        stockService.sellStock("Apple", 10.0, 5);
        stockService.buyStock("Samsung", 20.0, 2);
        printStocks(stockService.getAllOpenOrderForStock("Apple"), "Apple");
        printStocks(stockService.getAllOpenOrderForStock("Samsung"), "Samsung");
    }

    private static void printStocks(OpenOrders openOrders, String stockName) {
        System.out.println(stockName);
        System.out.println("All sell stocks..");
        for(Order order : openOrders.getSellOrders()) {
            System.out.println("Quantity: " + order.getQuantity() + " Price: " + order.getPrice());
        }

        System.out.println("All buy stocks..");
        for(Order order : openOrders.getBuyOrders()) {
            System.out.println("Quantity: " + order.getQuantity() + " Price: " + order.getPrice());
        }
    }
}
