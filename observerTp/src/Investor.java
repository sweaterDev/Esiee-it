public class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Investor " + name + " à été notifié du changement de prix sur  " + stock.getName() + ": " + stock.getPrice());
    }
}
