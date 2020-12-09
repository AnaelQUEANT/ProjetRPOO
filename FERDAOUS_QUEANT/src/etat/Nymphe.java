package etat;
 // Classe "Nymphe" h�rite de "Etat" 
public class Nymphe extends Etat {
	public Nymphe() {
		super();
	}
	
	@Override
	public Etat next() {
		// si la Nymphe est sup�rieur a 3 elle devient adulte 
		if(nbJourVecu >= 3) {
			return new Adulte();
		}
		nbJourVecu++;
		return this;
	}
}
