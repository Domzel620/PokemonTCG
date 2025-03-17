package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Chimchar extends Pokemon {
    

    //Default Pikachu
    public Chimchar(){
        setHp(70);
        setType("Fire");
        setWeakness("Water");
        setRetreat(1);
        setEvolution(0);
        setMove(50, "Flame Wheel", "Fire");
        setMoveCost(3);
    }
}
