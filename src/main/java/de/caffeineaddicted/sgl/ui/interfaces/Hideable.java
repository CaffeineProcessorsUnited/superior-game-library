package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Hideable {
    void hide();
    void onHide();
    void show();
    void onShow();
    boolean isVisible();
}
