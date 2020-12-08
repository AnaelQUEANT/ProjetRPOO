package fourmiliere;

import etat.Etat;
import etat.Oeuf;

public class Fourmi {
	public Etat etat;
	
	public Fourmi() {
		etat = new Oeuf();
	}
	
	void step() {
		etat = etat.next();
	}
}
