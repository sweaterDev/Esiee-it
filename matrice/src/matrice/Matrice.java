package matrice;

public class Matrice {
    private int[][] T; // Attribut privé représentant la matrice

    // Constructeur qui initialise la matrice T
    public Matrice(int[][] valeurs) {
        T = valeurs;
    }

    // Méthode pour afficher la matrice
    public void Affiche() {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print(T[i][j] + "\t");
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne
        }
    }

    // Méthode pour afficher la transposée de la matrice
    public void AfficheTransposee() {
        for (int i = 0; i < T[0].length; i++) { // Itérer sur les colonnes de la matrice originale
            for (int j = 0; j < T.length; j++) { // Itérer sur les lignes de la matrice originale
                System.out.print(T[j][i] + "\t"); // Affichage en inversant les indices
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne
        }
    }
}


