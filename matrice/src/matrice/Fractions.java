package matrice;

public class Fractions {
    protected double a; // Numérateur
    protected double b; // Dénominateur

    // Constructeur
    public Fractions(double x, double y) {
        this.a = x;
        this.b = (y != 0) ? y : 1.0;
    }

    // Affichage de la fraction
    public void Affiche() {
        System.out.println(a + " / " + b + " = " + (a / b));
    }

    // Accesseurs
    public double DonneNum() {
        return a;
    }

    public double DonneDeno() {
        return b;
    }

    // Mutateurs
    public void ChangeNum(double z) {
        this.a = z;
    }

    public void ChangeDeno(double z) {
        if (z != 0) { // Le dénominateur ne peut pas être zéro
            this.b = z;
        }
    }

    // Inverse de la fraction
    public void Inverse() {
        if (a != 0) { // Assure que le numérateur n'est pas nul
            double temp = a;
            a = b;
            b = temp;
        }
    }
}
