package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexTest {


    private IPokedex pokedex;
    @Before
    public void initTestEnvironment(){
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mock(IPokedex.class));
        pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        when(pokedex.size()).thenReturn(0);
    }

    @Test
    public void testSize() {
        assert (pokedex.size() == 0);
        System.out.println("Pokedex Size Test Passed!");
    }

}
