package fr.univavignon.pokedex.api;
// import mock
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.junit.*;
import org.mockito.MockitoAnnotations;
public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory;

    @Before
    public void setUp() {
        // init mock
        MockitoAnnotations.initMocks(pokemonTrainerFactory);
    }

    @After
    public void tearDown() {

    }
}
