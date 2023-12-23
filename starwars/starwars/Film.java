package starwars;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class Film {

	private String titre;
	private int annee_sortie;
	private int numEpisode;
	private double cout;
	private double recette;
	private ArrayList<Acteur> acteur;
	//Etape 10
	private ArrayList<Object> starwars;


	///constructeurs
	
	Film(){}
	
	public Film(String titre, int annee_sortie, int numEpisode, double cout, double recette) {
		
		this.titre = titre;
		this.annee_sortie = annee_sortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
	}

	public Film(String titre, int annee_sortie, int numEpisode, double cout, double recette,
			ArrayList<Acteur> acteur) {
		
		this.titre = titre;
		this.annee_sortie = annee_sortie;
		this.numEpisode = numEpisode;
		this.cout = cout;
		this.recette = recette;
		this.acteur = acteur;
	}
	
	///setters & getters
	
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
	public int getAnnee_sortie() {
		return this.annee_sortie;
	}
	public void setAnnee_sortie(int annee_sortie) {
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
		return "Class : "+getClass().getSimpleName()+" [Titre=" + titre + ", Annee_sortie=" + this.annee_sortie + ", numEpisode=" + numEpisode + ", cout="
				+ this.cout + ", Recette=" + this.recette + ", acteur=" + this.acteur + "]";
	}
	
	/**
	 *@return  l'objet film  qui à  été saisie par utilisateur
	 **/
	public Film saisieFilm()  {
			
			Film film2 = new Film();
			Scanner scanner = new Scanner(System.in);
			try {
			System.out.println("Veuillez entrer les informations du film.");
		
		    System.out.print("Titre: ");
		    String titre = scanner.nextLine();

		    System.out.print("Année de sortie: ");
		    int annee_sortie = scanner.nextInt();  

		    System.out.print("Numéro d'épisode: ");
		    int numEpisode = scanner.nextInt();  //
				
		    System.out.print("Coût de production: ");
		    double cout = scanner.nextDouble();  

		    System.out.print("Recette: ");
		    double recette = scanner.nextDouble();
		    
		    film2 = new Film(titre, annee_sortie, numEpisode, cout, recette);
		    
			}
			catch(InputMismatchException ms) {
				System.out.println("la saisie n'était pas valide");
				saisieFilm();
			}	
			finally{
		    scanner.close();}
		    
		    return film2;
	}

	/**
	 * Retourne le nombre d'acteurs dans un film.
	 * @return int : le nombre d'acteurs dans le film.
	 */
	public int nbActeurs() {
		return acteur.size();
	}

	/**
	 * Retourne le nombre total de personnages représentés par tous les acteurs dans un film.
	 * @return int : le nombre total de personnages dans le film.
	 */
	public int nbPersonnage() {
		int nbperso = 0;
		for (Acteur acteurs : this.acteur) {
			nbperso += acteurs.getPersonnages().size();
		}
		return nbperso;
	}

	/**
	 * Calcule le bénéfice ou le déficit d'un film. Retourne un Duet contenant la valeur monétaire du bénéfice ou du déficit et un booléen indiquant si le film est bénéficiaire.
	 * @return Duet<Double, Boolean> : le premier élément est le bénéfice (positif) ou le déficit (négatif), le second est un booléen (true si bénéficiaire, false sinon).
	 */
	public Duet<Double, Boolean> calculBenefice() {
			Double benefice = recette - cout;
			return new Duet<>(benefice, benefice>0);
	}

	/**
	 * Détermine si l'année donnée est antérieure à l'année de sortie du film.
	 * @param annee L'année à comparer avec l'année de sortie du film.
	 * @return Boolean : true si l'année donnée est antérieure à l'année de sortie, false sinon.
	 * @throws Exception Si l'année donnée est la même que l'année de sortie du film.
	 */
	public Boolean isBefore(int annee) throws Exception {
		 if (this.annee_sortie == annee) {
			throw new Exception("Ils sont de la même année");
		}
		return annee_sortie>annee;
	}

	/**
	 * Trie la liste des acteurs du film par ordre alphabétique de leurs noms.
	 */
	public void tri() {
		Collections.sort(acteur, new Comparator<Acteur>() {
			@Override
			public int compare(Acteur a1, Acteur a2) {
				return a1.getNom().compareTo(a2.getNom());
			}
		});
	}

	/**
	 * Affiche un résumé des films stockés dans un dictionnaire, organisé par année.
	 * @param dictionnaire Un dictionnaire avec comme clé une année et comme valeur un objet Film.
	 */
	public void makeBackUp(Map<Integer, Film> dictionnaire) {
		for (Map.Entry<Integer, Film> entry : dictionnaire.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue().getTitre() + " - " + entry.getValue().calculBenefice().getFirst());
		}
	}

	
	

}
