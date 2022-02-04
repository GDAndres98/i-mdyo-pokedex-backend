package techtest.modyo.pokedex.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EvolutionChain {
    private int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String url;
    private ChainLink chain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChainLink getChain() {
        return chain;
    }

    public void setChain(ChainLink chain) {
        this.chain = chain;
    }

    public static class ChainLink {
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

}
