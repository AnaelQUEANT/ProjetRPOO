package etat;

import atrier.Bilan;

// Classe abstraite "Etat"
public abstract class Etat {
  protected int nbJourVecu; // Nombre de jour vécu dans l'état actuel
  
  // Constructeur, initialisation du nombre de jour vécu à 0
  public Etat() {
    nbJourVecu = 0;
  }
  
  // Méthode abstraite ayant pour objectif de faire évoluer l'état
  public abstract Etat next();

  public abstract void bilan(Bilan leBilan);
}
