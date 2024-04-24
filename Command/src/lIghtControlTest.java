public class lIghtControlTest {
    public static void main(String[] args) {
        LightControlPanel panel = new LightControlPanel();
        Lampe light1 = new Lampe();
        panel.AjouterLampes(light1);

        Commande turnOn = new TurnOnLightCommande(light1);

        Commande adjustBrightness = new AdjusteBrightnessCommande(light1, 70);

        turnOn.Execute();
        adjustBrightness.Execute();
        // Undo the last two commands
        adjustBrightness.undo();
    }
}
