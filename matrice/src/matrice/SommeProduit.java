package matrice;

public class SommeProduit {
    private int[] Liste; // Tableau d'entiers comme attribut privé

    // Constructeur qui initialise Liste avec des valeurs prédéfinies
    public SommeProduit() {
        Liste = new int[]{17, 89, 6, 8, 1, 45, 4, 2, 3};
    }

    // Méthode pour afficher les éléments de Liste
    public void Affiche() {
        for (int val : Liste) {
            System.out.print(val + "\t");
        }
        System.out.println(); // Nouvelle ligne après affichage de tous les éléments
    }

    // Méthode pour calculer la somme des éléments impairs de Liste
    public int SommeImpairs() {
        int somme = 0;
        for (int val : Liste) {
            if (val % 2 != 0) { // Vérifie si l'élément est impair
                somme += val;
            }
        }
        return somme;
    }

    // Méthode pour calculer le produit des éléments pairs de Liste
    public int ProduitPairs() {
        int produit = 1;
        for (int val : Liste) {
            if (val % 2 == 0 && val != 0) { // Vérifie si l'élément est pair et non nul
                produit *= val;
            }
        }
        return produit;
    }
}
