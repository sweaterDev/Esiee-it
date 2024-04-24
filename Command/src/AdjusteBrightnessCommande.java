public class AdjusteBrightnessCommande implements Commande {
    Lampe lampe;
    int intensite;
    int previous_intensite;
    public AdjusteBrightnessCommande(Lampe lampe, int intensite){
        this.lampe = lampe;
        this.intensite = intensite;
        this.previous_intensite = lampe.getIntersite();
    }
    public void Execute() {
        this.lampe.setIntersite(intensite);
    }

    @Override
    public void undo() {
        lampe.setIntersite(previous_intensite);

    }
}

