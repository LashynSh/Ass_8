package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

class Stock {
    private String symbol;
    private double price;
    private List<Investor> investors;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public void registerInvestor(Investor investor) {
        investors.add(investor);
    }

    public void unregisterInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void updatePrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    private void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(this);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}

class Investor {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock) {
        System.out.println("Dear " + name + ", the price of " + stock.getSymbol() + " has been updated to " + stock.getPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);
        Stock googleStock = new Stock("GOOGL", 2500.0);

        Investor john = new Investor("Daniyal");
        Investor alice = new Investor("Nurtilek");

        appleStock.registerInvestor(john);
        googleStock.registerInvestor(alice);

        appleStock.updatePrice(155.0);
        googleStock.updatePrice(2600.0);
    }
}
