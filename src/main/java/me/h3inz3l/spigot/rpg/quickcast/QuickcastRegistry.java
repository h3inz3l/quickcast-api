package me.h3inz3l.spigot.rpg.quickcast;

import me.h3inz3l.spigot.rpg.quickcast.model.MouseKey;
import me.h3inz3l.spigot.rpg.quickcast.model.Quickcast;
import me.h3inz3l.spigot.rpg.quickcast.model.QuickcastAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * The type Quickcast registry.
 */
public class QuickcastRegistry {

    private List<Quickcast> quickcasts;
    private QuickcastAPI plugin;

    /**
     * Instantiates a new Quickcast registry.
     *
     * @param plugin
     */
    QuickcastRegistry(QuickcastAPI plugin) {
        this.plugin = plugin;
        quickcasts = new ArrayList<>();
    }

    /**
     * Gets quickcasts.
     *
     * @return the quickcasts
     */
    public List<Quickcast> getQuickcasts() {
        return quickcasts;
    }

    /**
     * Register quickcast.
     *
     * @param name           the name
     * @param adapter        the adapter
     * @param keyCombination the key combination
     */
    public void registerQuickcast(String name, QuickcastAdapter adapter, MouseKey... keyCombination) {
        registerQuickcast(new Quickcast(name, Arrays.asList(keyCombination), adapter));
    }

    /**
     * Register quickcast.
     *
     * @param quickcast the quickcast
     */
    public void registerQuickcast(Quickcast quickcast) {
        List<String> strings = validateQuickcast(quickcast);
        if (strings.isEmpty()) {
            quickcasts.add(quickcast);
        } else {
            Logger logger = plugin.getLogger();
            for(String msg : strings) {
                logger.severe(msg);
            }
            logger.severe("Skipping registration of '" + quickcast.getName() + "'!");
        }
    }

    private List<String> validateQuickcast(Quickcast quickcast) {
        List<String> messages = new ArrayList<>();
        if (quickcast.getKeyCombination().isEmpty()) {
            messages.add("The Quickcast '" + quickcast.getName() + "' does not have a KeyCombination defined!");
        }
        if(quickcast.getKeyCombination().get(0) != MouseKey.RIGHT) {
            messages.add("A Quickcast's KeyCombination needs to start with a RIGHT Click! (" + quickcast.getName() + " starts with a Left Click)");
        }
        for (Quickcast other : quickcasts) {
            if (other.getName().equals(quickcast.getName())) {
                messages.add("A Quickcast with the Name '" + other.getName() + "' already exists!");
            }
            if (other.getKeyCombination().equals(quickcast.getKeyCombination())) {
                messages.add("A Quickcast with the same KeyCombination already exists! (Quickcast: " + other.getName() + ")");
            }
        }
        return messages;
    }

    /**
     * Register quickcasts.
     *
     * @param quickcasts the quickcasts
     */
    public void registerQuickcasts(Quickcast... quickcasts) {
        for (Quickcast q : quickcasts) {
            registerQuickcast(q);
        }
    }

    public Optional<Quickcast> getQuickcastByMouseClicks(List<MouseKey> keys) {
        return quickcasts.stream()
                .filter(q -> q.getKeyCombination().equals(keys))
                .findAny();
    }

}
