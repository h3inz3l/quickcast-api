package me.h3inz3l.spigot.rpg.quickcast.model;

import org.bukkit.event.block.Action;

/**
 * The enum Mouse key.
 */
public enum MouseKey {

    /**
     * Left mouse key.
     */
    LEFT,
    /**
     * Right mouse key.
     */
    RIGHT;

    public static MouseKey fromAction(Action action) {
        if(action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

}
