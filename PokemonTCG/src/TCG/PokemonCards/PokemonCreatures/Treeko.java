package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Treeko extends Pokemon{
    public Treeko(){
        setHp(60);
        setMove(20, "Razor Leaf", "Grass");
        setMoveCost(2);
        setType("Grass");
        setWeakness("Fire");
        setRetreat(1);
        setEvolution(0);
    }
}
