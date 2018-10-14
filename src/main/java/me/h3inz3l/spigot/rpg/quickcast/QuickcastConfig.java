package me.h3inz3l.spigot.rpg.quickcast;

import me.h3inz3l.spigot.rpg.quickcast.renderer.RendererType;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * The type Quickcast config.
 */
public class QuickcastConfig {

    private long timeout;
    private RendererType rendererType;
    private String renderColor;
    private int maxLength;

    /**
     * Instantiates a new Quickcast config.
     *
     * @param quickcastAPI the quickcast api
     */
    QuickcastConfig(QuickcastAPI quickcastAPI) {
        FileConfiguration config = quickcastAPI.getConfig();
        rendererType = RendererType.valueOf(config.getString("renderer"));
        renderColor = config.getString("color").replace("&", "§");
        timeout = config.getLong("timeout");
        maxLength = config.getInt("max-length");
    }

    /**
     * Gets timeout in Seconds
     *
     * @return the timeout
     */
    public long getTimeout() {
        return timeout;
    }

    /**
     * Sets timeout in Seconds
     *
     * @param timeout the timeout
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * Gets renderer type.
     *
     * @return the renderer type
     */
    public RendererType getRendererType() {
        return rendererType;
    }

    /**
     * Sets renderer type.
     *
     * @param rendererType the renderer type
     */
    public void setRendererType(RendererType rendererType) {
        this.rendererType = rendererType;
    }

    /**
     * Gets render color.
     *
     * @return the render color
     */
    public String getRenderColor() {
        return renderColor;
    }

    /**
     * Sets render color.
     *
     * @param renderColor the render color
     */
    public void setRenderColor(String renderColor) {
        this.renderColor = renderColor;
    }

    /**
     * Gets max length.
     *
     * @return the max length
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets max length.
     *
     * @param maxLength the max length
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
