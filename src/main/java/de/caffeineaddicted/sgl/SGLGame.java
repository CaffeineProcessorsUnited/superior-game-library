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
import de.caffeineaddicted.sgl.impl.messages.DisposeMessage;
import de.caffeineaddicted.sgl.impl.messages.PauseMessage;
import de.caffeineaddicted.sgl.impl.messages.ResizeMessage;
import de.caffeineaddicted.sgl.impl.messages.ResumeMessage;
import de.caffeineaddicted.sgl.input.SGLScreenInputMultiplexer;
import de.caffeineaddicted.sgl.interfaces.ApplicationConfigurationProvider;
import de.caffeineaddicted.sgl.interfaces.Provider;
import de.caffeineaddicted.sgl.messages.MessageBasedGame;
import de.caffeineaddicted.sgl.ui.interfaces.Creatable;
import de.caffeineaddicted.sgl.ui.screens.SGLRootScreen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLGame extends MessageBasedGame implements Provider, Creatable, ApplicationConfigurationProvider {

    private boolean created = false;
    private final InputMultiplexer multiplexer;
    private final Map<Class<?>, Object> providing = new HashMap<Class<?>, Object>();

    public SGLGame() {
        this(true);
    }

    public SGLGame(boolean initializeSGL) {
        if (initializeSGL) {
            SGL.game(this);
        }
        supply(SGLScreenInputMultiplexer.class, new SGLScreenInputMultiplexer());
        supply(SGLRootScreen.class, new SGLRootScreen());
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(provide(SGLScreenInputMultiplexer.class));
    }

    public final void create() {
        onCreate();
        created = true;
        Gdx.input.setInputProcessor(multiplexer);
        setScreen(provide(SGLRootScreen.class));
        initGame();
        initScreens();
        startGame();
    }

    public final boolean isCreated() {
        return created;
    }

    protected abstract void initGame();

    protected abstract void initScreens();

    protected abstract void startGame();

    public abstract String getAppName();

    public String getLogTag(String... sub) {
        String append = "";
        for (String s: sub) {
            append += (s.isEmpty() ? "" : ": " + s);
        }
        return getAppName() + append;
    }

    public void log(String message, String... sub) {
        Gdx.app.log(getLogTag(sub), message);
    }

    public void debug(String message, String... sub) {
        Gdx.app.debug(getLogTag(sub), message);
    }

    public void error(String message, String... sub) {
        Gdx.app.error(getLogTag(sub), message);
    }

    public void warn(String message, String... sub) {
        String[] subs = new String[sub.length + 1];
        subs[0] = "WARN";
        System.arraycopy(sub, 0, subs, 1, sub.length);
        log(getLogTag(subs), message);
    }

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
            return key.cast(o);
        }
        throw new ProvidedObjectClassMismatchException(key, o);
    }

    public void toggleFullscreen() {
        if (Gdx.graphics.isFullscreen()) {
            Gdx.graphics.setWindowedMode(
                    config().get(AttributeList.WIDTH),
                    config().get(AttributeList.HEIGHT)
            );
        } else {
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        }
    }
    @Override
    public final void dispose() {
        super.dispose();
        provide(SGLRootScreen.class).dispose();
    }

    @Override
    public final void pause() {
        super.pause();
        provide(SGLRootScreen.class).pause();
    }

    @Override
    public final void resume() {
        super.resume();
        provide(SGLRootScreen.class).resume();
    }

    @Override
    public final void resize(int width, int height) {
        super.resize(width, height);
        provide(SGLRootScreen.class).resize(width, height);
    }
}