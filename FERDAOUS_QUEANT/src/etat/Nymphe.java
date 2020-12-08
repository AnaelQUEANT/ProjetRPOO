package etat;

public class Nymphe extends Etat {
	public Nymphe() {
		super();
	}
	
	@Override
	public Etat next() {
		if(val == 3) {
			return new Adulte();
		}
		val++;
		return this;
	}
}
