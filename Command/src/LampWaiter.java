public class LampWaiter {
    public void excute(Commande commande) {
        commande.Execute();
    }
    public void undo (Commande commande){
        commande.undo();
    }
}
