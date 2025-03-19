package src.TCG.PokemonCards;
import java.util.ArrayList;
import src.TCG.Card;

public class Pokemon extends Card{
    public Pokemon(){
        setCardType("Pokemon");
        energyBank = new ArrayList<>();
    }
    private int hp;
    private String type;
    private String weakness;
    private int retreat;
    private int evolution;
    private ArrayList<Card> energyBank;
    private String cardSum;
    private int damage;
    private String moveName;
    private String moveType;
    private int moveCost;

    //Getters
    public int getHp(){
        return hp;
    }
    public int getDamage(){
        return damage;
    }
    public String getType(){
        return type;
    }
    public String getWeakness(){
        return weakness;
    }
    public int getRetreat(){
        return retreat;
    }
    public int getEvolution(){
        return evolution;
    }
    public ArrayList<Card> getEnergyBank(){
        return energyBank;
    }
    public int getMoveCost(){
        return moveCost;
    }

    //Setters
    public void setHp(int userHp){
        hp = userHp;
    }
    public void setType(String userType){
        type = userType;
    }
    public void setWeakness(String userWeakness){
        weakness = userWeakness;
    }
    public void setRetreat(int userRetreat){
        retreat = userRetreat;
    }
    public void setEvolution(int userEvolution){
        evolution = userEvolution;
    }
    public void setMoveCost(int userMoveCost){
        moveCost = userMoveCost;
    }
    public void setMove(int userDamage, String userMoveName, String userMoveType){
        damage = userDamage;
        moveName = userMoveName;
        moveType = userMoveType;
    }
    
    //Pokemon Methods

    //Gives a summary of the Pokemon, Similar to the typical Pokemon Card format
    public String cardSum(){
        return "\n Pokemon: " + this.getClass().getSimpleName() + "\n HP: " + hp + "  Type: " + type + "\n Moves: " + moveName + " " + moveType + " " + damage + " Energy Cost: "+ moveCost + "\n Retreat Cost: " + retreat + " Weakness: " + weakness + "\n" + "Attatched Energy: " + energyBank.size();
    }

    //Called in the attack method in PokemonGame.java
    public int useMove(Pokemon one, Pokemon two){
        
        int tempDamage = damage;
        if(one.moveType.equals(two.weakness)){
            tempDamage = damage + 20;
            System.out.println("SUPER EFFECTIVE!");
        }
        System.out.println(toString() + " used " + moveName + " for " + tempDamage + " damage!");
        return tempDamage;
    }

    //Method used to attach an energy card to this specific pokemon
    public void addEnergy(Card userEnergy){
        energyBank.add(userEnergy);
    }

    //Overrode the toString method to just print out the pokemons name for printing purposes.
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
