package src.TCG;

import java.awt.Choice;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
import src.TCG.PokemonCards.*;
import src.TCG.EnergyCards.Energy;
import src.TCG.TrainerCards.TrainerCard;
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
    
        // Checks if a Pokemon is in hand
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

    //This method is used to check the hand of the player, ensuring there is a pokemon in it
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
        for(int i = 0;  i < 6; i++){
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

        System.out.println("Which Deck would you like to use?" + "\n 1. Electric" + "\n 2. Fire" + "\n 3. Water \n 4. Grass");
        System.out.println("Please input one of the numbers above: ");
        selection = deckSelection.nextInt();
        while (selection > 4 || selection < 1){
            System.out.println("Invalid Selection, please pick an option between 1-44!");
                selection = deckSelection.nextInt();
        }
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
            case 4: System.out.println("You've Selected the Grass Deck!");
                tempDeck = deck.createGrassDeck();
            default:
                break;
        }
        return tempDeck;
    }
    //This method is called in the gameOver() method and is used to make sure a player can make a move on their turn
    public boolean checkPlayables(ArrayList<Card> userHand, ArrayList<Card> userBench, ArrayList<Card> userActive){
        boolean end = false;
        int numberCheck = 0;
        for (Card card : userHand) {
            if (card instanceof Pokemon) {
                numberCheck++;  
            } 
        }
        for (Card card : userBench){
            if(card instanceof Pokemon){
                numberCheck++;
            }
        }
        for(Card card : userActive){
            if(card instanceof Pokemon){
                numberCheck++;
            }
        }
        if(numberCheck == 0){
            end = true;
        }
        
        return end;
    }

    //Checks to See if a game over clause is in play
    public boolean gameOver(){
        boolean end = false;

        if (onePrize.size() < 1){
            System.out.println("Player 1 Wins!");
            System.exit(0);
        } else if (twoPrize.size() < 1){
            System.out.println("Player 2 Wins!");
            System.exit(0);
        } else if (playerOneDeck.size() < 1){
            System.out.println("Player 2 Wins!");
            System.exit(0);
        } else if (playerTwoDeck.size() < 1){
            System.out.println("Player 1 Wins!");
            System.exit(0);
        }else if(checkPlayables(oneHand, oneBench, oneActive) == true){
            System.out.println("Player 2 Wins!");
            System.exit(0);
        }else if (checkPlayables(twoHand, twoBench, twoActive) == true) {
            System.out.println("Player 1 Wins!");
            System.exit(0);
        }else {
            end = false;
        }
        return end;
    }



