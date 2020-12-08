package etat;

public class Adulte extends Etat {
	public Adulte() {
		super();
	}
	
	@Override
	public Etat next() {
		if((val) == 15) {
			return new Mort();
		}
		val++;
		return this;
	}

}
