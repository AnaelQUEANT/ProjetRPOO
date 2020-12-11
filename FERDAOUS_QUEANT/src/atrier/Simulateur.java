package atrier;

import java.io.FileNotFoundException;

public class Simulateur {
  static Terrain terrain;
  static Bilan leBilan;

  /**
   * Programme principale.
   * 
   * @param args
   *          Argument de lancement
   * @throws FileNotFoundException
   *           .
   * @throws InterruptedException
   *           .
   * @throws FileNotFoundException
   *           .
   * @throws UnsupportedEncodingException
   *           .
   */
  public static void main(String[] args)
      throws InterruptedException, FileNotFoundException {
    terrain = new Terrain(); // création de Terrain
    leBilan = new Bilan();
    mainLoop(); // boucle pour lancer les jours
    AffichageGraphique
        .affichageGraph((int) terrain.fourmiliere.getNombreRole()[0]);
  }

  /**
   * La boucle principale qui va faire passer les jours.
   * 
   * @throws InterruptedException
   *           .
   * @throws FileNotFoundException
   *           .
   */
  static void mainLoop() throws InterruptedException, FileNotFoundException {
    int nbJour = 0;
    while (nbJour < 30 || terrain.fourmiliere.getPrefourmi()[2] != 0) {
      terrain.step();
      nbJour++;
      terrain.bilan(leBilan);
      leBilan.redigerDonneeAleatoire(nbJour);
      Thread.sleep(100);
    }
    leBilan.fermerFichier();
  }

}
