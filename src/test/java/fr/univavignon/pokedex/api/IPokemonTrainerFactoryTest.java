package fr.univavignon.pokedex.api;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

// Adel Moumen
public class IPokemonTrainerFactoryTest {


    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void initTestEnvironment() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer pokemonTrainer1 = pokemonTrainerFactory.createTrainer("pokemonTrainer1", Team.MYSTIC, pokedexFactory);
        PokemonTrainer pokemonTrainer2 = pokemonTrainerFactory.createTrainer("pokemonTrainer2", Team.MYSTIC, pokedexFactory);
        Assert.assertEquals(pokemonTrainer1.getName(), "pokemonTrainer1");
        Assert.assertEquals(pokemonTrainer1.getTeam(), Team.MYSTIC);
        Assert.assertEquals(pokemonTrainer2.getName(), "pokemonTrainer2");
        Assert.assertEquals(pokemonTrainer2.getTeam(), Team.MYSTIC);
        Assert.assertEquals(pokemonTrainer1.getPokedex(), pokemonTrainer2.getPokedex());
    }


}
