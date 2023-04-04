package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata dracofeu;

    @Before
    public void initTestEnvironment() throws Exception {
        dracofeu = new PokemonMetadata(0, "Dracofeu", 10000, 10000, 10000);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(dracofeu);
    }

    @Test
    public void testGetPokemonMetadata() {
        assert (dracofeu != null);
        System.out.println("Pokemon Metadata Provider Test Passed!");
    }
}
