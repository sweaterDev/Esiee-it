public class Main {
    public static void main(String[] args) {

        ArbreBinaire a1 = new ArbreBinaire();
        a1.setClef(1);
        a1.setGauche(a1.cree());
        a1.setDroite(new ArbreBinaire(2,new ArbreBinaire(3,a1.cree(),a1.cree()),a1.cree()));
        System.out.println(a1.rechercher(3));

    }



}