//-------------------------------------------------------------------------------------------------------------Player Move Methods-----------------------------------------------------------------------------------------------------------------------------------

    //This is the method that allows the user to attack their opponent
    public boolean attack(ArrayList<Card> userAttacker, ArrayList<Card> userDefender, ArrayList<Card> userHand, ArrayList<Card> userPrize){
        Pokemon attacker = ((Pokemon)userAttacker.get(0));
        Pokemon defender = ((Pokemon)userDefender.get(0));
        int cost = attacker.getEnergyBank().size();
        if(cost >= attacker.getMoveCost()){
           int damage = attacker.useMove(attacker, defender);
           defender.setHp(defender.getHp()-damage);
           System.out.println("YOU HIT " + defender + " FOR " + damage +"!!!!");
           System.out.println(defender +" is at " + defender.getHp() + " hp!");
        }else{
            System.out.println("NOT ENOUGH ENERGY!!!");
        }
        if(defender.getHp() <= 0){
            userHand.add(userPrize.get(0));
            userPrize.remove(0);
            System.out.println("You've Earned a prize Card!!!");
            return true;
        }else{
            return false;
        }
       
    }

    //Method to Attach Energy
    public int attachEnergy(ArrayList<Card> userActive, ArrayList<Card> userBench, ArrayList<Card> userHand, int energy){
        Scanner select = new Scanner(System.in);
        System.out.println("Would you like to attach energy to your \n 1. Active Pokemon \n 2. Bench Pokemon");
        int choice = select.nextInt();
        switch (choice){
            case 1://Case when the player wants to attach an energy to their active pokemon
                if(userActive != null && !userActive.isEmpty()){               
                        System.out.println("Which Energy would you like to select?");
                        printHand(userHand);
                        int pick = select.nextInt();
                        if(pick >= 1 && pick <= userHand.size()){
                            if(userHand.get(pick-1) instanceof Energy){
                                ((Pokemon)userActive.get(0)).addEnergy(userHand.get(pick-1));
                                userHand.remove(pick-1);
                                energy = 1;//Prevents player from attaching another energy in their turn
                                break;
                            }else{
                                System.out.println("Invalid Selection, Please pick an Energy Card!");
                                break;
                            }
                    }else{
                        System.out.println("Invalid Selection, Please pick one of the options listed");
                        printHand(userHand);
                        break;
                    }
                    
                }else{
                    System.out.println("No Active Pokemon!");
                    break;
                }   
            case 2://Case when the player wants to attach an energy to one of their bench pokemon
                if(userBench != null && !userBench.isEmpty()){
                    System.out.println("Which Bench Pokemon would you like to select?");
                    System.out.println(printBench(userBench));
                    int benchPick = select.nextInt();
                    if(benchPick >= 1 && benchPick <= userBench.size()){
                        System.out.println("Please pickan energy card from your hand!");
                        printHand(userHand);
                        int energyPick = select.nextInt();
                        if(energyPick >= 1 && energyPick <= userHand.size()){
                            if(userHand.get(energyPick-1) instanceof Energy){
                                ((Pokemon)userBench.get(benchPick-1)).addEnergy(userHand.get(energyPick-1));
                                userHand.remove(energyPick-1);
                                energy = 1;
                                break;
                            }else{
                                System.out.println("Invalid Selection, Please pick an Energy Card!");
                                break;
                            }
                        }else{
                            System.out.println("Invalid Selection, Please pick one of the options listed");
                            printHand(userHand);
                            break;
                        }
                        
                    }
                }else{
                    System.out.println("No Bench Pokemon!");
                    break;
                }
            default:
                System.out.println("Invalid Selection!");

        }
        return energy;
    }

    // Method for selecting a trainer card
    public void trainerCards(ArrayList<Card> userHand, ArrayList<Card> userBench, ArrayList<Card> userActive, ArrayList<Card> userDeck){
        Scanner select = new Scanner(System.in);
        System.out.println("Which Trainer card would you like to pick?");
        printHand(userHand);
        int pick = select.nextInt();
        if(pick >= 1 && pick <= userHand.size()){
            if(userHand.get(pick-1) instanceof TrainerCard){
                if(((TrainerCard)userHand.get(pick-1)).getName().equals("Potion")){//Case in which the Trainer card is a Potion
                    System.out.println(((TrainerCard)userHand.get(pick-1)).cardSum());
                    userHand.remove(pick-1);
                    System.out.println("Did you want to heal a \n 1. Active Pokemon? \n 2. Bench Pokemon?");
                    int choose = select.nextInt();
                    switch (choose){
                        case 1://Case if the player wants to use a potion on their Active Pokemon
                            if(userActive != null && !userActive.isEmpty()){
                                int tempHP = ((Pokemon)userActive.get(0)).getHp();
                                ((Pokemon)userActive.get(0)).setHp(tempHP+30);
                                break;
                            } else{
                                System.out.println("No Active Pokemon");
                                break;
                            }
                        case 2://Case if the player wants to use a potion one of their bench pokemon
                            if(userBench != null && !userBench.isEmpty()){
                                System.out.println("Which Bench Pokemon would you like to select?");
                                System.out.println(printBench(userBench));
                                int benchPick = select.nextInt();
                                if(benchPick >= 1 && benchPick <= userBench.size()){
                                    int hp = ((Pokemon)userBench.get(benchPick)).getHp();
                                    ((Pokemon)userBench.get(benchPick)).setHp(hp+30);
                                    break;
                                }else{
                                    System.out.println("Invalid Selection!");
                                }
                            }
                        default:
                            System.out.println("Invalid Selection!");
                    }
                }else if(((TrainerCard)userHand.get(pick-1)).getName().equals("Giant Cape")){//Case in which the trainer card is a Giant Cape
                    System.out.println(((TrainerCard)userHand.get(pick-1)).cardSum());
                    userHand.remove(pick-1);
                    System.out.println("Did you want to heal a \n 1. Active Pokemon? \n 2. Bench Pokemon?");
                    int choose = select.nextInt();
                    switch (choose){
                        case 1://Case in which the player wants to attach the Giant Cape to their Active Pokemon
                            if(userActive != null && !userActive.isEmpty()){
                                int tempHP = ((Pokemon)userActive.get(0)).getHp();
                                ((Pokemon)userActive.get(0)).setHp(tempHP+20);
                                break;
                            } else{
                                System.out.println("No Active Pokemon");
                                break;
                            }
                        case 2://Case in which the player wants to attach the Giant Cape to one of their Giant Cape to one of their Bench Pokemon
                            if(userBench != null && !userBench.isEmpty()){
                                System.out.println("Which Bench Pokemon would you like to select?");
                                System.out.println(printBench(userBench));
                                int benchPick = select.nextInt();
                                if(benchPick >= 1 && benchPick <= userBench.size()){
                                    int hp = ((Pokemon)userBench.get(benchPick)).getHp();
                                    ((Pokemon)userBench.get(benchPick)).setHp(hp+20);
                                    
                                    break;
                                }else{
                                    System.out.println("Invalid Selection!");
                                }
                            }
                        default:
                            System.out.println("Invalid Selection!");
                    }
                }else if(((TrainerCard)userHand.get(pick-1)).getName().equals("Nemona")){//Case in which The Player plays the Nemona card
                    System.out.println(((TrainerCard)userHand.get(pick-1)).cardSum());
                    userHand.remove(pick-1);
                    for(int i = 0; i < 3; i++){ 
                        drawCard(userHand, userDeck);
                    }
                }
            }  
        }
    }
    

    //-------------------------------------------------------------------------------------------Placing Pokemon Methods---------------------------------------------------------------------------------------------------------------------------------------------

    //Code for placing down an Active Pokemon
    public ArrayList<Card> placeActive(ArrayList<Card> userHand, ArrayList<Card> userActive, ArrayList<Card> userBench){
        Scanner select = new Scanner(System.in);
        ArrayList<Card> temp = userHand;
        printHand(userHand);
        
        boolean validChoice = false;
        System.out.println("Would you like to pick from \n 1. Your hand? \n 2. Your Bench?");
        int pick = select.nextInt();
        switch (pick){
            case 1://Case in which Player wants to place a Pokemon from their hand into the Active Slot
                System.out.println("Which Pokemon would you like to play?");
                while(validChoice == false){//Loops until a valid selection is made
                    int choice = select.nextInt();
                    if(temp.get(choice - 1) instanceof Pokemon){ 
                        if(choice >= 1 && choice <= userHand.size()){
                            userActive.add(temp.get(choice - 1));
                            userHand.remove(choice - 1);
                            validChoice = true;
                        } else{
                            System.out.println("Invalid Choice, please select another card!");
                        }
                    } else{
                        System.out.println("Invalid Choice, please select a Pokemon!");
                        break;
                    }
                }
                break;
            case 2://Case in which the Player wants to place a Pokemon from their Bench into their Active Slot
                System.out.println("Which Pokemon would you like to play?");
                if(userBench != null && !userBench.isEmpty()){
                    System.out.println(printBench(userBench));
                    while(validChoice == false){//Loops until a valid selection is made
                        int choice = select.nextInt();
                        if(userBench.get(choice - 1) instanceof Pokemon){ 
                            if(choice >= 1 && choice <= userBench.size()){
                                userActive.add(userBench.get(choice - 1));
                                userBench.remove(choice - 1);
                                validChoice = true;
                            } else{
                                System.out.println("Invalid Choice, please select another card!");
                            }
                        } else{
                            System.out.println("Invalid Choice, please select a Pokemon!");
                        }
                    }
                }else{
                    System.out.println("Invalid Selection, No bench Pokemon!");
                    break;
                }
                break;
            default:
                System.out.println("Invalid Selection!");
            
            
            
        }
        return userActive;
        
    }
        
   
    //Method For placing pokemon onto users bench
    public ArrayList<Card> placeBench(ArrayList<Card> userHand, ArrayList<Card> userBench){
        Scanner select = new Scanner(System.in);
        ArrayList<Card> temp = userHand;
        printHand(userHand);
        System.out.println("Which Pokemon would you like to place into your Bench?");
        boolean validChoice = false;
        while(validChoice == false){//Loops until a Valid Selection is made
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
                //Check to ensure there is a pokemon in the hand
                boolean pokeCheck = false;
                for(Card card : userHand){
                    if(card instanceof Pokemon){
                        pokeCheck = true;
                    }
                }
                if(pokeCheck == false){
                    System.out.println("No Pokemon in Hand!");
                    validChoice = true;
                }
            }
            
            
        }
        return userBench;
    }

    //Method used to print the users bench mainly called in the printBoard() method
    public String printBench(ArrayList<Card> userBench){
        String bench = "";
        int num = 1;
        for(Card card : userBench){
            bench = bench + num + ". " + card + ", ";
            num++;
        }
        return bench;
    }


    //Prints the battleboard (Extra Credit) to give a visual representation to the player, meant to replicate the physical game mats played with IRL.
    public void printBoard(ArrayList<Card> userOneBench, ArrayList<Card> userTwoBench, ArrayList<Card> userOneActive, ArrayList<Card> userTwoActive, ArrayList<Card> userOnePrize, ArrayList<Card> userTwoPrize, int player, int player2){
        System.out.println("-----------------------------------------------------------------------------\n \n");
        System.out.println("Player " + player + " Side");
        System.out.println("Prize Cards: " + userOnePrize.size());
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
        System.out.println("Prize Cards: " + userTwoPrize.size());
        System.out.println("Player " + player2 +" Side");
        System.out.println("\n \n-----------------------------------------------------------------------------");

    }

