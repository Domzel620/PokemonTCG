package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Voltorb extends Pokemon{

    //Default Pikachu
    public Voltorb(){
        setHp(80);
        setType("Electric");
        setWeakness("Fighting");
        setRetreat(1);
        setEvolution(0);
        setMove(30, "Spark", "Electric");
        setMoveCost(2);
    }

    //We could make another constructor, one with all the parameters

    //We would want a set of getters and setters


}
