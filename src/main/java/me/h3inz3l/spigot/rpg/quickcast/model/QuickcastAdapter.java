package me.h3inz3l.spigot.rpg.quickcast.model;

import org.bukkit.entity.Player;

/**
 * The interface Quickcast adapter.
 */
@FunctionalInterface
public interface QuickcastAdapter {

    /**
     * Execute the Quickcast
     *
     * @param player the player who casted the Quickcast
     */
    void execute(Player player);

}
