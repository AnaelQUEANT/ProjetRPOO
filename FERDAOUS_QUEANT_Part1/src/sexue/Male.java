package sexue;

import atrier.Bilan;
// class Male 

public class Male extends Sexe {
  @Override
  public double[] getVitalite() {
    double[] vita = {1.5, 2.5}; // durée de vie
    return vita;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Fourmi Sexue Male", 1);
  }
}
