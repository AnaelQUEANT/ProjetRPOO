package etat;

public abstract class Etat {
	protected int val;
	public Etat() {
		val = 0;
	}
	public abstract Etat next();
}
