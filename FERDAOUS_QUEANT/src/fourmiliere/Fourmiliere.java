package fourmiliere;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import etat.Adulte;
import etat.Larve;
import etat.Nymphe;
import etat.Oeuf;
import role.Ouvriere;
import role.Role;
import role.Sexue;
import role.Soldat;

public class Fourmiliere {
	public List<Fourmi> fourmis;

	public Fourmiliere() {
		fourmis = new ArrayList<Fourmi>();
	}

	public void step(int nbJour) {
		/*
		 * Iterator<Fourmi> iter = fourmis.iterator(); while(iter.hasNext()) {
		 * iter.next().step(); }
		 */
		for (Fourmi laFourmi : fourmis) {
			laFourmi.step();
			if (laFourmi.etat.getClass().equals(Adulte.class) && ((Adulte) laFourmi.etat).getRole() == null) {
				((Adulte) laFourmi.etat).setRole(nouveauRole());
			}
		}
		ponte(nbJour);
	}

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
		double[] nbRole = { oeuf, larve, nymphe };
		return nbRole;
	}

	public double[] getNombreRole() {
		double ouvriere = 0.0, sexue = 0.0, soldat = 0.0;
		for (Fourmi laFourmi : fourmis) {
			if (laFourmi.etat.getClass().equals(Adulte.class) && ((Adulte) laFourmi.etat).getRole() != null) {
				if (((Adulte) laFourmi.etat).getRole().getClass().equals(Ouvriere.class)) {
					ouvriere++;
				} else if (((Adulte) laFourmi.etat).getRole().getClass().equals(Soldat.class)) {
					soldat++;
				} else if (((Adulte) laFourmi.etat).getRole().getClass().equals(Sexue.class)) {
					sexue++;
				}
			}
		}
		double[] nbRole = { ouvriere, soldat, sexue };
		return nbRole;
	}

	public double getNombreAdulte() {
		return getNombreRole()[0] + getNombreRole()[1] + getNombreRole()[2];
	}

	public int getNombreIndividus() {
		return fourmis.size();
	}

	public double[] getPourcentageRole() {
		double[] nbRole = getNombreRole();
		double nbFourmiRole = (nbRole[0] + nbRole[1] + nbRole[2]);
		if (nbFourmiRole == 0) {
			double[] pourcentage = { 0, 0, 0 };
			return pourcentage;
		} else {
			double[] pourcentage = { (double) (nbRole[0] / nbFourmiRole) * 100,
					(double) (nbRole[1] / nbFourmiRole) * 100, (double) (nbRole[2] / nbFourmiRole) * 100 };
			return pourcentage;
		}
	}

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

	public void ponte(int nbJour) {
		if (nbJour < 92) {
			int j = 0 + (int) (Math.random() * ((5 - 0) + 1));
			for (int i = 0; i < j; i++) {
				fourmis.add(new Fourmi());
			}

		}
	}
}
