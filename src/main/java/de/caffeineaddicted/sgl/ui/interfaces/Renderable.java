package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Renderable {

    void onAct(float delta);

    void onDraw();

    void render(float delta);
}
