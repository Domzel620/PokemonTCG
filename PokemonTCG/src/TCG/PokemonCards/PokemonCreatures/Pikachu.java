package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Pikachu extends Pokemon{

    
    public Pikachu(){
        setHp(70);
        setType("Electric");
        setWeakness("Fighting");
        setRetreat(1);
        setEvolution(0);
        setMove(50, "Electro Ball", "Electric");
        setMoveCost(3);
    }

}
