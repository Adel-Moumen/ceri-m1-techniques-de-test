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
        pokemon1 = new Pokemon(0, "pokemon1", 4, 4, 4, 4, 4, 4, 4, 4);
        pokemon2 = new Pokemon(1, "pokemon2", 384, 29, 500, 4, 4, 4, 4, 4);

        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();

        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
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
    public void shouldReturnTheExactMetadataWhenCalled() throws PokedexException {
        PokemonMetadata pokemon = pokedex.getPokemonMetadata(0);
        Assert.assertEquals(pokemon.getIndex(),pokemon1.getIndex());
        Assert.assertEquals(pokemon.getName(),pokemon1.getName());
        Assert.assertEquals(pokemon.getAttack(),pokemon1.getAttack());
        Assert.assertEquals(pokemon.getDefense(),pokemon1.getDefense());
        Assert.assertEquals(pokemon.getStamina(),pokemon1.getStamina());
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

    @Test
    public void shouldReturnAllPokemonsFromGetPokemons() throws PokedexException {
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        Assert.assertEquals(pokedex.getPokemons().size(), 2);
    }

    @Test
    public void shouldReturnTheNewPokemonWhenCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokedex.createPokemon(0,  4, 4, 4, 4);
        Assert.assertEquals(pokemon.getDust(),pokemon1.getDust());
        Assert.assertEquals(pokemon.getCandy(),pokemon1.getCandy());
        Assert.assertEquals(pokemon.getIndex(),pokemon1.getIndex());
        Assert.assertEquals(pokemon.getCp(),pokemon1.getCp());
        Assert.assertEquals(pokemon.getHp(),pokemon1.getHp());
    }

    @Test
    public void shouldReturnPokemonMetadaWhenCallingGetPokemonMetadata() throws PokedexException {
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(0);
        Assert.assertEquals(pokemonMetadata.getIndex(),pokemon1.getIndex());
        Assert.assertEquals(pokemonMetadata.getName(),pokemon1.getName());
        Assert.assertEquals(pokemonMetadata.getAttack(),pokemon1.getAttack());
        Assert.assertEquals(pokemonMetadata.getDefense(),pokemon1.getDefense());
        Assert.assertEquals(pokemonMetadata.getStamina(),pokemon1.getStamina());
    }
}
