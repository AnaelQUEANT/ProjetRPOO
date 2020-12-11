package etat;

import atrier.Bilan;

// Classe abstraite "Etat"
public abstract class Etat {
  protected int nbJourVecu; // Nombre de jour v�cu dans l'�tat actuel
  
  // Constructeur, initialisation du nombre de jour v�cu � 0
  public Etat() {
    nbJourVecu = 0;
  }
  
  // M�thode abstraite ayant pour objectif de faire �voluer l'�tat
  public abstract Etat next();

  public abstract void bilan(Bilan leBilan);
}
