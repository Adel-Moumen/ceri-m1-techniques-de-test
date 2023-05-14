package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class IPokedexFactoryTest {

    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;


    @Before
    public void initTestEnvironment() {
        pokedex = new PokedexFactory().createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        pokemonMetadataProvider = new PokemonMetadataProvider();

        pokemonFactory = new PokemonFactory();

        pokemon1 = new Pokemon(1, "pokemon1", 100, 100, 100, 100, 100, 100, 100, 100);
        pokemon2 = new Pokemon(2, "pokemon2", 100, 100, 100, 100, 100, 100, 100, 100);
    }

    @Test
    public void shouldReturnOneWhenGetSize() {
        pokedex.addPokemon(pokemon1);
        Assert.assertEquals(1, pokedex.size());
    }

    @Test
    public void shouldReturnZeroWhenGetSize() {
        Assert.assertEquals(0, pokedex.size());
    }
}
