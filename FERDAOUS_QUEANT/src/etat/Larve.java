package etat;

// Classe "Larve" qui hérite de "Etat" 
public class Larve extends Etat {
	public Larve() {
		super();
	}

	@Override
	/**
	 * Fait évoluer l'état si le temps passé est supérieur ou égal à la valeur
	 * 10. Sinon, la méthode incrémente le nombre de jour vécu.
	 */
	public Etat next() {
		// Evolution en nymphe si le nombre de jour vécu en larve est supérieur
		// à 10
		if (nbJourVecu >= 10) {
			return new Nymphe();
		}
		nbJourVecu++;
		return this;
	}
}
