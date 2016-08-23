/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.caffeineaddicted.sgl.impl.exceptions.ProvidedObjectClassMismatchException;
import de.caffeineaddicted.sgl.impl.exceptions.ProvidedObjectIsNullException;
import de.caffeineaddicted.sgl.input.SGLScreenInputMultiplexer;
import de.caffeineaddicted.sgl.interfaces.ApplicationConfigurationProvider;
import de.caffeineaddicted.sgl.interfaces.Provider;
import de.caffeineaddicted.sgl.messages.MessageBasedGame;
import de.caffeineaddicted.sgl.ui.screens.SGLRootScreen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLGame extends MessageBasedGame implements Provider, ApplicationConfigurationProvider {

    protected final InputMultiplexer multiplexer;
    private final Map<Class<?>, Object> providing = new HashMap<Class<?>, Object>();

    public SGLGame() {
        SGL.game(this);
        supply(SGLScreenInputMultiplexer.class, new SGLScreenInputMultiplexer());
        supply(SGLRootScreen.class, new SGLRootScreen());
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(provide(SGLScreenInputMultiplexer.class));
    }

    public void create() {
        Gdx.input.setInputProcessor(multiplexer);
        setScreen(provide(SGLRootScreen.class));
        initGame();
        initScreens();
        startGame();
    }

    protected abstract void initGame();

    protected abstract void initScreens();

    protected abstract void startGame();

    public String getLogTag(String sub) {
        return "SGL" + (!sub.isEmpty() ? ":" + sub : "");
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

    protected final <T> void supply(Class<T> c, T o) {
        providing.put(c, o);
    }

    @Override
    public final <T> boolean provides(Class<T> key) {
        return providing.containsKey(key);
    }

    @Override
    public final <T> T provide(Class<T> key) {
        Object o = providing.get(key);
        if (o == null) {
            throw new ProvidedObjectIsNullException(key);
        }
        if (ClassReflection.isInstance(key, o)) {
            return (T) o;
        }
        throw new ProvidedObjectClassMismatchException(key, o);
    }
}