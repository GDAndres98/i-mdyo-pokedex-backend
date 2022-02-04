package techtest.modyo.pokedex.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techtest.modyo.pokedex.persistence.entity.EvolutionChain;
import techtest.modyo.pokedex.persistence.entity.Pokemon;
import techtest.modyo.pokedex.persistence.entity.PokemonSpecies;
import techtest.modyo.pokedex.persistence.repository.EvolutionRepository;
import techtest.modyo.pokedex.persistence.repository.PokemonRepository;
import techtest.modyo.pokedex.persistence.repository.PokemonSpeciesRepository;

import java.util.Optional;

@Service
public class EvolutionService {

    @Autowired
    private EvolutionRepository evolutionRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonSpeciesRepository pokemonSpeciesRepository;


    public Optional<EvolutionChain> getPokemonEvolutions(int pokemonId) {
        Pokemon pokemon = pokemonRepository.getPokemon(pokemonId);
        return getPokemonEvolutions(pokemon);
    }

    public Optional<EvolutionChain> getPokemonEvolutions(String pokemonName) {
        Pokemon pokemon = pokemonRepository.getPokemon(pokemonName);
        return getPokemonEvolutions(pokemon);
    }

    private Optional<EvolutionChain> getPokemonEvolutions(Pokemon pokemon) {
        if (pokemon == null)
            return Optional.empty();
        PokemonSpecies species = pokemonSpeciesRepository.getPokemonSpecies(pokemon.getSpecies());
        if (species == null)
            return Optional.empty();
        int evolutionChainId = species.getEvolutionChainId();
        if (evolutionChainId < 0)
            return Optional.empty();

        return Optional.ofNullable(evolutionRepository.getEvolutionChain(evolutionChainId));
    }

}
