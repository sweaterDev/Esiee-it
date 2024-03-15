package matrice;

public class TestSommeProduit {
    public static void main(String[] args) {
        SommeProduit sp = new SommeProduit(); // Création d'une instance de SommeProduit

        // Affichage de la liste
        System.out.println("Éléments de la liste :");
        sp.Affiche();

        // Calcul et affichage de la somme des éléments impairs
        System.out.println("Somme des éléments impairs : " + sp.SommeImpairs());

        // Calcul et affichage du produit des éléments pairs
        System.out.println("Produit des éléments pairs : " + sp.ProduitPairs());
    }
}
