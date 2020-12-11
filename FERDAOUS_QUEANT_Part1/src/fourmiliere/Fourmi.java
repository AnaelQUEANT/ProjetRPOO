package fourmiliere;

import atrier.Bilan;
import etat.Etat;
import etat.Oeuf;

// classe fourmi
public class Fourmi {
  public Etat etat;

  public Fourmi() {
    etat = new Oeuf();
  }

  // on appelle le prochaine etat
  void step() {
    etat = etat.next();
  }

  /**
   * Mise a jour du bilan.
   * 
   * @param leBilan
   *          Le bilan à mettre a jour
   */
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre de fourmi totale (Morte + Vivante)", 1);
    etat.bilan(leBilan);
  }
}
