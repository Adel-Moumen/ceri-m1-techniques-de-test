package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {

    private IPokedex pokedex;

    @Before
    public void initTestEnvironment() {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokedex = mock(IPokedex.class);
        when(mock(IPokedexFactory.class).createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedex);
        System.out.println("Not Null!");
    }
}
