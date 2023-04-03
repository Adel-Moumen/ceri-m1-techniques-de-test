package fr.univavignon.pokedex.api;
// import mock
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.junit.*;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        // init mock
        MockitoAnnotations.initMocks(pokedexFactory);
    }

    @After
    public void tearDown() {

    }
}
