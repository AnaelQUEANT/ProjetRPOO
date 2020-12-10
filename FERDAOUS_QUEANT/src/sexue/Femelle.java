package sexue;

import atrier.Bilan;

// class Femelle
public class Femelle extends Sexe {
  public boolean isReine;

  @Override
  public double[] getVitalite() {
    if (isReine) {
      double[] vita = {4, 10}; // Durée de vie
      return vita;
    } else {
      double[] vita = {1.5, 2.5};
      return vita;
    }
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Fourmi Sexue Femelle", 1);
  }

}
