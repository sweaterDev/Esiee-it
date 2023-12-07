package starwars;
/* 
@Author SebastienMercellus
@ Version 1.0
*/
public class PersonnageMechant extends Personnage {
	
private  Boolean coteObscure;

public PersonnageMechant() {
	super();
}
public PersonnageMechant(Boolean coteObscure) {
	super();
	this.coteObscure = coteObscure;
}
public Boolean getCoteObscure() {
	return coteObscure;
}
public void setCoteObscure(Boolean coteObscure) {
	this.coteObscure = coteObscure;
}
}
