package test;

import static org.junit.Assert.assertTrue;

import atrier.Bilan;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;


class TestBilan {

  @Test
  void testConstructeur() throws FileNotFoundException {
    Bilan bilanTest = new Bilan();
    assertTrue(bilanTest.getLog() != null);
    assertTrue(bilanTest.getData() != null);
  }
  
  @Test
  void testIncremente() throws FileNotFoundException {
    Bilan bilanTest = new Bilan();
    assertTrue(bilanTest.valeurClef("Test") == 0);
    bilanTest.incrementation("Test", 1);
    assertTrue(bilanTest.valeurClef("Test") == 1);
    bilanTest.incrementation("Test", 3);
    assertTrue(bilanTest.valeurClef("Test") == 4);
    bilanTest.incrementation("Test", -3);
    assertTrue(bilanTest.valeurClef("Test") == 1);
  }
  
  @Test
  void testClearMap() throws FileNotFoundException {
    Bilan bilanTest = new Bilan();
    assertTrue(bilanTest.getData().size() == 0);
    bilanTest.incrementation("Test", 1);
    assertTrue(bilanTest.getData().size() == 1);
    bilanTest.clearMap();
    assertTrue(bilanTest.getData().size() == 0);
  }

}
