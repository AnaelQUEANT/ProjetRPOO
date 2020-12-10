package etat;

import atrier.Bilan;

// Classe "Nymphe" h�rite de "Etat" 
public class Nymphe extends Etat {
  public Nymphe() {
    super();
  }

  @Override
  public Etat next() {
    // Si la nymphe � v�cu au moins 3 jours, elle �volue en larve
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
