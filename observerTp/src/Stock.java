public class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
