package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Cyndaquill extends Pokemon {
    

    //Default Pikachu
    public Cyndaquill(){
        setHp(60);
        setType("Fire");
        setWeakness("Water");
        setRetreat(1);
        setEvolution(0);
        setMove(20, "Live Coal", "Fire");
        setMoveCost(2);
    }
}
