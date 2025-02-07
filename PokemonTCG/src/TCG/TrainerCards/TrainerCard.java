package src.TCG.TrainerCards;
import src.TCG.Card;

public class TrainerCard extends Card{
    public TrainerCard(){
        setCardType("Trainer"); 
    }
    private String trainerType;
    public String getTrainerType(){
        return trainerType;
    }
    public void setTrainerType(String userTrainer){
        trainerType = userTrainer;
    }
}
