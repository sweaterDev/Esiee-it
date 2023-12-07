package starwars;
import java.util.ArrayList;
/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class Acteur {
private String nom;
private String prenom;
private ArrayList<Personnage> personnage;


public Acteur(String nom, String prenom, ArrayList<Personnage> personnage) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.personnage = personnage;
}

public Acteur(String nom, String prenom) {

	this.nom = nom;
	this.prenom = prenom;
}

public Acteur() {}

/**
 *retourne le nombre de personnage jouer par un acteur
 *@return le nombre de personnage
 **/
public int nbPersonnagePlayed() {return this.personnage.size();}

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
public String toString() {
	return"class : "+ getClass().getSimpleName()+
	"\n Nom :"+ this.nom +
	"\n Prenom :"+ this.prenom;
}


	
	

}
