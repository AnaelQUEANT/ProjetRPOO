package etat;

// Classe "Mort" qui h�rite de "Etat" 
public class Mort extends Etat {
	public Mort() {
	}

	@Override
	// Aucune �volution possible, donc elle envoit uniquement l'objet actuel.
	public Etat next() {
		return this;
	}

}
