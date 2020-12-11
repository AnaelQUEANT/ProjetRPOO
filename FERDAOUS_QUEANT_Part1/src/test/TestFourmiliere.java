package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fourmiliere.Fourmi;
import fourmiliere.Fourmiliere;
import role.EnAttente;

import org.junit.jupiter.api.Test;

import etat.Adulte;

class TestFourmiliere {
  @Test
  void testConstructeur() {
    Fourmiliere test = new Fourmiliere();
    assertTrue(test.getListeFourmis() != null);
  }

  @Test
  void testStep() {
    Fourmiliere test = new Fourmiliere();
    test.step();
    assertTrue(test.getListeFourmis().size() > 0);
    Fourmi testF = new Fourmi();
    testF.etat = new Adulte();
    assertTrue(((Adulte) testF.etat).getRole().getClass().equals(EnAttente.class));
    test.fourmis.add(testF);
    test.step();
    assertFalse(((Adulte) testF.etat).getRole().getClass().equals(EnAttente.class));
  }
}
