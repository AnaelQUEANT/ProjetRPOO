package role;

import atrier.Bilan;
import sexue.Sexe;

// classe Sexue qui hérite de Role
public class Sexue extends Role {
  private Sexe leSexeFourmi;

  public Sexue(Sexe leSexe) {
    super();
    leSexeFourmi = leSexe;
  }

  public double[] getVitalite() {
    return leSexeFourmi.getVitalite();
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Sexue", 1);
    leSexeFourmi.bilan(leBilan);
  }

  public Sexe getLeSexeFourmi() {
    return leSexeFourmi;
  }

}
