package etat;

// Classe "Oeuf" qui hérite de "Etat" 
public class Oeuf extends Etat {
	public Oeuf() {
		super();
	}

	@Override
	public Etat next() {
		// si l'oeuf est égal a 3 elle devient larve
		if (nbJourVecu >= 3) {
			return new Larve();
		}
		nbJourVecu++;
		return this;
	}
}
