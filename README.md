This is my Pokemon TCG project created for my Probability and Applied Statistics Class.

A breakdown of the Folders/Files within this project.
The PokemonTCG/src contains a TCG folder, as well as BattleTester.java and MonteTester.java.
BattleTester is used to run the game itself, and MonteTester is used to test my Monte Carlo simulations
created in my MonteDeckSimulation.java file.

The TCG Folder Contains the EnergyCards, PokemonCards, and TrainerCards folder, as well as 
Card.java, DeckCreator.java, MonteDeckSimulation.java, PokemonGame.java.

The 3 folders mentioned contained files that all inherit Card.java.
DeckCreator.java is used to create the 4 different decks that can be used within the game.
Like previously mentioned MonteDeckSimulation.java is used to create monte carlo simulations.
PokemonGame.java contains the core gameplay logic/code

The EnergyCards folders contains the EnergyTypes Folder, and Energy.java. 
Energy.java inherits Card.java, and the files in EnergyTypes Inherit Energy.java.
The EnergyTypes files contain files that represent the different energy type cards in Pokemon TCG
and are used in DeckCreator.java to add to the respective deck types.

The PokemonCards Folder contains the PokemonCreatures folder as well as Pokemon.java. 
PokemonJava inherits Card.java, the files within PokemonCreatures inerhit Pokemon.java.
Pokemon.java contains files that represent the basic Pokemon cards.

The TrainerCards Folder contains the TrainerCardType folder and TrainerCard.java. 
TrainerCard.java inherits Card.java, and the files within the TrainerCardType folder inherit TrainerCard.java.
The Files in the TrainerCardType folder contains the files that represent Trainer Cards from TCG.
