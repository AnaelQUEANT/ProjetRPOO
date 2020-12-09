package fourmiliere;

import etat.Adulte;
import etat.Larve;
import etat.Nymphe;
import etat.Oeuf;
import java.util.ArrayList;
import java.util.List;
import role.Ouvriere;
import role.Role;
import role.Sexue;
import role.Soldat;

public class Fourmiliere {

	public List<Fourmi> fourmis; // Liste de fourmis lié à la fourmiliere

	// la Fourmiliere est une facade de gestion de la liste de fourmis
	public Fourmiliere() {
		fourmis = new ArrayList<Fourmi>();
	}

	// Fonction d'évolution du nombre de jour.
	public void step(int nbJour) {
		for (Fourmi laFourmi : fourmis) {
			laFourmi.step();
			if (laFourmi.etat.getClass().equals(Adulte.class)
					&& ((Adulte) laFourmi.etat).getRole() == null) {
				((Adulte) laFourmi.etat).setFirstRole(nouveauRole());
			}
		}
		ponte(nbJour);
	}

	// retoune le nombre d'oeuf, de larve et de nymphe
	public double[] getPrefourmi() {
		double oeuf = 0.0, larve = 0.0, nymphe = 0.0;
		for (Fourmi laFourmi : fourmis) {
			if (laFourmi.etat.getClass().equals(Oeuf.class)) {
				oeuf++;
			} else if (laFourmi.etat.getClass().equals(Larve.class)) {
				larve++;
			} else if (laFourmi.etat.getClass().equals(Nymphe.class)) {
				nymphe++;
			}
		}
		double[] nbRole = {oeuf, larve, nymphe};
		return nbRole;
	}

	// retourne le nombre de fourmi ouvriere, soldat et sexue.
	public double[] getNombreRole() {
		double ouvriere = 0.0, sexue = 0.0, soldat = 0.0;
		for (Fourmi laFourmi : fourmis) {
			if (laFourmi.etat.getClass().equals(Adulte.class)
					&& ((Adulte) laFourmi.etat).getRole() != null) {
				if (((Adulte) laFourmi.etat).getRole().getClass()
						.equals(Ouvriere.class)) {
					ouvriere++;
				} else if (((Adulte) laFourmi.etat).getRole().getClass()
						.equals(Soldat.class)) {
					soldat++;
				} else if (((Adulte) laFourmi.etat).getRole().getClass()
						.equals(Sexue.class)) {
					sexue++;
				}
			}
		}
		double[] nbRole = {ouvriere, soldat, sexue};
		return nbRole;
	}

	// Récupère le nombre de fourmis à l'état adulte. (A refaire)
	public double getNombreAdulte() {
		return getNombreRole()[0] + getNombreRole()[1] + getNombreRole()[2];
	}

	// Retourne le nombre de fourmis compris dans la fourmilière
	public int getNombreIndividus() {
		return fourmis.size();
	}

	/**
	 * Méthode ayant pour objectif le calcul du pourcentage de chaque role des
	 * fourmis adultes dans la fourmilière.
	 * 
	 * @return un tableau composé des pourcentages des trois roles.
	 */
	public double[] getPourcentageRole() {
		double[] nbRole = getNombreRole();
		double nbFourmiRole = (nbRole[0] + nbRole[1] + nbRole[2]);
		if (nbFourmiRole == 0) {
			double[] pourcentage = {0, 0, 0};
			return pourcentage;
		} else {
			double[] pourcentage = {(double) (nbRole[0] / nbFourmiRole) * 100,
					(double) (nbRole[1] / nbFourmiRole) * 100,
					(double) (nbRole[2] / nbFourmiRole) * 100};
			return pourcentage;
		}
	}

	/**
	 * Vérifie les statistiques des fourmis adulte et assigne le prochain role.
	 * 
	 * @return le role qui doit être assigné
	 */
	public Role nouveauRole() {
		double[] nbRole = getPourcentageRole();
		if (nbRole[0] < 60.0) {
			return new Ouvriere();
		} else if (nbRole[1] < 20.0) {
			return new Soldat();
		} else {
			return new Sexue();
		}
	}

	/**
	 * Ajoute des oeufs à la liste de fourmis.
	 * 
	 * @param nbJour
	 *            le n-ième jour
	 */
	public void ponte(int nbJour) {
		if (nbJour < 90) {
			int j = 0 + (int) (Math.random() * ((3 - 0) + 1));
			for (int i = 0; i < j; i++) {
				fourmis.add(new Fourmi());
			}

		}
	}
}
