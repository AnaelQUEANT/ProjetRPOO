package etat;

import atrier.Bilan;

// Classe "Mort" qui hérite de "Etat" 
public class Mort extends Etat {
  public Mort() {
    super();
  }

  @Override
  // Aucune évolution possible, donc elle envoit uniquement l'objet actuel.
  public Etat next() {
    return this;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre de fourmi morte", 1);
  }
}
