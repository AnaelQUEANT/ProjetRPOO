package fourmiliere;

import atrier.Bilan;
import etat.Adulte;
import etat.Etat;
import etat.Larve;
import etat.Nymphe;
import etat.Oeuf;
import java.util.ArrayList;
import java.util.List;
import role.Ouvriere;
import role.Role;
import role.Sexue;
import role.Soldat;
import sexue.Femelle;
import sexue.Male;

public class Fourmiliere {

  public List<Fourmi> fourmis; // Liste de fourmis lié à la fourmiliere
  private int nbJourPonte;

  // la Fourmiliere est une facade de gestion de la liste de fourmis
  public Fourmiliere() {
    fourmis = new ArrayList<Fourmi>();
    nbJourPonte = 0;
  }

  /**
   * Fait évoluer l'état de la fourmilière d'un jour.
   */
  public void step() {
    for (Fourmi laFourmi : fourmis) {
      laFourmi.step();
      if (laFourmi.etat.getClass().equals(Adulte.class)
          && ((Adulte) laFourmi.etat).getRole() == null) {
        ((Adulte) laFourmi.etat).setFirstRole(nouveauRole());
      }
    }
    ponte();
  }

  /**
   * Calcul le nombre de fourmi avant l'age adulte.
   * 
   * @return Un tableau a 3 case
   */
  public double[] getPrefourmi() {
    double oeuf = 0.0;
    double larve = 0.0;
    double nymphe = 0.0;
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

  /**
   * Calcul le nombre de chaque role de fourmi (Ouvriere, soldat et sexue).
   * 
   * @return Un tableau de 3 places
   */
  public double[] getNombreRole() {
    double ouvriere = 0.0;
    double sexue = 0.0;
    double soldat = 0.0;
    double male = 0.0;
    double femelle = 0.0;
    for (Fourmi laFourmi : fourmis) {
      Etat etatFourmi = laFourmi.etat;
      if (etatFourmi.getClass().equals(Adulte.class)
          && ((Adulte) laFourmi.etat).getRole() != null) {
        Adulte adulteFourmi = (Adulte) etatFourmi;
        if (adulteFourmi.getRole().getClass().equals(Ouvriere.class)) {
          ouvriere++;
        } else if (adulteFourmi.getRole().getClass().equals(Soldat.class)) {
          soldat++;
        } else if (adulteFourmi.getRole().getClass().equals(Sexue.class)) {
          sexue++;
          Sexue sexeFourmi = (Sexue) adulteFourmi.getRole();
          if (sexeFourmi.getLeSexeFourmi().getClass().equals(Male.class)) {
            male++;
          } else {
            femelle++;
          }
        }
      }
    }
    double[] nbRole = {ouvriere, soldat, sexue, male, femelle};
    return nbRole;
  }

  // Récupère le nombre de fourmis à l'état adulte. (A refaire)
  public double getNombreAdulte() {
    return getNombreRole()[0] + getNombreRole()[1] + getNombreRole()[2];
  }

  // Retourne le nombre de fourmis compris dans la fourmilière
  public int getNombreIndividusVivantMort() {
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
    double nbFourmiSexue = (nbRole[3] + nbRole[4]);
    if (nbFourmiRole == 0) {
      double[] pourcentage = {0, 0, 0, 0, 0};
      return pourcentage;
    } else {
      double[] pourcentage = {(double) (nbRole[0] / nbFourmiRole) * 100,
          (double) (nbRole[1] / nbFourmiRole) * 100,
          (double) (nbRole[2] / nbFourmiRole) * 100,
          (double) (nbRole[3] / nbFourmiSexue) * 100,
          (double) (nbRole[4] / nbFourmiSexue) * 100};
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
      if (nbRole[3] < 50) {
        return new Sexue(new Male());
      } else {
        return new Sexue(new Femelle());
      }
    }
  }

  /**
   * Ajoute des oeufs à la liste de fourmis.
   */
  public void ponte() {
    if (nbJourPonte < 50) {
      int j = 0 + (int) (Math.random() * ((3 - 0) + 1));
      for (int i = 0; i < j; i++) {
        fourmis.add(new Fourmi());
      }
      nbJourPonte++;
    }
  }

  /**
   * Met a jour le bilan avec l'ensemble des informations des fourmis.
   * 
   * @param leBilan
   *          Le bilan à mettre a jour
   */
  public void bilan(Bilan leBilan) {
    for (Fourmi laFourmi : fourmis) {
      laFourmi.bilan(leBilan);
    }
  }
}
