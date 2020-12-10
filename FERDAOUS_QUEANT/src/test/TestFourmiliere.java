package test;

import static org.junit.Assert.assertTrue;

import fourmiliere.Fourmiliere;
import org.junit.jupiter.api.Test;

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
  }
  
}
