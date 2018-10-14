package me.h3inz3l.spigot.rpg.quickcast.model;

import java.util.List;

/**
 * The type Quickcast.
 */
public class Quickcast {

    private String name;
    private List<MouseKey> keyCombination;
    private QuickcastAdapter adapter;

    /**
     * Instantiates a new Quickcast.
     *
     * @param name           the name
     * @param keyCombination The Key Combination needed to execute the Quickcast
     * @param adapter        the adapter
     */
    public Quickcast(String name, List<MouseKey> keyCombination, QuickcastAdapter adapter) {
        this.name = name;
        this.keyCombination = keyCombination;
        this.adapter = adapter;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets adapter.
     *
     * @return the adapter
     */
    public QuickcastAdapter getAdapter() {
        return adapter;
    }

    /**
     * Sets adapter.
     *
     * @param adapter the adapter
     */
    public void setAdapter(QuickcastAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Gets key combination.
     *
     * @return the key combination
     */
    public List<MouseKey> getKeyCombination() {
        return keyCombination;
    }

    /**
     * Sets key combination.
     *
     * @param keyCombination the key combination
     */
    public void setKeyCombination(List<MouseKey> keyCombination) {
        this.keyCombination = keyCombination;
    }
}
