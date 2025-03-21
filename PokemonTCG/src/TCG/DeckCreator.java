package src.TCG;

import com.sun.source.tree.Tree;
import java.util.ArrayList;

import src.TCG.EnergyCards.EnergyTypes.*;
import src.TCG.PokemonCards.Pokemon;
import src.TCG.PokemonCards.PokemonCreatures.*;
import src.TCG.TrainerCards.TrainerCardTypes.RareCandy;
import src.TCG.PokemonGame;
import src.TCG.TrainerCards.TrainerCardTypes.*;


public class DeckCreator {
    private ArrayList<Card> fire;
    private ArrayList<Card> water;
    private ArrayList<Card> electric;
    //Creates a fire deck filled with 20 charmander and 40 water energy
    public ArrayList<Card> createFireDeck(){
        ArrayList<Card> fireDeck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            fireDeck.add(new Charmander());
        }
        for(int i = 4; i < 7; i++){
            fireDeck.add(new Chimchar());
        }
        for(int i = 7; i < 10; i ++){
            fireDeck.add(new Cyndaquill());
        }
        for(int i = 10; i < 13; i++){
            fireDeck.add(new Potion());
        }
        for(int i = 13; i < 16; i++){
            fireDeck.add(new GiantCape());
        }
        for(int i = 16; i < 19; i++){
            fireDeck.add(new Potion());
        }
        for(int i = 19; i < 60; i++){
            fireDeck.add(new FireEnergy());
        }
        return fireDeck;
    }
    //Creates a water deck filled with 20 squirtle and 40 water energy
    public ArrayList<Card> createWaterDeck(){
        ArrayList<Card> waterDeck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            waterDeck.add(new Squirtle());
        }
        for(int i = 4; i < 7; i++){
            waterDeck.add(new Magikarp());
        }
        for(int i = 7; i < 10; i ++){
            waterDeck.add(new Lapras());
        }
            for(int i = 10; i < 13; i++){
                waterDeck.add(new Potion());
            }
            for(int i = 13; i < 16; i++){
                waterDeck.add(new GiantCape());
            }
            for(int i = 16; i < 19; i++){
                waterDeck.add(new Potion());
            }
            for(int i = 19; i < 60; i++){
                waterDeck.add(new WaterEnergy());
            }
        return waterDeck;
    }
    //Creates an Electric deck filled with 20 Pikachu and 40 electric energy
    public ArrayList<Card> createElectricDeck(){
        ArrayList<Card> electricDeck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            electricDeck.add(new Pikachu());
        }
        for(int i = 4; i < 7; i++){
            electricDeck.add(new Magnemite());
        }
        for(int i = 7; i < 10; i ++){
            electricDeck.add(new Voltorb());
        }
        for(int i = 10; i < 13; i++){
            electricDeck.add(new Potion());
        }
        for(int i = 13; i < 16; i++){
            electricDeck.add(new GiantCape());
        }
        for(int i = 16; i < 19; i++){
            electricDeck.add(new Potion());
        }
        for(int i = 19; i < 60; i++){
            electricDeck.add(new ElectricEnergy());
        }
        return electricDeck;
    }

    public ArrayList<Card> createGrassDeck(){
        ArrayList<Card> grassDeck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            grassDeck.add(new Bulbasaur());
        }
        for(int i = 4; i < 7; i++){
            grassDeck.add(new Treeko());
        }
        for(int i = 7; i < 10; i ++){
            grassDeck.add(new Scyther());
        }
        for(int i = 10; i < 13; i++){
            grassDeck.add(new Potion());
        }
        for(int i = 13; i < 16; i++){
            grassDeck.add(new GiantCape());
        }
        for(int i = 16; i < 19; i++){
            grassDeck.add(new Potion());
        }
        for(int i = 19; i < 60; i++){
            grassDeck.add(new GrassEnergy());
        }
        return grassDeck;
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
