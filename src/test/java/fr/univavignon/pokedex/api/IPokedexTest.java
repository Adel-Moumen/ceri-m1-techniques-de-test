package fr.univavignon.pokedex.api;

import org.mockito.Mock;
import org.mockito.Mock.*;
import org.junit.*;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {


    @Mock
    private IPokedex pokedex;


    @Before
    public void setUp() {
        // init mock
        MockitoAnnotations.initMocks(pokedex);
    }

    @After
    public void tearDown() {


    }
}
