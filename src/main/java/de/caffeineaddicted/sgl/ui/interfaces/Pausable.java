package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Pausable {
    void pause();
    void onPause();
    void resume();
    void onResume();
    boolean isPaused();
}
