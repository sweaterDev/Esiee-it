public abstract class Decorator implements Boisson{
    Cafe cafe;
    public Decorator( Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public void description() {

    }

    @Override
    public void cout() {

    }
}
