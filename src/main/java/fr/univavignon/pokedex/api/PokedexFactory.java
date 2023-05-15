package fr.univavignon.pokedex.api;

/**
 * The type Pokedex factory.
 */
public class PokedexFactory implements IPokedexFactory {
    /**
     * Creates a new pokedex instance..
     *
     * @param metadataProvider Metadata the pokedex will use.
     * @param pokemonFactory   factory the pokedex will use.
     * @return pokedex instance.
     */
    @Override
    public final IPokedex createPokedex(
            final IPokemonMetadataProvider metadataProvider,
            final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }

}
