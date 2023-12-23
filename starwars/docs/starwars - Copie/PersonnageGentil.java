package starwars;

/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class PersonnageGentil extends Personnage {
	
private Boolean force;
public PersonnageGentil(){}
public PersonnageGentil(Boolean force) {
	super();
	this.force = force;
	
}
@Override
public String toString() {
	return "PersonnageMechant"+super.toString()+" [force=" + force + "]";
}
}
