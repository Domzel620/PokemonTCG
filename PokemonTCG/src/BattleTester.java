package src;

import java.util.ArrayList;
import  src.TCG.*;
import src.TCG.PokemonCards.PokemonCreatures.*;
public class BattleTester {
    public static void main(String[] args) {
        StadiumTester battle = new StadiumTester();
        Squirtle coolGuy = new Squirtle();
        Charmander hotGuy = new Charmander();
        DeckCreator deck1 = new DeckCreator();
        PokemonGame game = new PokemonGame();
        //battle.battle(coolGuy, hotGuy);
        ArrayList<Card> deck = deck1.createElectricDeck();
        /*game.setDeck(deck);
        deck = game.getDeck();
        game.shuffleDeck(deck);
        game.drawHand(deck);
        game.printHand();*/
        deck1.createMonteDeck();
    }
}
