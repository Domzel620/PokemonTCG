package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Squirtle extends Pokemon{
    public Squirtle(){
        setHp(70);
        setType("Water");
        setWeakness("Grass");
        setRetreat(1);
        setEvolution(0);
        setMove(20, "Water Gun", "Water");
        setMoveCost(1);
    }
}
