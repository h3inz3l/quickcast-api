package me.h3inz3l.spigot.rpg.quickcast;

import me.h3inz3l.spigot.rpg.quickcast.model.MouseKey;
import me.h3inz3l.spigot.rpg.quickcast.model.Quickcast;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class QuickcastListener implements Listener {

    private QuickcastAPI plugin;
    private HashMap<Player, Integer> tasks = new HashMap<>();

    public QuickcastListener(QuickcastAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onInteract(PlayerInteractEntityEvent event) {
        executeEventLogic(MouseKey.RIGHT, event.getPlayer());
    }

    @EventHandler
    void onInteract(PlayerInteractEvent event) {
        executeEventLogic(MouseKey.fromAction(event.getAction()), event.getPlayer());
    }

    private void executeEventLogic(MouseKey key, Player player) {
        Quickcast quickcast = plugin.addClick(player, key);
        if(tasks.containsKey(player)) {
            Bukkit.getScheduler().cancelTask(tasks.get(player));
        }
        int i = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,
                () -> plugin.removeClicks(player),
                plugin.getQuickcastConfig().getTimeout() * 20L); //Timeout in secs --> To server Ticks
        tasks.put(player, i);
        if (quickcast != null) {
            quickcast.getAdapter().execute(player);
        }
    }

}
