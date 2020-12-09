package etat;

// Classe "Oeuf" qui h�rite de "Etat" 
public class Oeuf extends Etat {
	public Oeuf() {
		super();
	}

	@Override
	public Etat next() {
		// si l'oeuf est �gal a 3 elle devient larve
		if (nbJourVecu >= 3) {
			return new Larve();
		}
		nbJourVecu++;
		return this;
	}
}
