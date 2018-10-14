package me.h3inz3l.spigot.rpg.quickcast;

/**
 * The type Quickcast config.
 */
public class QuickcastConfig {

    private int quickcastLength = 3;
    private long timeout = 2;


    /**
     * Instantiates a new Quickcast config.
     */
    QuickcastConfig() {

    }

    /**
     * Gets quickcast length.
     *
     * @return the quickcast length
     */
    public int getQuickcastLength() {
        return quickcastLength;
    }

    /**
     * Sets quickcast length.
     *
     * @param quickcastLength the quickcast length
     */
    public void setQuickcastLength(int quickcastLength) {
        this.quickcastLength = quickcastLength;
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
}
