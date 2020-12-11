package sexue;

import atrier.Bilan;

public abstract class Sexe {
  
  public Sexe() {
  }
  
  public abstract double[] getVitalite();

  public abstract void bilan(Bilan leBilan);
}
