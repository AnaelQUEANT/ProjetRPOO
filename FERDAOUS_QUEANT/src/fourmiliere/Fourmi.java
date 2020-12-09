package fourmiliere;

import etat.Etat;
import etat.Oeuf;
// classe fourmi
public class Fourmi {
	public Etat etat;
	
	public Fourmi() {
		etat = new Oeuf();
	}
	
	// on appelle le prochaine etat 
	void step() {
		etat = etat.next();
	}
}
