package techtest.modyo.pokedex.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techtest.modyo.pokedex.persistence.entity.Pokemon;
import techtest.modyo.pokedex.persistence.repository.PokemonRepository;

import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Optional<Pokemon> getPokemon(int pokemonId) {
        return Optional.ofNullable(pokemonRepository.getPokemon(pokemonId));
    }

    public Optional<Pokemon> getPokemon(String pokemonName) {
        return Optional.ofNullable(pokemonRepository.getPokemon(pokemonName));
    }

}
