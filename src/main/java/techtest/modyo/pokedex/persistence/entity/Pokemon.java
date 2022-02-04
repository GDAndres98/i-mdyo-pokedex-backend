package techtest.modyo.pokedex.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private int id;
    private String name;

    @JsonProperty("height")
    private int heightInDc;

    @JsonProperty("weight")
    private int weightInHq;

    @JsonProperty("abilities")
    private List<PokemonAbility> pokemonAbilities;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> abilities;


    @JsonProperty("species")
    private PokemonSpecies pokemonSpecies;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String species;

    private PokemonSprites sprites;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeightInDc() {
        return heightInDc;
    }

    public int getWeightInHq() {
        return weightInHq;
    }

    public String getSpecies() {
        if (pokemonSpecies == null)
            return null;
        return pokemonSpecies.getName();
    }

    public List<String> getAbilities() {
        List<String> array = new ArrayList<>();
        if (pokemonAbilities != null)
            for (PokemonAbility ability : pokemonAbilities)
                array.add(ability.getAbilityName());
        return array;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }


    public static class PokemonSprites {

        @JsonProperty("front_default")
        private String frontDefault;
        @JsonProperty("front_shiny")
        private String frontShiny;
        @JsonProperty("back_default")
        private String backDefault;
        @JsonProperty("back_shiny")
        private String backShiny;

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }

        public String getFrontShiny() {
            return frontShiny;
        }

        public void setFrontShiny(String frontShiny) {
            this.frontShiny = frontShiny;
        }

        public String getBackDefault() {
            return backDefault;
        }

        public void setBackDefault(String backDefault) {
            this.backDefault = backDefault;
        }

        public String getBackShiny() {
            return backShiny;
        }

        public void setBackShiny(String backShiny) {
            this.backShiny = backShiny;
        }
    }
}
