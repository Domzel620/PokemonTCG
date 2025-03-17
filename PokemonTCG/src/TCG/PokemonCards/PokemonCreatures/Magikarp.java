package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Magikarp extends Pokemon{
    public Magikarp(){
        setHp(50);
        setType("Water");
        setWeakness("Grass");
        setRetreat(1);
        setEvolution(0);
        setMove(10, "Splash", "Water");
        setMoveCost(1);
    }
}
