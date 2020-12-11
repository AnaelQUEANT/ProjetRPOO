package role;

import atrier.Bilan;

// Classe de transition
// Uniquement utile pour le test de Step de la fourmiliere
public class EnAttente extends Role{
  public EnAttente() {
    super();
  }

  @Override
  public double[] getVitalite() {
    double[] vitalite = {1,2};
    return vitalite;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Fourmi en attente de role", 1);
  }
}
