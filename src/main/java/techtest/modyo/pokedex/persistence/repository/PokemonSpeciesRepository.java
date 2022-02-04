

package techtest.modyo.pokedex.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import techtest.modyo.pokedex.persistence.entity.PokemonSpecies;


@Repository
public class PokemonSpeciesRepository {

    final private String URL_POKEMON_SPECIES = "pokemon-species/";

    @Autowired
    private RestTemplate restTemplate;

    public PokemonSpecies getPokemonSpecies(String speciesName) {
        PokemonSpecies species = null;
        try {
            species = restTemplate.getForObject(URL_POKEMON_SPECIES + speciesName, PokemonSpecies.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() != HttpStatus.NOT_FOUND)
                throw e;
        }
        return species;
    }

}
