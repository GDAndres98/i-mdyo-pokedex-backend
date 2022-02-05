package techtest.modyo.pokedex.persistence.entity;

import java.util.List;

public class ChainLink {
    private PokemonSpecies species;
    private List<ChainLink> evolves_to;

    public PokemonSpecies getSpecies() {
        return species;
    }

    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }

    public List<ChainLink> getEvolves_to() {
        return evolves_to;
    }

    public void setEvolves_to(List<ChainLink> evolves_to) {
        this.evolves_to = evolves_to;
    }
}
