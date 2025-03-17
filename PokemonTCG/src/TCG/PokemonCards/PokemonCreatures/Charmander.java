package src.TCG.PokemonCards.PokemonCreatures;
import src.TCG.PokemonCards.Pokemon;

public class Charmander extends Pokemon {
    

    //Default Pikachu
    public Charmander(){
        setHp(80);
        setType("Fire");
        setWeakness("Water");
        setRetreat(1);
        setEvolution(0);
        setMove(30, "Ember", "Fire");
        setMoveCost(2);
    }
}
