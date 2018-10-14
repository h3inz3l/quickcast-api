package me.h3inz3l.spigot.rpg.quickcast;

import me.h3inz3l.spigot.rpg.quickcast.model.MouseKey;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * The interface Quickcast renderer.
 */
@FunctionalInterface
public interface QuickcastRenderer {

    /**
     * Render the Clicked MouseKeys to the Player
     *
     * @param player    the player
     * @param mouseKeys the mouse keys
     */
    void render(Player player, List<MouseKey> mouseKeys);

}
