package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> pokemonMetadataList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>();
    }


    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        if (index < 0 || index >= pokemonMetadataList.size()) {
            throw new PokedexException("Le Pokémon n'est pas enregistré dans le pokédex");
        }
        return pokemonMetadataList.get(index);
    }
}