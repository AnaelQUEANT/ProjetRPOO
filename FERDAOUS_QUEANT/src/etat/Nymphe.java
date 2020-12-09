package etat;
 // Classe "Nymphe" hérite de "Etat" 
public class Nymphe extends Etat {
	public Nymphe() {
		super();
	}
	
	@Override
	public Etat next() {
		// si la Nymphe est supérieur a 3 elle devient adulte 
		if(nbJourVecu >= 3) {
			return new Adulte();
		}
		nbJourVecu++;
		return this;
	}
}
