package etat;

import role.Role;

// Classe "Adulte" qui h�rite de "Etat"

public class Adulte extends Etat {
	private Role leRole;
	public Adulte() {
		super();
	}

	@Override
	/**
	 * Fait �voluer l'�tat si le temps pass� est sup�rieur ou �gal � la valeur
	 * de vitalit�. Sinon, la m�thode incr�mente le nombre de jour v�cu.
	 */
	public Etat next() {
		if ((nbJourVecu) >= leRole.getVitalite()[0]) {
			return new Mort();
		}
		nbJourVecu++;
		return this;
	}

	/**
	 * Permet l'assignation d'un R�le si l'Adulte n'en poss�de pas encore.
	 * 
	 * @param newRole
	 *            le r�le � assigner pour la fourmi
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

}
