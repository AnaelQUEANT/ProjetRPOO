package etat;

// Classe "Mort" qui hérite de "Etat" 
public class Mort extends Etat {
	public Mort() {
	}

	@Override
	// Aucune évolution possible, donc elle envoit uniquement l'objet actuel.
	public Etat next() {
		return this;
	}

}
