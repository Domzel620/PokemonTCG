package src.TCG;

import java.util.ArrayList;

import src.TCG.EnergyCards.EnergyTypes.ElectricEnergy;
import src.TCG.PokemonCards.Pokemon;
import src.TCG.PokemonCards.PokemonCreatures.Pikachu;
import src.TCG.TrainerCards.TrainerCardTypes.RareCandy;
public class MonteDeckSimulation {
    PokemonGame game = new PokemonGame();
    private ArrayList<Card> hand;
    private ArrayList<Card> prize;
    private int candyCounter;

//Code Check 1
        
    public void createMonteDeck(){
        for(int i = 1; i < 60; i++){
            ArrayList<Card> monteDeck = new ArrayList<Card>();
            for(int k = 0; k < i; k++){
            monteDeck.add(new Pikachu());
            }
            for(int j = i; j < 60; j++){
                monteDeck.add(new ElectricEnergy());
            }
            int p = 0;
            int e = 0;
            for(Card card : monteDeck){ 
                if (card instanceof Pokemon){
                    p++;
                }else
                    e++;
                }
                //System.out.println("\n" + "Monte Deck " + i + " contains: ");
                //System.out.println("Pokemon: " + p);
                //System.out.println("Energy: " + e);
                game.shuffleDeck(monteDeck);
                monteHand(monteDeck);
                //create a check hand method instead that can be called in drawhand. Is not looping properly rn in drawhand
                //it only checks once and moves on
        }           
    }
    public void monteHand(ArrayList<Card> monteDeck){
        double mulligan;
        double p = 0;
        double e = 0;
        for(int m = 0; m < 10000; m++){
            hand = new ArrayList<Card>();
            // Draws 7 cards
            for (int i = 0; i < 7; i++) {
                hand.add(monteDeck.get(i));
            }
        
            for (int i = 6; i >= 0; i--) {
                monteDeck.remove(i); 
            }
    
            // Checks if a Pokemon is in the hand
            boolean hasPokemon = monteCheckHand(monteDeck, hand);
            //Counts how many times a mulligan occurs
            if(hasPokemon == true){
                p++;
            }else if(hasPokemon == false){
                e++;
            }
           for(Card card : hand){
                monteDeck.add(card);
                game.shuffleDeck(monteDeck);
           }
        }
        mulligan = (e/10000);
        //System.out.println("Hands containing Pokemon: " + p);
        //System.out.println("Hands NOT containing Pokemon: " + e);
        //System.out.println("A mulligan occurred " + mulligan + "% of the time.");
        System.out.println(mulligan);
    }
    public boolean monteCheckHand(ArrayList<Card> monteDeck, ArrayList<Card> userHand){
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                //System.out.println("Your hand has a pokemon");
                //printHand();
                return true;
            } 
        }
        //System.out.println("No Pokemon in this hand");
        //printHand();
        return false;
    }


//Code Check Two
    public void createMonteRare(){
        for(int i = 1; i < 5; i++){
            candyCounter = i;
            ArrayList<Card> monteDeck = new ArrayList<Card>();
            for(int k = 0; k < i; k++){
                   monteDeck.add(new RareCandy());
            }
            for(int k = i; k < 24; k++){
                monteDeck.add(new Pikachu());
            }
            for(int j = i; j < 60; j++){
                monteDeck.add(new ElectricEnergy());
            }
                game.shuffleDeck(monteDeck);
                game.drawHand(monteDeck);
                montePrize(monteDeck);
        }           
    }
    public void montePrize(ArrayList<Card> userDeck){
         
        double brickRate = 0;
        double b = 0;
        for(int j = 0; j < 10000; j++){
            prize = new ArrayList<Card>();
            for(int i = 0;  i < 6; i++){
                prize.add(userDeck.get(i));
                
            }
            int countedCandy = monteCheckPrize(userDeck, prize);
            if(countedCandy == candyCounter){
                b++;
            }
            game.shuffleDeck(userDeck);
        }
        brickRate = (b/10000.0)*100;
        System.out.println("The Brick rate for " + candyCounter + " Rare Candy is " + brickRate + "%");
    }
    public int monteCheckPrize(ArrayList<Card> monteDeck, ArrayList<Card> userPrize){
        int candy = 0;
        for (Card card : userPrize) {
            if (card instanceof RareCandy) {
                candy++;
            } 
        }
        return candy;
    }
            
}
