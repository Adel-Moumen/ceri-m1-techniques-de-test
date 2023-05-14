package fr.univavignon.pokedex.api;

/**
 * Factory Class that aims to create Pokemon instance.
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getDefense(), cp, hp, dust, candy, 1);
    }

}
