package fr.univavignon.pokedex.api;
// import mock
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.junit.*;
import org.mockito.MockitoAnnotations;
public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // init mock
        MockitoAnnotations.initMocks(pokemonFactory);
    }

    @After
    public void tearDown() {

    }
}
