package etat;

import atrier.Bilan;

// Classe "Oeuf" qui hérite de "Etat" 
public class Oeuf extends Etat {
  public Oeuf() {
    super();
  }

  @Override
  public Etat next() {
    // Si l'oeuf à vécu au moins 3 jours, il évolue en larve
    if (nbJourVecu >= 3) {
      return new Larve();
    }
    nbJourVecu++;
    return this;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre d'oeuf", 1);
  }
}
