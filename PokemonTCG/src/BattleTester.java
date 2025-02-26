package src;

import src.TCG.*;
public class BattleTester {
    public static void main(String[] args) {
        //StadiumTester battle = new StadiumTester();
        //Squirtle coolGuy = new Squirtle();
        //Charmander hotGuy = new Charmander();
        //DeckCreator deck1 = new DeckCreator();
        PokemonGame game = new PokemonGame();
        MonteDeckSimulation monteDeck = new MonteDeckSimulation();
        //battle.battle(coolGuy, hotGuy);
       // monteDeck.createMonteDeck();
       //monteDeck.createMonteRare();
       game.gameLoop();
    }
}
