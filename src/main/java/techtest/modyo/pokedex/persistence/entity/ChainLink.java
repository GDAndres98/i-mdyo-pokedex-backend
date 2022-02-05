package techtest.modyo.pokedex.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChainLink {
    private PokemonSpecies species;

    @JsonProperty("evolves_to")
    private List<ChainLink> evolvesTo;

    public PokemonSpecies getSpecies() {
        return species;
    }

    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }

    public List<ChainLink> getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(List<ChainLink> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }
}
