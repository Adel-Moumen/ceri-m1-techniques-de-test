package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void initTestEnvironment(){
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size(),pokedex.size());
        Assert.assertEquals(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).getPokemons(),pokedex.getPokemons());
    }
}
