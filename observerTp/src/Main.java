public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Investor investor1 = new Investor("john");
        Investor investor2 = new Investor("Doe");

        market.addObserver(investor1);
        market.addObserver(investor2);

        Stock googleStock = new Stock("Croissant", 5000.00);
        market.addStock(googleStock);

        // Simuler un changement de prix
        market.updateStockPrice("Croissant", 6500.50);
    }
}