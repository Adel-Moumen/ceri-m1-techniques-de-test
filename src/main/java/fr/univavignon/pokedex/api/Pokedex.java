package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The type Pokedex.
 */
public class Pokedex implements IPokedex {

    /**
     * The Pokemon metadata provider.
     */
    private final IPokemonMetadataProvider pokemonMetadataProvider;
    /**
     * The Pokemons.
     */
    private final List<Pokemon> pokemons;
    /**
     * The Pokemon factory.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Instantiates a new Pokedex.
     *
     * @param metadataProvider the metadata provider
     * @param factory          the factory
     */
    public Pokedex(final IPokemonMetadataProvider metadataProvider,
                   final IPokemonFactory factory) {
        pokemons = new ArrayList<>();
        pokemonFactory = factory;
        pokemonMetadataProvider = metadataProvider;
    }


    @Override
    public final int size() {
        return pokemons.size();
    }


    @Override
    public final int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size();
    }


    @Override
    public final Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException(
                    "Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemons.get(id);
    }


    @Override
    public final List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }


    @Override
    public final List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> pokemonList = pokemons;
        pokemons.sort(order);
        return Collections.unmodifiableList(pokemonList);
    }


    @Override
    public final Pokemon createPokemon(final int index, final int cp,
                                       final int hp,
                                       final int dust, final int candy)
            throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public final PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

    /**
     * Gets pokemon factory.
     *
     * @return the pokemon factory
     */
    public IPokemonFactory getPokemonFactory() {
        return pokemonFactory;
    }

    /**
     * Gets pokemon metadata provider.
     *
     * @return the pokemon metadata provider
     */
    public IPokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }
}
