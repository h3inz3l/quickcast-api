package me.h3inz3l.spigot.rpg.quickcast;

import me.h3inz3l.spigot.rpg.quickcast.model.MouseKey;
import me.h3inz3l.spigot.rpg.quickcast.model.Quickcast;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuickcastAPI extends JavaPlugin {

    private List<QuickcastPlugin> plugins = new ArrayList<>();
    private QuickcastConfig config;
    private QuickcastRegistry registry;
    private HashMap<Player, List<MouseKey>> keyHolder = new HashMap<>();

    @Override
    public void onEnable() {
        setup();
        iteratePlugins();
        setupListener();
    }

    private void setupListener() {
        if(!registry.getQuickcasts().isEmpty()) {
            Bukkit.getPluginManager().registerEvents(new QuickcastListener(this), this);
        }
    }

    private void setup() {
        config = new QuickcastConfig();
        registry = new QuickcastRegistry(this);
    }

    private void iteratePlugins() {
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        for(Plugin plugin : plugins) {
            if(plugin.getDescription().getDepend().contains(getName())) {
                if(plugin instanceof QuickcastPlugin) {
                    QuickcastPlugin quickcastPlugin = (QuickcastPlugin) plugin;
                    quickcastPlugin.configure(config);
                    quickcastPlugin.registerQuickcasts(registry);
                    getLogger().info("Plugin '" + plugin.getName() + "' registered! (" + registry.getQuickcasts().size() + " Quickcasts)");
                    this.plugins.add(quickcastPlugin);
                } else {
                    getLogger().severe("Plugin '" + plugin.getName() + "' has a Dependency on " + getName() + " but its Main Class does not implement the interface QuickcastPlugin!");
                    getLogger().severe("Plugin '" + plugin.getName() + "' is ignored!");
                }
            }
        }
        getLogger().info("Successfully registered " + this.plugins.size() + " Plugins!");
    }

    Quickcast addClick(Player player, MouseKey key) {
        List<MouseKey> keys = new ArrayList<>();
        if(keyHolder.containsKey(player)) {
            keys = keyHolder.get(player);
        } else {
            if(key == MouseKey.LEFT) {
                //Cancel if first key is LEFT
                return null;
            }
        }
        keys.add(key);
        getLogger().info(keys.stream()
                .map(Enum::name)
                .collect(Collectors.joining(" ")));
        if(keys.size() == config.getQuickcastLength()) {
            Optional<Quickcast> quickcast = registry.getQuickcastByMouseClicks(keys);
            keyHolder.remove(player);
            if(quickcast.isPresent()) {
                return quickcast.get();
            }
        } else {
            keyHolder.put(player, keys);
        }
        return null;
    }

    void removeClicks(Player player) {
        getLogger().info("Cleaning");
        keyHolder.remove(player);
    }

    QuickcastConfig getQuickcastConfig() {
        return config;
    }
}
