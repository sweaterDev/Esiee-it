public class Cafe implements Boisson{
    String description = "boisson au café";
    float cout = 1;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    @Override
    public void description() {
        System.out.println(this.description);
    }
    @Override
    public void cout() {
        System.out.println(this.cout);
    }
}
