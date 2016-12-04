package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Creatable {
    /**
     * Create all necessary resources used by the screen.
     */
    void create();
    /**
     * Gets called when the screen should be created
     */
    void onCreate();
    boolean isCreated();
}
