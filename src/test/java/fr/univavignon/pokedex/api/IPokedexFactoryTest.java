package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class IPokedexFactoryTest {

    private IPokedex pokedex;
    private IPokedexFactory pokedexFactory;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;


    @Before
    public void initTestEnvironment() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        pokedex = new Pokedex(pokemonMetadataProvider,pokemonFactory);

        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(), pokedex.size());
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getPokemons(), pokedex.getPokemons());
    }
}
