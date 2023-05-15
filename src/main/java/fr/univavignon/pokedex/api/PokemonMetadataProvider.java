package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "pokemon1", 4, 4, 4));
        pokemonMetadataList.add(new PokemonMetadata(1, "pokemon2", 384, 29, 500));
    }


    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        if (index < 0 || index >= pokemonMetadataList.size()) {
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemonMetadataList.get(index);
    }
}