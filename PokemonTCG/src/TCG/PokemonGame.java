package src.TCG;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
import javax.swing.text.AbstractDocument;
import src.TCG.PokemonCards.*;
import src.TCG.DeckCreator;
public class PokemonGame {
    private ArrayList<Card> oneHand;
    private ArrayList<Card> twoHand;
    private ArrayList<Card> playerOneDeck;
    private ArrayList<Card> playerTwoDeck;
    private ArrayList<Card> onePrize;
    private ArrayList<Card> twoPrize;
    private ArrayList<Card> discard;
    private ArrayList<Card> bench;
    private ArrayList<Card> oneActive;
    private ArrayList<Card> twoActive;
    //Getters for the global variables above.
    public ArrayList<Card> getOneHand(){
        return oneHand;
    }
    public ArrayList<Card> getTwoHand(){
        return twoHand;
    }
    public ArrayList<Card> getPlayerOneDeck(){
        return playerOneDeck;
    }
    public ArrayList<Card> getPlayerTwoDeck(){
        return playerTwoDeck;
    }
    public ArrayList<Card> getOnePrize(){
        return onePrize;
    }
    public ArrayList<Card> getTwoPrize(){
        return onePrize;
    }
    public ArrayList<Card> getDiscard(){
        return discard;
    }
    public ArrayList<Card> getBench(){
        return bench;
    }
    public ArrayList<Card> getOneActive(){
        return oneActive;
    }
    public ArrayList<Card> getTwoActive(){
        return oneActive;
    }


    //Method used to draw 7 cards into the users hand.
    public ArrayList<Card> drawHand(ArrayList<Card> userDeck) {
        // Initialize hand
        ArrayList<Card> hand = new ArrayList<Card>();
        
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
        return hand;
    }
    

    //This prints the users Hand
    public void printHand(ArrayList<Card> hand) {
        int i = 1;
        System.out.println("\n" + "The cards in your hand: ");
        for(Card card : hand) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }


