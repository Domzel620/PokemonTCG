package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Pikachu extends Pokemon{

    //Default Pikachu
    public Pikachu(){
        setHp(70);
        setType("Electric");
        setWeakness("Fighting");
        setRetreat(1);
        setEvolution(0);
        setMove(30, "Electro Ball", "Electric");
        setMoveCost(3);
    }

    //We could make another constructor, one with all the parameters

    //We would want a set of getters and setters


}
