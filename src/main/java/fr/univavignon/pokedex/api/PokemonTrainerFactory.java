package fr.univavignon.pokedex.api;

/**
 * The type Pokemon trainer factory.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name     Name of the trainer.
     * @param team     Team of the trainer.
     * @param pokedexF PokedexFactory instance.
     * @return Trainer instance.
     */
    @Override
    public final PokemonTrainer createTrainer(final String name,
                                              final Team team,
                                              final IPokedexFactory pokedexF) {
        return new PokemonTrainer(name, team,
                pokedexF.createPokedex(new PokemonMetadataProvider(),
                        new PokemonFactory()));
    }
}
