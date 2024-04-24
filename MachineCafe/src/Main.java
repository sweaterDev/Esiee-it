public class Main {
    public static void main(String[] args) {
        Boisson cafe = new Cafe();
        Boisson cafeAuLait = new Lait( new Cafe());
        cafe.cout();
        cafeAuLait.cout();
        cafeAuLait.description();

    }
}