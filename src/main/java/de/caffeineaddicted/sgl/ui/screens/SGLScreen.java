/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.ui.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.SGLGame;
import de.caffeineaddicted.sgl.impl.exceptions.ScreenHasNoCameraException;
import de.caffeineaddicted.sgl.input.SGLInputProcessor;
import de.caffeineaddicted.sgl.input.SGLScreenInputMultiplexer;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLScreen<T extends SGLGame> implements Screen {
    protected Camera camera;
    private boolean paused;
    private boolean visible;
    private boolean created;
    private boolean dirty;

    public SGLScreen() {
        paused = false;
        visible = false;
        created = false;
        dirty = true;
        create();
        if (camera == null) {
            camera = new OrthographicCamera();
        }
    }

    /**
     * Updates entities according to delta.
     *
     * @param delta The time in seconds since the last render.
     */
    protected abstract void act(float delta);

    /**
     * Draws all entities.
     */
    protected abstract void draw();

    /**
     * Create all necessary resources used by the screen.
     */
    public abstract void create();

    /**
     * Sets initial positions according to dimensions.
     */
    public abstract void beauty();

    /**
     * Inform the screen that something has changed and it needs an update.
     */
    public final void dirty() {
        dirty = true;
    }

    @Override
    public void show() {
        if (!isCreated()) {
            create();
            created = true;
        }
        visible = true;
        SGL.game().debug(getClass().getSimpleName(), "visible=" + (visible ? "true" : "false"));
    }

    @Override
    public void hide() {
        visible = false;
        SGL.game().debug(getClass().getSimpleName(), "visible=" + (visible ? "true" : "false"));
    }

    @Override
    public final void render(float delta) {
        if (isDirty()) {
            beauty();
        }
        if (!isPaused()) {
            act(delta);
        }
        if (isVisible()) {
            draw();
        }
    }

    @Override
    public void resize(int width, int height) {
        dirty();
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    /**
     * Was the {@link #create() create} method already called?
     *
     * @return true if the screen was created
     */
    public boolean isCreated() {
        return created;
    }

    /**
     * Is the screen currently paused?
     *
     * @return true if the screen is paused
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Is the screen currently visible?
     *
     * @return true if the screen is visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Does the screen entities need an update (e.g. after resizing the window)?
     *
     * @return true if the screen entities need to be updated
     */
    public boolean isDirty() {
        return dirty;
    }

    /**
     * Adds an {@link SGLInputProcessor SGLInputProcessor} to the list of input listeners for this {@link SGLScreen screen}
     *
     * @param processor {@link SGLInputProcessor SGLInputProcessor}
     */
    public final void registerInputListener(SGLInputProcessor processor) {
        SGL.game().provide(SGLScreenInputMultiplexer.class).addProcessor(this, processor);
    }

    /**
     * Projects world coordinates to screen coordinates.
     *
     * @param worldCoordinates {@link Vector3 Vector3} with the coordinates in the world
     * @return {@link Vector3 Vector3} with the coordinates on screen
     * @see Camera#project(Vector3)
     */
    public final Vector3 project(Vector3 worldCoordinates) {
        if (camera == null) {
            throw new ScreenHasNoCameraException();
        }
        return camera.project(worldCoordinates);
    }

    /**
     * Projects screen coordinates to world coordinates.
     *
     * @param screenCoordinates {@link Vector3 Vector3} with the coordinates on screen
     * @return {@link Vector3 Vector3} with the coordinates in the world
     * @see Camera#unproject(Vector3)
     */
    public final Vector3 unproject(Vector3 screenCoordinates) {
        if (camera == null) {
            throw new ScreenHasNoCameraException();
        }
        return camera.unproject(screenCoordinates);
    }

}