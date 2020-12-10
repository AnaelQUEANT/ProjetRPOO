package etat;

import atrier.Bilan;
import role.Role;

// Classe "Adulte" qui hérite de "Etat"

public class Adulte extends Etat {
  private Role leRole;
  
  public Adulte() {
    super();
  }

  /**
   * Fait évoluer l'état si le temps passé est supérieur ou égal à la valeur de
   * vitalité. Sinon, la méthode incrémente le nombre de jour vécu.
   */
  @Override
  public Etat next() {
    if ((nbJourVecu) >= leRole.getVitalite()[0] * 50) {
      return new Mort();
    }
    nbJourVecu++;
    return this;
  }

  /**
   * Permet l'assignation d'un Rôle si l'Adulte n'en possède pas encore.
   * 
   * @param newRole
   *          le rôle à assigner pour la fourmi
   */
  public void setFirstRole(Role newRole) {
    if (leRole == null) {
      leRole = newRole;
    }
  }

  // Retourne le Role
  public Role getRole() {
    return leRole;
  }

  @Override
  public void bilan(Bilan leBilan) {
    leBilan.incrementation("Fourmi adulte", 1);
    leRole.bilan(leBilan);
  }

}
