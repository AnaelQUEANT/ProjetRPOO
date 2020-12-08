package etat;

public class Larve extends Etat {
	public Larve() {
		super();
	}
	
	@Override
	public Etat next() {
		if(val > 10) {
			return new Nymphe();
		}
		val++;
		return this;
	}
}
