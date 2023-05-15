package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonFactory pokemonFactory2;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private Pokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Before
    public void initTestEnvironment() throws PokedexException {
        pokemonFactory = new PokemonFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokemon1 = new Pokemon(0, "pokemon1", 4, 4, 4, 4, 4, 4, 4, 4);
        pokemon2 = new Pokemon(1, "pokemon2", 384, 29, 500, 4, 4, 4, 4, 4);

        pokemonFactory2 = pokedex.getPokemonFactory();
    }

    @Test
    public void whenCreatePokemonAssertEverythingIsTheSame() throws PokedexException {
        Pokemon pokemon3 = pokemonFactory.createPokemon(0, 4, 4, 4, 4);

        Assert.assertEquals(pokemon1.getName(), pokemon3.getName());
        Assert.assertEquals(pokemon1.getIndex(), pokemon3.getIndex());
        Assert.assertEquals(pokemon1.getAttack(), pokemon3.getAttack());
        Assert.assertEquals(pokemon1.getDefense(), pokemon3.getDefense());
        Assert.assertEquals(pokemon1.getStamina(), pokemon3.getStamina());
        Assert.assertEquals(pokemon1.getCp(), pokemon3.getCp());
        Assert.assertEquals(pokemon1.getHp(), pokemon3.getHp());
        Assert.assertEquals(pokemon1.getDust(), pokemon3.getDust());
        Assert.assertEquals(pokemon1.getCandy(), pokemon3.getCandy());
        Assert.assertEquals(4.0, pokemon1.getIv(),4.0);
    }

    @Test
    public void shouldReturnFactoryWhenGetPokemonFactory() throws PokedexException {
        Assert.assertEquals(pokemonFactory, pokemonFactory2);
    }
}
