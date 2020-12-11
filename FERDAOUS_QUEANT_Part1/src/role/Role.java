package role;

import atrier.Bilan;

// class Role 
public abstract class Role {
  public Role() {
  }
  
  public abstract double[] getVitalite();

  public abstract void bilan(Bilan leBilan);

}
