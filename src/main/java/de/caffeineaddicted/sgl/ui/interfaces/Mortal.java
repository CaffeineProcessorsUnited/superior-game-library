package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Mortal {
    void die();
    void onDie();
    boolean isDead();
}
