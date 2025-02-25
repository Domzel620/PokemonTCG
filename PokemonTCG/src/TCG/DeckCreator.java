package src.TCG;

import java.util.ArrayList;

import src.TCG.EnergyCards.EnergyTypes.*;
import src.TCG.PokemonCards.Pokemon;
import src.TCG.PokemonCards.PokemonCreatures.*;
import src.TCG.TrainerCards.TrainerCardTypes.RareCandy;
import src.TCG.PokemonGame;


public class DeckCreator {
    private ArrayList<Card> fire;
    private ArrayList<Card> water;
    private ArrayList<Card> electric;
    //Creates a fire deck filled with 20 charmander and 40 water energy
    public ArrayList<Card> createFireDeck(){
        ArrayList<Card> fireDeck = new ArrayList<Card>();
        for(int i = 0; i < 20; i++){
            fireDeck.add(new Charmander());
        }
        for(int i = 20; i < 60; i++){
            fireDeck.add(new FireEnergy());
        }
        return fireDeck;
    }
    //Creates a water deck filled with 20 squirtle and 40 water energy
    public ArrayList<Card> createWaterDeck(){
        ArrayList<Card> waterDeck = new ArrayList<Card>();
        for(int i = 0; i < 20; i++){
            waterDeck.add(new Squirtle());
        }
        for(int i = 20; i < 24; i++){
            waterDeck.add(new RareCandy());
        }
        for(int i = 24; i < 60; i++){
            waterDeck.add(new WaterEnergy());
        }
        return waterDeck;
    }
    //Creates an Electric deck filled with 20 Pikachu and 40 electric energy
    public ArrayList<Card> createElectricDeck(){
        ArrayList<Card> electricDeck = new ArrayList<Card>();
        for(int i = 0; i < 1; i++){
            electricDeck.add(new Pikachu());
        }
        for(int i = 1; i < 60; i++){
            electricDeck.add(new ElectricEnergy());
        }
        return electricDeck;
    }
    //This prints any of the decks that the user creates
    public void printDeck(ArrayList<Card> deck){
        int i = 1;
        for(Card cards : deck){
            System.out.println(i + ". " + cards.getClass().getSimpleName());
            i++;
        }
    }
    
    
}
