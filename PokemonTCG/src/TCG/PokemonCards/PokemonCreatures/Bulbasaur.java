package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Bulbasaur extends Pokemon{
    public Bulbasaur(){
        setHp(70);
        setMove(40, "Vine Whip", "Grass");
        setMoveCost(2);
        setType("Grass");
        setWeakness("Fire");
        setRetreat(1);
        setEvolution(0);
    }
}
