package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Magnemite extends Pokemon{

    //Default Pikachu
    public Magnemite(){
        setHp(60);
        setType("Electric");
        setWeakness("Fighting");
        setRetreat(1);
        setEvolution(0);
        setMove(20, "Lightning Ball", "Electric");
        setMoveCost(1);
    }

    //We could make another constructor, one with all the parameters

    //We would want a set of getters and setters


}
