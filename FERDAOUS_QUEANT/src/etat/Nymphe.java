package etat;

import atrier.Bilan;

// Classe "Nymphe" hérite de "Etat" 
public class Nymphe extends Etat {
  public Nymphe() {
    super();
  }

  @Override
  public Etat next() {
    // Si la nymphe à vécu au moins 3 jours, elle évolue en larve
    if (nbJourVecu >= 3) {
      return new Adulte();
    }
    nbJourVecu++;
    return this;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre de nymphe", 1);
  }
}
