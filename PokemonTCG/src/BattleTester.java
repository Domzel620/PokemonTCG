package src;

import src.TCG.PokemonCards.PokemonCreatures.Charmander;
import src.TCG.PokemonCards.PokemonCreatures.Squirtle;

public class BattleTester {
    public static void main(String[] args) {
        StadiumTester battle = new StadiumTester();
        Squirtle coolGuy = new Squirtle();
        Charmander hotGuy = new Charmander();
        battle.battle(coolGuy, hotGuy);
    }
}
