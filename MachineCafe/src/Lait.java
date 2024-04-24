public class Lait extends Decorator {
    public Lait(Cafe cafe) {
        super(cafe);
    }


    @Override
    public void cout() {
        cafe.setCout(cafe.getCout()+1);
        System.out.println(cafe.getCout());
    }

    @Override
    public void description() {
        cafe.setDescription(cafe.getDescription()+"   et lait");
        System.out.println(cafe.description);
    }
}
