package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 */
public class PokemonTrainer {

    /**
     * Trainer name.
     */
    private final String name;

    /**
     * Trainer team.
     */
    private final Team team;

    /**
     * Trainer pokedex.
     */
    private final IPokedex pokedex;

    /**
     * Default constructor.
     *
     * @param name1    Trainer name.
     * @param team1    Trainer team.
     * @param pokedex1 Trainer pokedex.
     */
    public PokemonTrainer(final String name1, final Team team1,
                          final IPokedex pokedex1) {
        this.name = name1;
        this.team = team1;
        this.pokedex = pokedex1;
    }

    /**
     * Name getter.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Team getter.
     *
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Pokedex getter.
     *
     * @return the pokedex
     */
    public IPokedex getPokedex() {
        return pokedex;
    }

}
