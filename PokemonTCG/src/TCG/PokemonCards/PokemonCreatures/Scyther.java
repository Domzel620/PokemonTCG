package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Scyther extends Pokemon{
    public Scyther(){
        setHp(70);
        setMove(30, "Sharp Scythe", "Grass");
        setMoveCost(1);
        setType("Grass");
        setWeakness("Fire");
        setRetreat(1);
        setEvolution(0);
    }
}
