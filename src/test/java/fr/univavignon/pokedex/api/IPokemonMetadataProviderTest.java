package fr.univavignon.pokedex.api;
// import mock
import org.mockito.Mock;
import org.junit.*;
import org.mockito.MockitoAnnotations;
public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadaProvider;

    @Before
    public void setUp() {
        // init mock
        MockitoAnnotations.initMocks(pokemonMetadaProvider);
    }

    @After
    public void tearDown() {

    }
}
