public class ArbreBinaire {
    private Integer clef;
    private ArbreBinaire gauche;
    private ArbreBinaire droite;
    private static ArbreBinaire arbrevide;
    public ArbreBinaire(Integer clef, ArbreBinaire gauche, ArbreBinaire droite) {
        clef = clef;
        gauche= gauche;
        droite = droite;
    }
    public ArbreBinaire() {
        this.arbrevide = new ArbreBinaire(null,null,null);
    }
    public  ArbreBinaire cree() {
        return this.arbrevide;
    }

    public Integer getClef() {
        return clef;
    }

    public void setClef(Integer clef) {
        this.clef = clef;
    }

    public ArbreBinaire getGauche() {
        return gauche;
    }

    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }

    public ArbreBinaire getDroite() {
        return droite;
    }

    public void setDroite(ArbreBinaire droite) {
        this.droite = droite;
    }

    public static ArbreBinaire getArbrevide() {
        return arbrevide;
    }

    public static void setArbrevide(ArbreBinaire arbrevide) {
        ArbreBinaire.arbrevide = arbrevide;
    }
    public boolean estVide() {
        return clef == null && gauche == null && droite == null;
    }
    public int taille() {
        if (this.estVide()) return 0;
        int tailleGauche = gauche == null ? 0 : gauche.taille();
        int tailleDroite = droite == null ? 0 : droite.taille();
        return 1 + tailleGauche + tailleDroite;
    }
    public boolean rechercher(Integer val) {
        if (this.estVide()) return false;
        if (this.clef.equals(val)) return true;
        if (val < this.clef) {
            return gauche != null && gauche.rechercher(val);
        }
        return droite != null && droite.rechercher(val);
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
