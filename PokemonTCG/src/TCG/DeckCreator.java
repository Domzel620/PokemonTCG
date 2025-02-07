package src.TCG;

import src.TCG.EnergyCards.EnergyTypes.*;
import src.TCG.PokemonCards.PokemonCreatures.*;


public class DeckCreator {
    //Creates a fire deck filled with 20 charmander and 40 water energy
    public Card[] createFireDeck(){
        Card[] fireDeck = new Card[60];
        for(int i = 0; i < 20; i++){
            fireDeck[i] = new Charmander();
        }
        for(int i = 20; i < 60; i++){
            fireDeck[i] = new FireEnergy();
        }
        return fireDeck;
    }
    //Creates a water deck filled with 20 squirtle and 40 water energy
    public Card[] createWaterDeck(){
        Card[] waterDeck = new Card[60];
        for(int i = 0; i < 20; i++){
            waterDeck[i] = new Squirtle();
        }
        for(int i = 20; i < 60; i++){
            waterDeck[i] = new WaterEnergy();
        }
        return waterDeck;
    }
    //Creates an Electric deck filled with 20 Pikachu and 40 electric energy
    public Card[] createElectricDeck(){
        Card[] electricDeck = new Card[60];
        for(int i = 0; i < 20; i++){
            electricDeck[i] = new Pikachu();
        }
        for(int i = 20; i < 60; i++){
            electricDeck[i] = new ElectricEnergy();
        }
        return electricDeck;
    }
    //This prints any of the decks that the user creates
    public void printDeck(Card[] deck){
        int i = 1;
        for(Card cards : deck){
            System.out.println(i + ". " + cards.getClass().getSimpleName());
            i++;
        }
    }
}
