package a_trier;

import fourmiliere.Fourmiliere;

public class Terrain {
	Fourmiliere fourmiliere;
	
	public Terrain() {
		this.fourmiliere = new Fourmiliere();
	}
	
	void step(int nbJour) {
		fourmiliere.step(nbJour);
	}
}
