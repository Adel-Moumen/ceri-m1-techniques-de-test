package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;



public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider pokemonMetadataProvider1;
    private PokemonMetadata pokemon1Metadata;

    private IPokemonFactory pokemonFactory;
    private Pokedex pokedex;
    private IPokemonMetadataProvider pokemonMetadataProvider2;
    private PokemonMetadata pokemon2Metadata;

    @Before
    public void initTestEnvironment() throws Exception {
        pokemonMetadataProvider1 = new PokemonMetadataProvider();
        pokemon1Metadata = new PokemonMetadata(0, "pokemon1", 4, 4, 4);
        pokemon2Metadata = new PokemonMetadata(1, "pokemon2", 384, 29, 500);
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(pokemonMetadataProvider1, pokemonFactory);
        pokemonMetadataProvider2 = pokedex.getPokemonMetadataProvider();
    }

    @Test
    public void assertPokemonMetadaProviderAreTheSame() throws PokedexException {
        Assert.assertEquals(pokemonMetadataProvider1,pokemonMetadataProvider2);
    }

    @Test
    public void shouldReturnExceptionWhenIndexIsNegative() {
        Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider2.getPokemonMetadata(-1));
    }

    @Test
    public void shouldReturnExceptionErrorMessageWhenIndexIsNegative() {
        try {
            pokemonMetadataProvider2.getPokemonMetadata(-1);
        } catch (PokedexException e) {
            Assert.assertEquals("Le Pokémon n'est pas enregistré dans le pokédex",e.getMessage());
        }
    }

    @Test
    public void shouldReturnPokemonMetadata() throws PokedexException {
        Assert.assertEquals(pokemon1Metadata.getIndex(),pokemonMetadataProvider1.getPokemonMetadata(0).getIndex());
        Assert.assertEquals(pokemon1Metadata.getName(),pokemonMetadataProvider1.getPokemonMetadata(0).getName());
        Assert.assertEquals(pokemon1Metadata.getAttack(),pokemonMetadataProvider1.getPokemonMetadata(0).getAttack());
        Assert.assertEquals(pokemon1Metadata.getDefense(),pokemonMetadataProvider1.getPokemonMetadata(0).getDefense());
        Assert.assertEquals(pokemon1Metadata.getStamina(),pokemonMetadataProvider1.getPokemonMetadata(0).getStamina());
    }

}
