package fr.zinraphil.models.patchwork;

import java.util.ArrayList;

public class Matrice {

  private ArrayList<ArrayList<Double>> matrice = new ArrayList<>();
  public Matrice(int x, int y) {
    for (int i = 0; i < x; i++) {
      ArrayList<Double> line = new ArrayList<>();
      for (int j = 0; j < y; j++) {
        line.add(0.0);
      }
      matrice.add(line);
    }
  }
}
