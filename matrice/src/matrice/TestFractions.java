package matrice;

import java.util.Scanner;

public class TestFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lecture de x et y pour la fraction f
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        Fractions f = new Fractions(x, y);

        // Affichage, inversion, et ré-affichage de f
        f.Affiche();
        f.Inverse();
        f.Affiche();

        // Modification de f
        f.ChangeNum(f.DonneNum() + 1.5);
        f.ChangeDeno(f.DonneDeno() + 3.5);
        f.Affiche();

        // Création et manipulation de g
        FractionsOp g = new FractionsOp(2.4, 7.3);
        g.Affiche();
        g.Oppose();
        g.Affiche();
    }
}
