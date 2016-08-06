/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.hnzlmnn.sgl.impl.exceptions.NoShapeRendererProvidedException;
import de.hnzlmnn.sgl.input.SGLScreenInputMultiplexer;
import de.hnzlmnn.sgl.messages.MessageBasedGame;
import de.hnzlmnn.sgl.ui.interfaces.ShapeRendererProvider;
import de.hnzlmnn.sgl.ui.screens.SGLRootScreen;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLGame extends MessageBasedGame implements ShapeRendererProvider {

    protected final SGLScreenInputMultiplexer screenInput;
    protected final InputMultiplexer multiplexer;
    protected final SGLRootScreen rootScreen;

    public SGLGame() {
        screenInput = new SGLScreenInputMultiplexer();
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(screenInput);
        rootScreen = new SGLRootScreen(this);
    }

    public void create() {
        Gdx.input.setInputProcessor(multiplexer);
        setScreen(rootScreen);
        initScreens();
    }

    protected abstract void initScreens();

    public String getLogTag(String sub) {
        return "SGLGame" + (!sub.isEmpty() ? ":" + sub : "");
    }

    public void log(String message) {
        Gdx.app.log("", message);
    }

    public void log(String sub, String message) {
        Gdx.app.log(getLogTag(sub), message);
    }

    public void debug(String message) {
        debug("", message);
    }

    public void debug(String sub, String message) {
        Gdx.app.debug(getLogTag(sub), message);
    }

    public void error(String message) {
        error("", message);
    }

    public void error(String sub, String message) {
        Gdx.app.error(getLogTag(sub), message);
    }

    public void warning(String message) {
        error("", message);
    }

    public void warning(String sub, String message) {
        log(getLogTag("WARNING: " + sub), message);
    }

    public abstract Viewport createViewport();

    public ShapeRenderer getShapeRenderer() {
        throw new NoShapeRendererProvidedException();
    };

}