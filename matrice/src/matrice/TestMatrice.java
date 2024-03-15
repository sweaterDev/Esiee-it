package matrice;

public class TestMatrice {
    public static void main(String[] args) {
        // Créer une instance de Matrice avec des valeurs initiales
        int[][] valeurs = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrice maMatrice = new Matrice(valeurs);

        // Afficher la matrice
        System.out.println("Matrice T :");
        maMatrice.Affiche();

        // Afficher la transposée de la matrice
        System.out.println("Transposée de T :");
        maMatrice.AfficheTransposee();
    }
}