//-----------------------------------------------------------------------------------------Player Turns-----------------------------------------------------------------------------------------------------------------------------------------

    //Code for when Player 1 wins the coinflip
    public void playerOneFirst(ArrayList<Card> firstDeck, ArrayList<Card> firstHand, ArrayList<Card> firstActive, ArrayList<Card> firstBench, ArrayList<Card> firstPrize, ArrayList<Card> firstDiscard, ArrayList<Card> secondDiscard, ArrayList<Card> secondActive, ArrayList<Card> secondBench, ArrayList<Card> secondPrize, int player, int player2){
        Scanner turn = new Scanner(System.in);
        printBoard(firstBench, secondBench, firstActive, secondActive, firstPrize, secondPrize, player, player2);
          
            boolean endTurn = false;
            int energy = 0;
            int train = 0;
            boolean endCheck;
            drawCard(firstHand, firstDeck);
            System.out.println("\nPlayer"+ player +" What is your move: \n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Play Trainer Card \n 8. Pass");
            while(endTurn == false){
                System.out.println("Player " + player + ": ");
                int move = turn.nextInt();
                switch (move){
                    case 1:
                    // Call Attack Method 
                        if(secondActive == null || secondActive.isEmpty()){//Checks to make sure there is a Pokemon in Opponents Active Spot
                            System.out.println("No Pokemon in Opponents Active Spot!");
                            break;
                        }else if(firstActive != null && !firstActive.isEmpty()){//Checks to make sure there is a pokemon in the active spot
                            System.out.println("Would you like to \n 1. Attack \n 2. Check the Energy cost? \n 3. Select another move?");
                            int decision = turn.nextInt();
                            switch (decision){
                                case 1://Calls the attack Method
                                    boolean survival = attack(firstActive, secondActive, firstHand, firstPrize);
                                    if(survival == true){// Checks to see if opponents pokemon is knocked out
                                        secondDiscard.add(secondActive.get(0));
                                        System.out.println(secondActive.get(0) + " was knocked out!!");
                                        secondActive.clear();
                                    }
                                    endTurn = true;
                                    break;
                                case 2: // Shows you the Cost of your pokemons move
                                    System.out.println("Your move costs " + ((Pokemon)firstActive.get(0)).getMoveCost() + "Energy");
                                    break;
                                case 3:// Lets the player select another move 
                                    System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                                    break;
                                default:
                                    System.out.println("Invalid Selection!");
                            }
                            break;    
                        }else{
                            System.out.println("Active Spot is Empty!");
                            break;
                        }    
                        
                    case 2:// Call Attach Energy Method              
                            if(energy == 0){//attach energy will return energy = 1 if energy is successfully attached, this ensures only one energy is attached per turn
                                energy = attachEnergy(firstActive, firstBench, firstHand, energy);
                                    System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                                }else{
                                System.out.println("Already Attatched an Energy this turn!");
                            }
                        break;

                    case 3:// Call Place Active Pokemon Method
                            if(firstActive.size() > 0){
                                System.out.println("Active Slot full please pick another option!");
                                break;
                            } else{
                                firstActive = placeActive(firstHand, firstActive, firstBench);
                                printBoard(firstBench, secondBench, firstActive, secondActive, firstPrize, secondPrize, player, player2);
                                System.out.println("You placed a Pokemon. What else would you like to do?");
                                System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                                break;
                            }

                    case 4://Call Place Bench Pokemon Method
                        if(firstBench.size() > 6){
                            System.out.println("Bench Full,pick another option!");
                            break;
                        } else{
                            firstBench = placeBench(firstHand, firstBench);
                            printBoard(firstBench, secondBench, firstActive, secondActive, firstPrize, secondPrize, player, player2);
                        }

                    case 5:// Call printBoard Method
                    printBoard(firstBench, secondBench, firstActive, secondActive, firstPrize, secondPrize, player, player2);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                        break;
                    
                    case 6://Calls printHand Method
                        printHand(firstHand);
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                        break;

                    case 7://Call Trainer Method
                        if(train == 0){
                            trainerCards(firstHand, firstBench, firstActive, firstDeck);
                            train = 1;
                        }else{
                            System.out.println("Already played a Trainer Card this turn!");
                        }
                        System.out.println("\n 1. Attack \n 2. Attach Energy \n 3. Place an Active Pokemon \n 4. Place a Bench Pokemon \n 5. Print Board \n 6. Show Hand \n 7. Trainer Cards\n 8. Pass");
                        break;

                    case 8://Passes turn
                        System.out.println("You passed your turn!");
                        endTurn = true;
                        break;
                    default:
                        System.out.println("Invalid Input Please pick one of the options above!");
                        
                }
            }
            //printBoard(firstBench, secondBench, firstActive, secondActive, firstPrize, secondPrize);
            endCheck = gameOver();
            
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
            boolean cont = gameOver();
            while(cont == false){
                playerOneFirst(playerOneDeck, oneHand, oneActive, oneBench, onePrize, oneDiscard, twoDiscard, twoActive, twoBench, twoPrize, 1, 2);
                playerOneFirst(playerTwoDeck, twoHand, twoActive, twoBench, twoPrize, twoDiscard, oneDiscard, oneActive, oneBench, onePrize,2, 1);
            }
        }else if(playOrder == false){
            System.out.println("Player 2 is up first!");
            boolean cont = gameOver();
            while(cont == false){
                playerOneFirst(playerTwoDeck, twoHand, twoActive, twoBench, twoPrize, twoDiscard, oneDiscard, oneActive, oneBench, onePrize, 2, 1);
                playerOneFirst(playerOneDeck, oneHand, oneActive, oneBench, onePrize, oneDiscard, twoDiscard, twoActive, twoBench, twoPrize, 1, 2);
            }
        }
    }
    
}
