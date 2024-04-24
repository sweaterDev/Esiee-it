public class Lampe {
    public Lampe() {}
    protected Boolean allume = false;
    protected int intersite = 0;


    public Boolean getAllume() {
        return allume;
    }

    public void setAllume(Boolean allume) {
        this.allume = allume;
    }

    public int getIntersite() {
        return intersite;
    }

    public void setIntersite(int intersite) {
        this.intersite = intersite;
    }
    public void allumerLampe() {
        setAllume(true);
        setIntersite(1);
    }
    public void eteindreLampe() {
        setAllume(false);
        setIntersite(0);
    }
}
