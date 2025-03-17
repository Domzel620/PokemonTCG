package src.TCG;

import java.awt.Choice;
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
    private ArrayList<Card> oneDiscard;
    private ArrayList<Card> twoDiscard;
    private ArrayList<Card> oneBench;
    private ArrayList<Card> twoBench;
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
    public ArrayList<Card> getOneDiscard(){
        return oneDiscard;
    }
    public ArrayList<Card> getTwoDiscard(){
        return twoDiscard;
    }
    public ArrayList<Card> getOneBench(){
        return oneBench;
    }
    public ArrayList<Card> getTwoBench(){
        return twoBench;
    }
    public ArrayList<Card> getOneActive(){
        return oneActive;
    }
    public ArrayList<Card> getTwoActive(){
        return twoActive;
    }

    public PokemonGame() {
        oneHand = new ArrayList<>();
        twoHand = new ArrayList<>();
        playerOneDeck = new ArrayList<>();
        playerTwoDeck = new ArrayList<>();
        onePrize = new ArrayList<>();
        twoPrize = new ArrayList<>();
        oneDiscard = new ArrayList<>();
        twoDiscard = new ArrayList<>();
        oneBench = new ArrayList<>();
        twoBench = new ArrayList<>();
        oneActive = new ArrayList<>(); 
        twoActive = new ArrayList<>(); 
    }

//-----------------------------------------------------------------------------------------------------Hand/Deck Modifier Methods-------------------------------------------------------------------------------------------------------------------------



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

    //----------------------------------------------------------------------------------------------------------Misc. GameLoop Methods------------------------------------------------------------------------------------------------------------------

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



//-------------------------------------------------------------------------------------------------------------Player Move Methods-----------------------------------------------------------------------------------------------------------------------------------
    public int Attack(ArrayList<Card> oneActive, ArrayList<Card> twoActive){
        int hp = 0;//placeholder 
        return hp;
    }

    

    //-------------------------------------------------------------------------------------------Placing Pokemon Methods---------------------------------------------------------------------------------------------------------------------------------------------

    //Code for placing down an Active Pokemon
    public ArrayList<Card> placeActive(ArrayList<Card> userHand, ArrayList<Card> userActive){
        Scanner select = new Scanner(System.in);
        ArrayList<Card> temp = userHand;
        printHand(userHand);
        System.out.println("Which Pokemon would you like to play?");
        boolean validChoice = false;
        while(validChoice == false){
            int choice = select.nextInt();
            if(temp.get(choice - 1) instanceof Pokemon){ 
                if(choice >= 0 && choice <= userHand.size()){
                    userActive.add(temp.get(choice - 1));
                    userHand.remove(choice);
                    validChoice = true;
                } else{
                    System.out.println("Invalid Choice, please select another card!");
                }
            } else{
                System.out.println("Invalid Choice, please select a Pokemon!");
            }
            
            
        }
        return userActive;
        
    }
        
   

    public ArrayList<Card> placeBench(ArrayList<Card> userHand, ArrayList<Card> userBench){
        Scanner select = new Scanner(System.in);
        ArrayList<Card> temp = userHand;
        printHand(userHand);
        System.out.println("Which Pokemon would you like to place into your Bench?");
        boolean validChoice = false;
        while(validChoice == false){
            int choice = select.nextInt() ;
            if(temp.get(choice - 1) instanceof Pokemon){ 
                if(choice >= 0 && choice <= userHand.size()){
                    userBench.add(temp.get(choice - 1));
                    userHand.remove(choice-1);
                    validChoice = true;
                } else{
                    System.out.println("Invalid Choice, please select another card!");
                }
            } else{
                System.out.println("Invalid Choice, please select a Pokemon!");
            }
            
            
        }
        return userBench;
    }
    public String printBench(ArrayList<Card> userBench){
        String bench = "";
        int num = 1;
        for(Card card : userBench){
            bench = bench + num + ". " + card + ", ";
            num++;
        }
        return bench;
    }


    //Prints the battleboard (Extra Credit)
    public void printBoard(ArrayList<Card> userOneBench, ArrayList<Card> userTwoBench, ArrayList<Card> userOneActive, ArrayList<Card> userTwoActive){
        System.out.println("-----------------------------------------------------------------------------\n \n");
        System.out.println("Player 1 Side");
        System.out.println("\nBENCH: " + printBench(userOneBench)+ "\n");
        if(userOneActive != null && !userOneActive.isEmpty()){
            System.out.println("\n ACTIVE: " + ((Pokemon)userOneActive.get(0)).cardSum());
        }else{
            System.out.println("\nACTIVE: N/A");
        }
        
        System.out.println("\n \n------------------------------------(-0-)------------------------------------\n \n");
    
        if(userTwoActive != null && !userTwoActive.isEmpty()){
            System.out.println("\n ACTIVE: " + ((Pokemon)userTwoActive.get(0)).cardSum() + "\n");
        }else{
            System.out.println("\n ACTIVE: N/A");
        }
        System.out.println("\n BENCH: " + printBench(userTwoBench)+ "\n");
        System.out.println("Player 2 Side");
        System.out.println("\n \n-----------------------------------------------------------------------------");

    }

