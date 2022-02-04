package techtest.modyo.pokedex.persistence.entity;

public class PokemonAbility {
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public String getAbilityName() {
        return ability.getName();
    }
}
