package src.TCG.PokemonCards.PokemonCreatures;

import src.TCG.PokemonCards.Pokemon;

public class Magnemite extends Pokemon{

    
    public Magnemite(){
        setHp(60);
        setType("Electric");
        setWeakness("Fighting");
        setRetreat(1);
        setEvolution(0);
        setMove(20, "Lightning Ball", "Electric");
        setMoveCost(1);
    }


}
