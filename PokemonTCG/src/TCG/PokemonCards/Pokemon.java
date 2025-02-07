package src.TCG.PokemonCards;
import src.TCG.Card;

public class Pokemon extends Card{
    public Pokemon(){
        setCardType("Pokemon");
    }
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private String type;
    private String weakness;
    private int retreat;
    private int evolution;

    public int getHp(){
        return hp;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getspAttack(){
        return spAttack;
    }
    public int getspDefense(){
        return spDefense;
    }
    public int getSpeed(){
        return speed;
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

    public void setHp(int userHp){
        hp = userHp;
    }
    public void setAttack(int userAttack){
        attack = userAttack;
    }
    public void setDefense(int userDefense){
        defense = userDefense;
    }
    public void setSpeed(int userSpeed){
        speed = userSpeed;
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
        retreat = userEvolution;
    }
}
