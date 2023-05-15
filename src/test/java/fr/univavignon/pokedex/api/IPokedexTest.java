package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void initTestEnvironment(){
        pokedex = new PokedexFactory().createPokedex(new PokemonMetadataProvider(),new PokemonFactory());
        pokemon1 = new Pokemon(0, "pokemon1", 613, 64, 4000, 4, 4, 4, 4, 4);
        pokemon2 = new Pokemon(1, "pokemon2", 384, 29, 500, 4, 4, 4, 4, 4);

        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void shouldReturnExceptionWhenIndexNotInRange() {
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));
    }

    @Test
    public void shouldReturnExceptionWhenIndexIsNegative() {
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
    }

    @Test
    public void shouldReturnOneWhenAddPokemon() throws PokedexException {
        Assert.assertEquals(1, pokedex.addPokemon(pokemon1));
    }

    @Test
    public void shouldReturnPokemon1WhenGetPokemon() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        Assert.assertEquals(pokemon1, pokedex.getPokemon(0));
        Assert.assertEquals(pokedex.getPokemon(0).getName(),"pokemon1");
        Assert.assertEquals(pokedex.getPokemon(0).getIndex(),0);
    }

    @Test
    public void shouldReturnListOfPokemonsWhenPokemonList() throws PokedexException {
        List listOfPokemons = new ArrayList<>();
        listOfPokemons.add(pokemon1);
        listOfPokemons.add(pokemon2);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        Assert.assertEquals(listOfPokemons, pokedex.getPokemons());
    }

    @Test
    public void shouldReturnSizeOfPokedexWhenSize() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        Assert.assertEquals(2, pokedex.size());
    }

    @Test
    public void shouldReturnPokemonsListWithOrderedWhenGetPokemons() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = Arrays.asList(pokemon1, pokemon2);
        Assert.assertEquals(pokemons, pokedex.getPokemons(PokemonComparators.NAME));
    }

    @Test
    public void shouldReturnPokemonsListWithOrderedWhenGetPokemons2() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = Arrays.asList(pokemon1, pokemon2);
        Assert.assertEquals(pokemons, pokedex.getPokemons(PokemonComparators.INDEX));
    }

    @Test
    public void shouldReturnEvereythingFromPokemon1() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        Assert.assertEquals(pokedex.getPokemon(0).getName(), pokemon1.getName());
        Assert.assertEquals(pokedex.getPokemon(0).getIndex(), pokemon1.getIndex());
        Assert.assertEquals(pokedex.getPokemon(0).getAttack(), pokemon1.getAttack());
        Assert.assertEquals(pokedex.getPokemon(0).getDefense(), pokemon1.getDefense());
        Assert.assertEquals(pokedex.getPokemon(0).getStamina(), pokemon1.getStamina());
        Assert.assertEquals(pokedex.getPokemon(0).getCp(), pokemon1.getCp());
    }


}
