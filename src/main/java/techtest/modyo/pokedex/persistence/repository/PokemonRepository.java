package techtest.modyo.pokedex.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import techtest.modyo.pokedex.persistence.entity.Pokemon;


@Repository
public class PokemonRepository {

    final private String URL_POKEMON = "pokemon/";

    @Autowired
    private RestTemplate restTemplate;

    public Pokemon getPokemon(int pokemonId) {
        Pokemon pokemon = null;
        try {
            pokemon = restTemplate.getForObject(URL_POKEMON + pokemonId, Pokemon.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() != HttpStatus.NOT_FOUND)
                throw e;
        }
        return pokemon;
    }

    public Pokemon getPokemon(String pokemonName) {
        Pokemon pokemon = null;
        try {
            pokemon = restTemplate.getForObject(URL_POKEMON + pokemonName, Pokemon.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() != HttpStatus.NOT_FOUND)
                throw e;
        }
        return pokemon;
    }

}
