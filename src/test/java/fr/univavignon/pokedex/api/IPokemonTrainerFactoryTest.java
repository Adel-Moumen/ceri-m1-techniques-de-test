package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Adel Moumen
public class IPokemonTrainerFactoryTest {


    private IPokemonTrainerFactory pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    private PokemonTrainer pokemonTrainer = mock(PokemonTrainer.class);
    private IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    private String name = "abdelkader";

    @Test
    public void testCreateTrainer() {
        assert (pokemonTrainerFactory.createTrainer("abdelkader", Team.VALOR, pokedexFactory) == pokemonTrainer);
        System.out.println("Pokemon Trainer Factory Test Passed!");
    }

    @Before
    public void initTestEnvironment() {
        when(pokemonTrainerFactory.createTrainer(name, Team.VALOR, pokedexFactory)).thenReturn(pokemonTrainer);
    }


}
