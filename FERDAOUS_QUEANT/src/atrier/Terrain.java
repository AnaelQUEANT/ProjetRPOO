package atrier;

import fourmiliere.Fourmiliere;


// class Terrain 
public class Terrain {
	Fourmiliere fourmiliere;  // création d'une fourmiliere 
	
	public Terrain() {	// constructeur terrain qui met en place la fourmilière
		this.fourmiliere = new Fourmiliere();
	}
	
	// on appelle la fonction step 
	void step(int nbJour) {
		fourmiliere.step(nbJour);
	}
}
