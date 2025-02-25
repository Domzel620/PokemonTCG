package src;

import src.TCG.*;
import  src.TCG.PokemonCards.PokemonCreatures.*;
public class BattleTester {
    public static void main(String[] args) {
        StadiumTester battle = new StadiumTester();
        Squirtle coolGuy = new Squirtle();
        Charmander hotGuy = new Charmander();
        DeckCreator deck1 = new DeckCreator();
        PokemonGame game = new PokemonGame();
        MonteDeckSimulation monteDeck = new MonteDeckSimulation();
        //battle.battle(coolGuy, hotGuy);
        //ArrayList<Card> deck = deck1.createElectricDeck();
        //game.setDeck(deck);
        //deck = game.getDeck();
        //game.shuffleDeck(deck);
        //game.drawHand(deck);
        //game.printHand();
        //game.fillPrize(deck);
        //game.printPrize();
       // monteDeck.createMonteDeck();
       //monteDeck.createMonteRare();
       game.chooseDeck();
    }
}
