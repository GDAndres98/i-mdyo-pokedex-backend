package techtest.modyo.pokedex.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techtest.modyo.pokedex.persistence.entity.EvolutionChain;
import techtest.modyo.pokedex.persistence.entity.Pokemon;
import techtest.modyo.pokedex.persistence.service.EvolutionService;
import techtest.modyo.pokedex.persistence.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private EvolutionService evolutionService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") int pokemonId) {
        return pokemonService.getPokemon(pokemonId)
                .map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("name") String pokemonName) {
        return pokemonService.getPokemon(pokemonName)
                .map(pokemon -> new ResponseEntity<>(pokemon, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/evolutions")
    public ResponseEntity<EvolutionChain> getPokemonEvolutions(@PathVariable("id") int pokemonId) {
        return evolutionService.getPokemonEvolutions(pokemonId)
                .map(evolutionChain -> new ResponseEntity<>(evolutionChain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}/evolutions")
    public ResponseEntity<EvolutionChain> getPokemonEvolutions(@PathVariable("name") String pokemonName) {
        return evolutionService.getPokemonEvolutions(pokemonName)
                .map(evolutionChain -> new ResponseEntity<>(evolutionChain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
