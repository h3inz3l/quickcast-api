package me.h3inz3l.spigot.rpg.quickcast;

/**
 * The interface Quickcast plugin.
 */
public interface QuickcastPlugin {

    /**
     * Configure the {@link QuickcastAPI}
     *
     * @param config THe Configuration
     */
    void configure(QuickcastConfig config);

    /**
     * Register Quickcasts
     *
     * @param registry The Registry to register Quickcasts on
     */
    void registerQuickcasts(QuickcastRegistry registry);

    /**
     * Gets the {@link QuickcastRenderer} to display MouseClick information to the player.
     * @see me.h3inz3l.spigot.rpg.quickcast.renderer.ChatRenderer for an example
     * @see me.h3inz3l.spigot.rpg.quickcast.renderer.ActionBarRenderer for an example
     *
     * @return the renderer
     */
    QuickcastRenderer getRenderer();

}
