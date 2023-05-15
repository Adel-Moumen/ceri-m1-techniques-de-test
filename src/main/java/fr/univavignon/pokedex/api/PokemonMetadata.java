package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 *
 * @author fv
 */
public class PokemonMetadata {

    /**
     * Pokemon index.
     **/
    private final int index;

    /**
     * Pokemon name.
     **/
    private final String name;

    /**
     * Pokemon attack level.
     **/
    private final int attack;

    /**
     * Pokemon defense level.
     **/
    private final int defense;

    /**
     * Pokemon stamina level.
     **/
    private final int stamina;

    /**
     * Default constructor.
     *
     * @param index1   Pokemon index.
     * @param name1    Pokemon name.
     * @param attack1  Attack level.
     * @param defense1 Defense level.
     * @param stamina1 Stamina level.
     */
    public PokemonMetadata(final int index1,
                           final String name1,
                           final int attack1,
                           final int defense1,
                           final int stamina1) {
        this.index = index1;
        this.name = name1;
        this.attack = attack1;
        this.defense = defense1;
        this.stamina = stamina1;
    }

    /**
     * Index getter.
     *
     * @return index
     **/
    public int getIndex() {
        return index;
    }

    /**
     * Name getter.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    /**
     * Attack level getter.
     *
     * @return attack
     **/
    public int getAttack() {
        return attack;
    }

    /**
     * Defense level getter.
     *
     * @return defense
     **/
    public int getDefense() {
        return defense;
    }

    /**
     * Stamina level getter.
     *
     * @return stamina
     **/
    public int getStamina() {
        return stamina;
    }

}
