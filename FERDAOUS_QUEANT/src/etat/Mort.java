package etat;

public class Mort extends Etat {
	public Mort() {
	}
	
	@Override
	public Etat next() {
		return this;
	}

}