    public boolean checkHand(ArrayList<Card> userDeck, ArrayList<Card> userHand){
        for (Card card : userHand) {
            if (card instanceof Pokemon) {
                System.out.println("Your hand has a pokemon");
                //printHand();
                return true;
            } 
        }
        System.out.println("No Pokemon in this hand");
        //printHand();
        userDeck.addAll(userHand);
        userHand.clear();   
        shuffleDeck(userDeck);
    
        // Redraws the hand
        for (int i = 0; i < 7; i++) {
            userHand.add(userDeck.get(i));
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
    public ArrayList<Card> fillPrize(ArrayList<Card> userDeck){
        ArrayList<Card> userPrize = new ArrayList<Card>();
        for(int i = 0;  i < 7; i++){
            userPrize.add(userDeck.get(i));
            userDeck.remove(i);
        }
        return userPrize;
    }
    public void printPrize(ArrayList<Card> userPrize){
        int i = 1;
        System.out.println("\n" + "The Cards in your prize pool are: ");
        for(Card card : userPrize) {
            System.out.println(i + ". " + card.getClass().getSimpleName());
            i++; 
        }
    }


    //Draw Card Method
    public void drawCard(ArrayList<Card> userHand, ArrayList<Card> userDeck){
        userHand.add(userDeck.get(0));
        userDeck.remove(0);
    }


    //Method for Coinflip method
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
        //Ask professor the benefit of using a switch here instead of the if statements
        switch (selection) {
            case 1:
                System.out.println("You've Selected the Electric Deck!");
                tempDeck = deck.createElectricDeck();
                break;
            case 2:
                System.out.println("You've Selected the Fire Deck!");
                tempDeck = deck.createFireDeck();
                break;
            case 3:
                System.out.println("You've Selected the Water Deck!");
                tempDeck = deck.createWaterDeck();
                break;
            default:
                break;
        }
        return tempDeck;
    }

    //Checks to See if a game over clause is in play
    public boolean gameOver(){
        boolean end;
        if (onePrize.size() < 1){
            System.out.println("Player 1 Wins!");
            end = true; 
        } else if (twoPrize.size() < 1){
            System.out.println("Player 2 Wins!");
            end = true;
        } else if (playerOneDeck.size() < 1){
            System.out.println("Player 2 Wins!");
            end = true;
        } else if (playerTwoDeck.size() < 1){
            System.out.println("Player 1 Wins!");
            end = true;
        } else {
            end = false;
        }
        return end;
    }

    //NOT COMPLETE
    public ArrayList<Card> placeActive(ArrayList<Card> userHand, ArrayList<Card> userActive){
        Scanner select = new Scanner(System.in);
        ArrayList<Card> temp = userHand;
        printHand(userHand);
        System.out.println("Which Pokemon would you like to play?");
        int choice = select.nextInt();
        
        
        
            userActive.add(temp.get(choice));
            userHand.remove(choice);
            return userActive;
        }
        
    public int Attack(ArrayList<Card> oneActive, ArrayList<Card> twoActive){
        int hp = 0;//placeholder 
        return hp;
    }



    //Code for when Player 1 wins the coinflip
    public void playerOneFirst(){
        Scanner turn = new Scanner(System.in);
        boolean endCheck = gameOver();
        while (endCheck == false){
            System.out.println("\nPlayer 1 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place Active Pokemon \n 4. Evolve \n 5. Show Hand \n 6. Pass");
            boolean endTurn = false;
            drawCard(oneHand, playerOneDeck);
            while(endTurn == false){
                int move = turn.nextInt();
                switch (move){
                    case 1:
                    // Call Attack Method
                    System.out.println("You Attacked!");
                        endTurn = true;
                        break;
                    case 2:
                    // Call Attach Energy Method
                    System.out.println("You Attached an Energy. What else would you like to do?");
                        break;
                    case 3:
                    // Call Place Active Pokemon Method 
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        oneActive = placeActive(oneHand, oneActive);
                        System.out.println("ACTIVE: " + oneActive);
                        break;
                    case 4:
                    // Call Evolve Method
                    System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        break;
                    case 5:
                        printHand(oneHand);
                        break;
                    case 6:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                        
                }
            }
            endCheck = gameOver();
            System.out.println("\nPlayer 2 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place Pokemon \n 4. Evolve \n 5. Show Hand \n 6. Pass");
            endTurn = false;
            drawCard(twoHand, playerTwoDeck);
            while(endTurn == false){
                int move = turn.nextInt();
                switch (move){
                    case 1:
                    // Call Attack Method
                        System.out.println("You Attacked!");
                        endTurn = true;
                        break;
                    case 2:
                    // Call Attach Energy Method
                        System.out.println("You Attached an Energy. What else would you like to do?");
                        break;
                    case 3:
                    // Call Place Pokemon Method 
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        break;
                    case 4:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        break;
                    case 5:
                        printHand(twoHand);
                        break;
                    case 6:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                }          
            }
            endCheck = gameOver();
        }
    }

    
    //Code for when Player 2 wins the coin flip
    public void playerTwoFirst(){
        Scanner turn = new Scanner(System.in);
        boolean endCheck = gameOver();
        while (endCheck == false){
            System.out.println("\nPlayer 2 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place Pokemon \n 4. Evolve \n 5. See Hand \n 6. Pass");
            boolean endTurn = false;
            drawCard(oneHand, playerOneDeck);
            while(endTurn == false){
                int move = turn.nextInt();
                switch (move){
                    case 1:
                    // Call Attack Method
                        System.out.println("You Attacked!");
                        endTurn = true;
                        break;
                    case 2:
                    // Call Attach Energy Method
                        System.out.println("You Attached an Energy. What else would you like to do?");
                        break;
                    case 3:
                    // Call Place Pokemon Method 
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        break;
                    case 4:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        break;
                    case 5:
                        printHand(twoHand);
                        break;
                    case 6:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                }
            }
            endCheck = gameOver();
            System.out.println("\nPlayer 1 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place Pokemon \n 4. Evolve \n 5. Show Hand \n 6. Pass");
            endTurn = false;
            drawCard(oneHand, playerOneDeck);
            while(endTurn == false){
                int move = turn.nextInt();
                switch (move){
                    case 1:
                    // Call Attack Method
                        System.out.println("You Attacked!");
                        endTurn = true;
                        break;
                    case 2:
                    // Call Attach Energy Method
                        System.out.println("You Attached an Energy. What else would you like to do?");
                        break;
                    case 3:
                    // Call Place Pokemon Method 
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        break;
                    case 4:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        break;
                    case 5: 
                        printHand(oneHand);
                        break;
                    case 6:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                }          
            }
            endCheck = gameOver();
        }
    }

    public void gameLoop(){
        //Players Choose their Decks
        System.out.println("Player 1, please create your deck and get set up");
        playerOneDeck = chooseDeck();
        shuffleDeck(playerOneDeck);
        oneHand = drawHand(playerOneDeck);
        onePrize = fillPrize(playerOneDeck);

        System.out.println("\nPlayer 2, please create your deck and get set up");
        playerTwoDeck = chooseDeck();
        shuffleDeck(playerTwoDeck);
        twoHand = drawHand(playerTwoDeck);
        twoPrize = fillPrize(playerTwoDeck);


        //Coin flip then game start.
        boolean playOrder = coinFlip();
        if(playOrder == true){
            System.out.println("Player 1 is up first!");
            playerOneFirst();
        }else if(playOrder == false){
            System.out.println("Player 2 is up first!");
            playerTwoFirst();
        }
    }
    
}
