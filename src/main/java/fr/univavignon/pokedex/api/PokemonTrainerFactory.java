package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public final PokemonTrainer createTrainer(final String name,
                                              final Team team,
                                              final IPokedexFactory pokedexF) {
        return new PokemonTrainer(name, team,
                pokedexF.createPokedex(new PokemonMetadataProvider(),
                        new PokemonFactory()));
    }
}
