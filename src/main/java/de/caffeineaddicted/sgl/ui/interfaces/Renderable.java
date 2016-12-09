package de.caffeineaddicted.sgl.ui.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Renderable {

    void onBeforeAct(float delta);
    void onAfterAct(float delta);

    void onBeforeDraw();
    void onAfterDraw();

    void render(float delta);
}
