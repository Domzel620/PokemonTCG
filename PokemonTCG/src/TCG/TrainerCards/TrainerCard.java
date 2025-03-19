package src.TCG.TrainerCards;
import src.TCG.Card;

public class TrainerCard extends Card{
    public TrainerCard(){
        setCardType("Trainer"); 
    }
    private String trainerType;
    private String abilityDesc;
    private String trainerName;

    //getter
    public String getTrainerType(){
        return trainerType;
    }
    public String getAbilityDesc(){
        return abilityDesc;
    }
    public String getName(){
        return trainerName;
    }

    //setter
    public void setTrainerType(String userTrainer){
        trainerType = userTrainer;
    }
    public void setAbilityDesc(String userAbilityDesc){
        abilityDesc = userAbilityDesc;
    }
    public void setName(String userName){
        trainerName = userName;
    }
    //Give a summary of the Trainer card, including its description
    public String cardSum(){
        return "\n Trainer Type: " + trainerType + "\n Name: " + trainerName + "\n Description: " + abilityDesc;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
