package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Bulbasaur extends Pokemon{
    public Bulbasaur(){
        setHp(70);
        setMove(20, "Water Gun", "Water");
        setType("Water");
        setWeakness("Grass");
        setRetreat(1);
        setEvolution(0);
    }
}
