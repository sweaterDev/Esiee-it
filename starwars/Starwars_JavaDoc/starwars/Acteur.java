package starwars;
import java.util.ArrayList;
/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class Acteur {
private String nom;
private String prenom;
private Duet<Personnage, Personnage> duoPersonnage;

private  ArrayList<Personnage> personnages;


///constructeurs

public Acteur() {}

public Acteur(String nom, String prenom, Duet<Personnage,Personnage> personnage) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.duoPersonnage = personnage;
}

public Acteur(String nom, String prenom) {

	this.nom = nom;
	this.prenom = prenom;
}

////getters setters

public Duet<Personnage,Personnage> getDuoPersonnage() {
	return duoPersonnage;
}

public void setDuoPersonnage(Duet<Personnage,Personnage> duoPersonnage) {
	this.duoPersonnage = duoPersonnage;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

	public ArrayList<Personnage> getPersonnages() {
		return personnages;
	}

	public void setPersonnages(ArrayList<Personnage> personnages) {
		this.personnages = personnages;
	}
public String toString() {
	return"class : "+ getClass().getSimpleName()+
	"\n Nom :"+ this.nom +
	"\n Prenom :"+ this.prenom+
	"\n Personnages :"+ this.duoPersonnage;
}

/**
 *retourne le nombre de personnage incaré par un acteur
 *@return le nombre de personnage
 **/
public int nbPersonnages() {return this.personnages.size();}

	
	

}
