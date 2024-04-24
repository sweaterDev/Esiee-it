public class TurnOnLightCommande implements Commande{
   Lampe lampe;
    public TurnOnLightCommande(Lampe lampe){
        this.lampe = lampe;
    }
   public void Execute() {
        this.lampe.allumerLampe();
   }
    public void undo() {

    }
}
