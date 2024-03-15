package matrice;

public class FractionsOp extends Fractions {
    // Le constructeur hérité fonctionne pour FractionsOp sans modification

    public FractionsOp(double x, double y) {
        super(x, y);
    }

    // Méthode pour remplacer la fraction par son opposée
    public void Oppose() {
        this.a = -this.a;
    }
}
