/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.ui.screens;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.caffeineaddicted.sgl.etities.Actor;
import de.caffeineaddicted.sgl.etities.Group;
import de.caffeineaddicted.sgl.ui.interfaces.Creatable;

/**
 * @author Malte Heinzelmann
 */
public class SGLStage extends Stage implements Creatable {
    private Group root;
    private boolean created = false;

    public SGLStage () {
        super();
    }

    public SGLStage(Viewport viewport) {
        super(viewport);
    }

    public SGLStage(Viewport viewport, Batch batch) {
        super(viewport, batch);
    }

    public float getViewWidth() {
        return getCamera().viewportWidth;
    }

    public float getViewHeight() {
        return getCamera().viewportHeight;
    }

    public float getViewOrigX() {
        return getCamera().position.x - (getViewWidth() / 2);
    }

    public float getViewOrigY() {
        return getCamera().position.y - (getViewHeight() / 2);
    }

    @Override
    public final void create() {
        onCreate();
        created = true;
    }

    public void onCreate() {
        root = new Group();
        root.stage(this);
    }

    @Override
    public boolean isCreated() {
        return created;
    }

    @Override
    public void clear() {
        super.clear();
        root.clear();
    }

    public String addActor(Actor a) {
        return root.addActor(a);
    }

    public String addActor(String name, Actor a) {
        return root.addActor(name, a);
    }

    public Actor getActor(String name) {
        return (Actor) root.getActor(name);
    }

    public <T> T getActor(String name, Class<T> type) {
        return type.cast(root.getActor(name));
    }

    public void removeActor(Actor a) {
        root.removeActor(a);
    }

    public void act(float delta) {
        root.act(delta);
    }

    public void draw() {
        Camera camera = getViewport().getCamera();
        camera.update();

        if (!root.isVisible()) return;

        if (getBatch() != null) {
            getBatch().setProjectionMatrix(camera.combined);
            getBatch().begin();
            root.draw(getBatch(), 1);
            getBatch().end();
        }
    }
}
