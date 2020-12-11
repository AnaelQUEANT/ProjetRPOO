package etat;

import atrier.Bilan;
import role.Role;

// Classe "Adulte" qui h�rite de "Etat"

public class Adulte extends Etat {
  private Role leRole;
  
  public Adulte() {
    super();
  }

  /**
   * Fait �voluer l'�tat si le temps pass� est sup�rieur ou �gal � la valeur de
   * vitalit�. Sinon, la m�thode incr�mente le nombre de jour v�cu.
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
   * Permet l'assignation d'un R�le si l'Adulte n'en poss�de pas encore.
   * 
   * @param newRole
   *          le r�le � assigner pour la fourmi
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
