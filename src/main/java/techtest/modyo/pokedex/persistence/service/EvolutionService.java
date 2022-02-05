package techtest.modyo.pokedex.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techtest.modyo.pokedex.persistence.entity.ChainLink;
import techtest.modyo.pokedex.persistence.entity.EvolutionChain;
import techtest.modyo.pokedex.persistence.entity.Pokemon;
import techtest.modyo.pokedex.persistence.entity.PokemonSpecies;
import techtest.modyo.pokedex.persistence.repository.EvolutionRepository;
import techtest.modyo.pokedex.persistence.repository.PokemonRepository;
import techtest.modyo.pokedex.persistence.repository.PokemonSpeciesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@Service
public class EvolutionService {

    @Autowired
    private EvolutionRepository evolutionRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonSpeciesRepository pokemonSpeciesRepository;


    public Optional<List<String>> getPokemonEvolutions(int pokemonId) {
        Pokemon pokemon = pokemonRepository.getPokemon(pokemonId);
        return getPokemonEvolutions(pokemon);
    }

    public Optional<List<String>> getPokemonEvolutions(String pokemonName) {
        Pokemon pokemon = pokemonRepository.getPokemon(pokemonName);
        return getPokemonEvolutions(pokemon);
    }

    private Optional<List<String>> getPokemonEvolutions(Pokemon pokemon) {
        if (pokemon == null)
            return Optional.empty();
        PokemonSpecies species = pokemonSpeciesRepository.getPokemonSpecies(pokemon.getSpecies());
        if (species == null)
            return Optional.empty();
        int evolutionChainId = species.getEvolutionChainId();
        if (evolutionChainId < 0)
            return Optional.empty();
        List<String> evolutions = findEvolutionsNames(species.getName(), evolutionRepository.getEvolutionChain(evolutionChainId));

        return Optional.ofNullable(evolutions);
    }

    private List<String> findEvolutionsNames(String name, EvolutionChain evolutionChain) {
        if (evolutionChain == null || evolutionChain.getChain() == null)
            return null;
        List<String> evolutions = new ArrayList<>();
        Stack<ChainLink> chainStack = new Stack<>();
        chainStack.add(evolutionChain.getChain());

        while (!chainStack.empty()) {
            ChainLink curChain = chainStack.pop();
            if (curChain.getSpecies().getName().equals(name)) {
                for (ChainLink childChain : curChain.getEvolvesTo())
                    evolutions.add(childChain.getSpecies().getName());
                break;
            }
            if (curChain.getEvolvesTo() != null)
                chainStack.addAll(curChain.getEvolvesTo());
        }

        return evolutions;
    }

}
