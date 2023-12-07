package starwars;
import java.util.ArrayList;

/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class Film {

	private String titre;
	private String annee_sortie;
	private int numEpisode;
	private double cout;
	private double recette;
	private ArrayList<Acteur> acteur;
	
	public Film(String titre, String annee_sortie, int numEpisode, double cout, double recette) {
		
		this.titre = titre;
		this.annee_sortie = annee_sortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
	}

	public Film(String titre, String annee_sortie, int numEpisode, double cout, double recette,
			ArrayList<Acteur> acteur) {
		
		this.titre = titre;
		this.annee_sortie = annee_sortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
		this.acteur = acteur;
	}
	
	Film(){}
	
	/**
	 *retourn le nombre de personnage acteur dans un film 
	 *@return le nombre de acteur
	 **/
	public int nbPersonnagePlayed() {return this.ac.size();}

	public ArrayList<Acteur> getActeur() {
		return acteur;
	}

	public void setActeur(ArrayList<Acteur> acteur) {
		this.acteur = acteur;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAnnee_sortie() {
		return this.annee_sortie;
	}
	public void setAnnee_sortie(String annee_sortie) {
		this.annee_sortie = annee_sortie;
	}
	public int getNumEpisode() {
		return this.numEpisode;
	}
	public void setNumEpisode(int numEpisode) {
		this.numEpisode = numEpisode;
	}
	public double getCout() {
		return this.cout;
	}
	public void setCout(double cout) {
		this.cout = cout;
	}
	public double getRecette() {
		return recette;
	}
	public void setRecette(double recette) {
		this.recette = recette;
	}

	@Override
	public String toString() {
		return "Film [Titre=" + titre + ", Annee_sortie=" + this.annee_sortie + ", numEpisode=" + numEpisode + ", cout="
				+ this.cout + ", Recette=" + this.recette + ", acteur=" + this.acteur + "]";
	}
	
	

}
