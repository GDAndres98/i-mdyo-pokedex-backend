package techtest.modyo.pokedex.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonSpecies {
    private String name;

    @JsonProperty(value = "evolution_chain", access = JsonProperty.Access.WRITE_ONLY)
    private EvolutionChain evolutionChain;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String evolutionChainId;

    public String getName() {
        return name;
    }

    public int getEvolutionChainId() {
        try {
            String[] splitedString = evolutionChain.getUrl().split("/");
            return Integer.parseInt(splitedString[splitedString.length - 1]);
        } catch (NullPointerException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -2;
        } catch (Exception e) {
            return -3;
        }
    }


}
