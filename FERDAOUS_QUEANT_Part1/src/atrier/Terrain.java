package atrier;

import fourmiliere.Fourmiliere;

// class Terrain 
public class Terrain {
  Fourmiliere fourmiliere; // cr�ation d'une fourmiliere

  public Terrain() { // constructeur terrain qui met en place la fourmili�re
    this.fourmiliere = new Fourmiliere();
  }

  // on appelle la fonction step
  void step() {
    fourmiliere.step();
  }

  public void bilan(Bilan leBilan) {
    leBilan.clearMap();
    fourmiliere.bilan(leBilan);  
  }
}
