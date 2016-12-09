package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Resizable {
    /**
     * Resized by.
     */
    void resize(int width, int height);
    /**
     * Gets called when the game was resized
     */
    void onResize(int width, int height);
}
