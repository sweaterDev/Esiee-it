import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateStockPrice(String stockName, double newPrice) {
        for (Stock stock : stocks) {
            if (stock.getName().equals(stockName)) {
                stock.setPrice(newPrice);
                notifyObservers(stock);
                break;
            }
        }
    }

    private void notifyObservers(Stock stock) {
        for (Observer observer : observers) {
            observer.update(stock);
        }
    }
}