//-----------------------------------------------------------------------------------------Player Turns-----------------------------------------------------------------------------------------------------------------------------------------

    //Code for when Player 1 wins the coinflip
    public void playerOneFirst(){
        Scanner turn = new Scanner(System.in);
        boolean endCheck = gameOver();
        while (endCheck == false){     
            boolean endTurn = false;
            drawCard(oneHand, playerOneDeck);
            printBoard(oneBench, twoBench, oneActive, twoActive);
            System.out.println("\nPlayer 1 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
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
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 3:
                    // Call Place Active Pokemon Method
                            if(oneActive.size() > 0){
                                System.out.println("Active Slot full please pick another option!");
                                break;
                            } else{
                                oneActive = placeActive(oneHand, oneActive);
                                printBoard(oneBench, twoBench, oneActive, twoActive);
                                System.out.println("You placed a Pokemon. What else would you like to do?");
                                System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                                break;
                            }
                    case 4:
                    //Call Place Bench Pokemon Method
                        if(oneBench.size() > 6){
                            System.out.println("Bench Full,pick another option!");
                            break;
                        } else{
                            oneBench = placeBench(oneHand, oneBench);
                            printBoard(oneBench, twoBench, oneActive, twoActive);
                        }
                    case 5:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 6:
                        printHand(oneHand);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 7:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                        
                }
            }
            printBoard(oneBench, twoBench, oneActive, twoActive);
            endCheck = gameOver();
            System.out.println("\nPlayer 2 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
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
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 3:
                    // Call Place Pokemon Method 
                    if(twoActive.size() > 0){
                        System.out.println("Active Slot full please pick another option!");
                        break;
                    } else{
                        twoActive = placeActive(twoHand, twoActive);
                        printBoard(oneBench, twoBench, oneActive, twoActive);
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    }
                    case 4:
                    // Call Place Bench Pokemon
                        if(twoBench.size() > 6){
                            System.out.println("Bench Full, pick another option!");
                            break;
                        } else{
                            twoBench = placeBench(twoHand, twoBench);
                            printBoard(oneBench, twoBench, oneActive, twoActive);
                        }
                    case 5:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 6:
                        printHand(twoHand);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 7:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                }          
            }
            printBoard(oneBench, twoBench, oneActive, twoActive);
            endCheck = gameOver();
        }
    }

    



    //Code for when Player 2 wins the coin flip
    public void playerTwoFirst(){
        Scanner turn = new Scanner(System.in);
        boolean endCheck = gameOver();
        printBoard(oneBench, twoBench, oneActive, twoActive);
        while (endCheck == false){
            System.out.println("\nPlayer 2 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
            boolean endTurn = false;
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
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 3:
                    // Call Place Pokemon Method 
                    if(twoActive.size() > 0){
                        System.out.println("Active Slot full please pick another option!");
                        break;
                    } else{
                        twoActive = placeActive(twoHand, twoActive);
                        printBoard(oneBench, twoBench, oneActive, twoActive);
                        System.out.println("You placed a Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    }
                    case 4:
                    // Call Place Bench Pokemon
                        if(twoBench.size() > 6){
                            System.out.println("Bench Full, pick another option!");
                            break;
                        } else{
                            twoBench = placeBench(twoHand, twoBench);
                            printBoard(oneBench, twoBench, oneActive, twoActive);
                        }
                    case 5:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 6:
                        printHand(twoHand);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 7:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                }          
            }
            printBoard(oneBench, twoBench, oneActive, twoActive);
            endCheck = gameOver();
            System.out.println("\nPlayer 1 What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
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
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 3:
                    // Call Place Active Pokemon Method
                            if(oneActive.size() > 0){
                                System.out.println("Active Slot full please pick another option!");
                                break;
                            } else{
                                oneActive = placeActive(oneHand, oneActive);
                                printBoard(oneBench, twoBench, oneActive, twoActive);
                                System.out.println("You placed a Pokemon. What else would you like to do?");
                                System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                                break;
                            }
                    case 4:
                    //Call Place Bench Pokemon Method
                        if(oneBench.size() > 6){
                            System.out.println("Bench Full,pick another option!");
                            break;
                        } else{
                            oneBench = placeBench(oneHand, oneBench);
                            printBoard(oneBench, twoBench, oneActive, twoActive);
                        }
                    case 5:
                    // Call Evolve Method
                        System.out.println("You Evolved your Pokemon. What else would you like to do?");
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 6:
                        printHand(oneHand);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Evolve \n 6. Show Hand \n 7. Pass");
                        break;
                    case 7:
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                        
                }
            }
            printBoard(oneBench, twoBench, oneActive, twoActive);
            endCheck = gameOver();
        }
    }


//-------------------------------------------------------------------------------------------------------------Main Game Loop------------------------------------------------------------------------------------------------------------------

    //MAIN GAME LOOP
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
