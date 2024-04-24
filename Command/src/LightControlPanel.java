import java.util.ArrayList;

public class LightControlPanel {
    ArrayList<Lampe> lampes = new ArrayList<Lampe>();

    public ArrayList<Lampe> getLampes() {
        return lampes;
    }

    public void setLampes(ArrayList<Lampe> lampes) {
        this.lampes = lampes;
    }



    public void AjouterLampes(Lampe lampe){
        lampes.add(lampe);
    }
    public void modifierLampe(int id,int intensite) {
        if( intensite ==0 ) {
            lampes.get(id).eteindreLampe();
        }
        else {
            lampes.get(id).setIntersite(intensite);
        }
    }
}
