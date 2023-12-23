package starwars;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		
		///Etape 2
		Film film1 = new Film("Star Wars, épisode IV : Un nouvel espoir",1977,4,10000.87,100000.98);
		Film film2 =new Film();
		//film2 = film2.saisieFilm();
		System.out.println(film2.toString());
		///Etape 3
	    Personnage perso1 = new Personnage("Anne","solo");
	   
	    ///Etape 4
	    ArrayList<Object> Starwars = new ArrayList<Object>();
	    Starwars.add(film1);
	    Starwars.add(film2);
	    Starwars.add(perso1);
	    
	    ///Etape 5
	    for (Object persoFilm : Starwars) {
	    	System.out.println(persoFilm.toString());	    	
	    }
	   ///Etape 8 
	    Personnage perso2 = new Personnage("chou","baka");
	    Duet<Personnage, Personnage> duoPerso1 = new Duet<Personnage, Personnage>(perso1,perso2);
	    Acteur act1 = new Acteur("Ryan","Goosling",duoPerso1);
	   
	}
}
