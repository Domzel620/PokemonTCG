package src.TCG;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
import src.TCG.PokemonCards.*;
import src.TCG.DeckCreator;
public class PokemonGame {
    private ArrayList<Card> hand;
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private ArrayList<Card> prize;
    private ArrayList<Card> discard;
    private ArrayList<Card> bench;
    private ArrayList<Card> active;
    //Getters for the global variables above.
    public ArrayList<Card> getHand(){
        return hand;
    }
    public ArrayList<Card> getPlayerOneDeck(){
        return playerOneDeck;
    }
    public ArrayList<Card> getPlayerTwoDeck(){
        return playerTwoDeck;
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
    public void drawCard(ArrayList<Card> userHand, ArrayList<Card> userDeck){
        userHand.add(userDeck.get(0));
        userDeck.remove(0);
    }

    public boolean coinFlip(){
        double coin = Math.random();
        if(coin < 0.5){
            return true;
        }else{
            return false;
        }
        
    }

    //Prompts the player to select a deck type
    public ArrayList<Card> chooseDeck(){
        Scanner deckSelection = new Scanner(System.in);
        ArrayList<Card> tempDeck = new ArrayList<>();
        DeckCreator deck = new DeckCreator();
        int selection;

        System.out.println("Which Deck would you like to use?" + "\n 1. Electric" + "\n 2. Fire" + "\n 3. Water");
        System.out.println("Please input one of the numbers above: ");
        selection = deckSelection.nextInt();
        while (selection > 3 || selection < 1){
            System.out.println("Invalid Selection, please pick an option between 1-3!");
                selection = deckSelection.nextInt();
        }
        deckSelection.close();
        //Ask professor the benefit of using a switch here instead of the if statements
        if(selection == 1){
            System.out.println("You've Selected the Electric Deck!");
            tempDeck = deck.createElectricDeck();
        }else if(selection == 2){
            System.out.println("You've Selected the Fire Deck!");
            tempDeck = deck.createFireDeck();
        }else if(selection == 3){
            System.out.println("You've Selected the Water Deck!");
            tempDeck = deck.createWaterDeck();
        }
        return tempDeck;
    }

    public void gameLoop(){
        //Players Choose their Decks
        System.out.println("Player 1, please create your deck and get set up");
        playerOneDeck = chooseDeck();
        shuffleDeck(playerOneDeck);
        drawHand(playerOneDeck);
        fillPrize(playerOneDeck);

        System.out.println("Player 2, please create your deck and get set up");
        playerTwoDeck = chooseDeck();
        shuffleDeck(playerTwoDeck);
        drawHand(playerTwoDeck);
        fillPrize(playerTwoDeck);

        boolean playOrder = coinFlip();
        if(playOrder = true){
             
        }
    }
    
}
