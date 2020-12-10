package etat;

import atrier.Bilan;

// Classe "Larve" qui h�rite de "Etat" 
public class Larve extends Etat {
  public Larve() {
    super();
  }

  /**
   * Fait �voluer l'�tat si le temps pass� est sup�rieur ou �gal � la valeur 10.
   * Sinon, la m�thode incr�mente le nombre de jour v�cu.
   */
  @Override
  public Etat next() {
    // Evolution en nymphe si le nombre de jour v�cu en larve est sup�rieur
    // � 10
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
