public class Energy extends Card{
    public Energy(){
        setCardType("Energy");
    }
    private String type;
    public String getType(){
        return type;
    }
    public void setType(String energyType){
        type = energyType;
    }
}
