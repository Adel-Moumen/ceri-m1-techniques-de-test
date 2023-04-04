package fr.univavignon.pokedex.api;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private Pokemon pokemon;

    @Before
    public void initTestEnvironment() {
        Pokemon pokemon1 = new Pokemon(0, "Dracofeu", 10000, 10000, 10000, 10000, 10000, 10000,10000, 10000);
        when(mock(IPokemonFactory.class).createPokemon(10000,10000,10000,10000,10000)).thenReturn(pokemon1);
    }

    @Test
    public void testCreatePokemon() {
        assert (mock(IPokemonFactory.class).createPokemon(10000,10000,10000,10000,10000) == pokemon);
        System.out.println("Pokemon Factory Test Passed!");
    }
}
