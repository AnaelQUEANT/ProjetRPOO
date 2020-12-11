package role;

import atrier.Bilan;

// class Ouvriere 
public class Ouvriere extends Role {

  public Ouvriere() {
    super();
  }

  @Override
  public double[] getVitalite() {
    double[] vita = {1.5, 2.5}; // durée de vie
    return vita;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Nombre d'ouvriere", 1);
  }

}
