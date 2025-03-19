package src;

import  src.TCG.*;
public class MonteTester {
    public static void main(String[] args) {;
        MonteDeckSimulation monteDeck = new MonteDeckSimulation();
        monteDeck.createMonteDeck();
        monteDeck.createMonteRare();
    }
}