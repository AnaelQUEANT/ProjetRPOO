package role;

import atrier.Bilan;

public class Soldat extends Role {
  // class Soldat qui h�rite de Role
  public Soldat() {
    super();
  }

  @Override
  public double[] getVitalite() {
    double[] vita = {1.5, 2.5}; // dur�e de vie
    return vita;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre de soldat", 1);
  }
}
