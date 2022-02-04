package techtest.modyo.pokedex.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import techtest.modyo.pokedex.persistence.entity.EvolutionChain;
import techtest.modyo.pokedex.persistence.entity.Pokemon;


@Repository
public class EvolutionRepository {

    private static final String URL_EVOLUTION = "evolution-chain/";
    @Autowired
    private RestTemplate restTemplate;

    public EvolutionChain getEvolutionChain(int evolutionChainId) {
        EvolutionChain evolution = null;
        try {
            evolution = restTemplate.getForObject(URL_EVOLUTION + evolutionChainId, EvolutionChain.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() != HttpStatus.NOT_FOUND)
                throw e;
        }
        return evolution;
    }

}
