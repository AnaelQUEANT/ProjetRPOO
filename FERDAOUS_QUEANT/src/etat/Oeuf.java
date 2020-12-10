package etat;

import atrier.Bilan;

// Classe "Oeuf" qui h�rite de "Etat" 
public class Oeuf extends Etat {
  public Oeuf() {
    super();
  }

  @Override
  public Etat next() {
    // Si l'oeuf � v�cu au moins 3 jours, il �volue en larve
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
