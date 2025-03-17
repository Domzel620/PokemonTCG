package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Lapras extends Pokemon{
    public Lapras(){
        setHp(120);
        setType("Water");
        setWeakness("Grass");
        setRetreat(1);
        setEvolution(0);
        setMove(80, "Aqua Wave", "Water");
        setMoveCost(4);
    }
}
