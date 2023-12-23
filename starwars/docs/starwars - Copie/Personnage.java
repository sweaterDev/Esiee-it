package starwars;
/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class Personnage {
	
	private String nom;
	private String prenom;
	
	public Personnage(String nom, String prenom) {
		
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personnage() 
	{
		
	}
	
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", prenom=" + prenom + "]";
	}


}
