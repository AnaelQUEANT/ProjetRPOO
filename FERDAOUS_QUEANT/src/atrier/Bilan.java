package atrier;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Bilan {
  private Map<String, Integer> donnee;

  private static PrintWriter log;

  public Bilan() throws FileNotFoundException {
    donnee = new HashMap<String, Integer>();
    log = new PrintWriter("FichierLog.txt");
  }

  /**
   * Incrémente la valeur correspondant à une clé.
   * 
   * @param clef
   *          La cle dans la Map
   * @param valeur
   *          La valeur à ajouté
   */
  public void incrementation(String clef, Integer valeur) {
    Integer valMap = donnee.get(clef);
    if (valMap != null) {
      donnee.put(clef, valMap + valeur);
    } else {
      donnee.put(clef, valeur);
    }
  }

  /**
   * Récupère la valeur associé à une clef.
   * 
   * @param clef
   *          la clé dans la map
   * @return la valeur si elle existe, ou 0
   */
  public Integer valeurClef(String clef) {
    Integer n = donnee.get(clef);
    if (n != null) {
      return n;
    } else {
      return 0;
    }
  }

  public void clearMap() {
    this.donnee.clear();
  }

  /**
   * Rédige l'ensemble des données contenu dans la map dans un fichier.
   * 
   */
  public void redigerDonneeAleatoire(int nbJour) {
    log.println("Jour : " + nbJour);
    Set<String> s = donnee.keySet();
    Iterator<String> itor = s.iterator();
    while (itor.hasNext()) {
      String curr = itor.next();
      log.println(curr + " : " + donnee.get(curr));
    }
    log.println("___________________________________________");
  }

  public void fermerFichier() {
    log.close();
  }

}
