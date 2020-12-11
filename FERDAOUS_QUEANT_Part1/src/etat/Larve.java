package etat;

import atrier.Bilan;

// Classe "Larve" qui hérite de "Etat" 
public class Larve extends Etat {
  public Larve() {
    super();
  }

  /**
   * Fait évoluer l'état si le temps passé est supérieur ou égal à la valeur 10.
   * Sinon, la méthode incrémente le nombre de jour vécu.
   */
  @Override
  public Etat next() {
    // Evolution en nymphe si le nombre de jour vécu en larve est supérieur
    // à 10
    if (nbJourVecu >= 10) {
      return new Nymphe();
    }
    nbJourVecu++;
    return this;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre de larve", 1);
  }
}
