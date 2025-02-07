package src.TCG;

import java.util.ArrayList;
import java.lang.Math;
import src.TCG.PokemonCards.*;
public class PokemonGame {
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> prize;
    private ArrayList<Card> discard;
    private ArrayList<Card> bench;
    private ArrayList<Card> active;
    //Getters for the global variables above.
    public ArrayList<Card> getHand(){
        return hand;
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }
    public ArrayList<Card> getPrize(){
        return prize;
    }
    public ArrayList<Card> getDiscard(){
        return discard;
    }
    public ArrayList<Card> getBench(){
        return bench;
    }
    public ArrayList<Card> getActive(){
        return active;
    }
    //Method used to draw 7 cards into the users hand.
    public void drawHand(ArrayList<Card> userDeck) {
        // Initialize hand
        hand = new ArrayList<Card>();
        
        // Draw 7 cards
        for (int i = 0; i < 7; i++) {
            hand.add(userDeck.get(i));
        }
        
        for (int i = 6; i >= 0; i--) {
            userDeck.remove(i); 
        }
    
        // Check if a Pokemon is in the hand
        boolean hasPokemon = false;
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                System.out.println("Your hand has a pokemon");
                hasPokemon = true;
                break;
            }
        }
    
        // If you need to reshuffle and redraw (the current logic)
        if (!hasPokemon) {
            System.out.println("No Pokemon in this hand");
            userDeck.addAll(hand);
            hand.clear();  // Clear the hand
    
            // Shuffle deck
            shuffleDeck(userDeck);
    
            // Redraw the hand
            for (int i = 0; i < 7; i++) {
                hand.add(userDeck.get(i));
            }
    
            // Remove drawn cards from the deck
            for (int i = 6; i >= 0; i--) {
                userDeck.remove(i);
            }
        }
    }
    
    //This prints the users Hand
    public void printHand() {
        int i = 1;
        for(Card card : hand) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }
    
    public void setDeck(ArrayList<Card> userDeck){
        deck = userDeck;
    }
    //This shuffles the users deck
    public void shuffleDeck(ArrayList<Card> userDeck){
        for(int i = userDeck.size()-1; i > 0; i--){
            int shuffle = (int)(Math.random() * userDeck.size());
            int j = shuffle;
            Card temp = userDeck.get(i);
            userDeck.set(i,  userDeck.get(j));
            userDeck.set(j, temp);
        }
    }
    //This draws the prize cards
    public void fillPrize(ArrayList<Card> userDeck){
        prize = new ArrayList<Card>();
        for(int i = 0;  i < 7; i++){
            prize.add(userDeck.get(i));
            userDeck.remove(i);
        }
    }
    
}
