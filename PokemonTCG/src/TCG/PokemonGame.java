package src.TCG;

import java.util.ArrayList;
import java.util.Random;
import src.TCG.PokemonCards.*;
public class PokemonGame {
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> prize;
    private ArrayList<Card> discard;
    private ArrayList<Card> bench;
    private ArrayList<Card> active;

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
    public void drawHand(ArrayList<Card> userDeck){
        hand = new ArrayList<Card>();
        for(int i = 0;  i < 7; i++){
            hand.add(userDeck.get(i));
            userDeck.remove(i);
        }
        //While loop to check if a Pokemon is present in the hand
        while (true) { 
            for(Card cards : hand){
                if(cards instanceof Pokemon){
                    System.out.println("Your hand has a pokemon");
                    break;
                }
            }
            //For loop that readds the card from the hand 
            //into the deck and then shuffles the deck
            int k = 0;
            for(Card cards : hand){
                userDeck.add(cards);
                hand.remove(k);
                k++;  
            }
            shuffleDeck(userDeck);
            //Redraws player hand
            for(int i = 0;  i < 7; i++){
                hand.add(userDeck.get(i));
                userDeck.remove(i);
            }
        }   
    }
    //This prints the users Hand
    public void printHand(ArrayList<Card> userHand) {
        int i = 1;
        for(Card card : userHand) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }
    
    public void setDeck(ArrayList<Card> userDeck){
        deck = userDeck;
    }
    //This shuffles the users deck
    public void shuffleDeck(ArrayList<Card> userDeck){
        Random shuffle = new Random();
        for(int i = userDeck.size()-1; i > 0; i--){
            int j = shuffle.nextInt(i+1);
            Card temp = userDeck.get(i);
            userDeck.set(i,  userDeck.get(j));
            userDeck.set(i, temp);
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
