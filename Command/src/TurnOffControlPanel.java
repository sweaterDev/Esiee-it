public class TurnOffControlPanel {
    Lampe lampe;
    public TurnOffControlPanel(Lampe lampe){
        this.lampe = lampe;
    }
    public void Execute() {
        this.lampe.allumerLampe();
    }
}

