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
    
        // Checks if a Pokemon is hand
        boolean hasPokemon = checkHand(userDeck, hand);
        //Loops until there is finally a hand with a pokemon in it.
        while(hasPokemon == false){
            hasPokemon = checkHand(userDeck, hand);
        }
    }
    
    //This prints the users Hand
    public void printHand() {
        int i = 1;
        System.out.println("\n" + "The cards in your hand: ");
        for(Card card : hand) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }


    public boolean checkHand(ArrayList<Card> userDeck, ArrayList<Card> userHand){
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                System.out.println("Your hand has a pokemon");
                //printHand();
                return true;
            } 
        }
        System.out.println("No Pokemon in this hand");
        //printHand();
        userDeck.addAll(hand);
        hand.clear();   
        shuffleDeck(userDeck);
    
        // Redraws the hand
        for (int i = 0; i < 7; i++) {
            hand.add(userDeck.get(i));
        }
    
        // Removes drawn cards from the deck
        for (int i = 6; i >= 0; i--) {
            userDeck.remove(i);
        }
        return false;
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
    public void printPrize(){
        int i = 1;
        System.out.println("\n" + "The Cards in your prize pool are: ");
        for(Card card : prize) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }
    
}
