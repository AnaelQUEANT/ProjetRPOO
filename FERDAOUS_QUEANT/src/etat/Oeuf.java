package etat;

public class Oeuf extends Etat {
	public Oeuf() {
		super();
	}
	
	@Override
	public Etat next() {
		if(val == 3) {
			return new Larve();
		}
		val++;
		return this;
	}
}
