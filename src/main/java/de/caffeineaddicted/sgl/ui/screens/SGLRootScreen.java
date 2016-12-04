/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.SGLGame;
import de.caffeineaddicted.sgl.impl.exceptions.ScreenNotLoadedException;
import de.caffeineaddicted.sgl.messages.Message;

import java.util.*;

/**
 * @author Malte Heinzelmann
 */
public class SGLRootScreen<T extends SGLGame> implements Screen {

    private Map<Class<? extends SGLScreen>, SGLScreen> screens;
    private Map<ZINDEX, Class<? extends SGLScreen>> activeScreens;
    private boolean renderWhilePasued = true;
    private boolean paused = false;

    public SGLRootScreen() {
        screens = new HashMap<Class<? extends SGLScreen>, SGLScreen>();
        activeScreens = new HashMap<ZINDEX, Class<? extends SGLScreen>>();
    }

    public void loadScreen(SGLScreen screen) {
        loadScreen(screen, false);
    }

    public void loadScreen(SGLScreen screen, boolean override) {
        if (screens.containsKey(screen) && !override) {
            throw new RuntimeException("A screen of this type is already loaded. If you try to replace it u can either delete it and then add the screen oder use the override switch");
        } else {
            screens.put(screen.getClass(), screen);
        }
    }

    public void unloadScreen(Class<? extends SGLScreen> screen) {
        activeScreens.remove(screen);
        screens.remove(screen);
    }

    public void showScreen(Class<? extends SGLScreen> screenclass, ZINDEX zindex) {
        hideScreen(zindex);
        SGLScreen screen = screens.get(screenclass);
        if (screen != null) {
            activeScreens.put(zindex, screenclass);
            SGL.game().debug("showing screen " + screenclass.getSimpleName() + " on " + zindex.name());
            screen.show();
            screen.resume();
            screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        } else {
            SGL.game().error("The screen " + screenclass.getSimpleName() + " is not loaded! Load it before u show it!");
        }
    }

    public void hideScreen(ZINDEX zindex) {
        Class<? extends SGLScreen> oldScreenclass;
        if ((oldScreenclass = activeScreens.get(zindex)) != null) {
            SGLScreen oldScreen = screens.get(oldScreenclass);
            if (oldScreen != null) {
                SGL.game().debug("hiding screen " + oldScreenclass.getSimpleName() + " on " + zindex.name());
                activeScreens.put(zindex, null);
                oldScreen.hide();
                oldScreen.pause();
            }
        }
    }

    public void hideScreen(Class<? extends SGLScreen> screenclass) {
        ZINDEX zindex = null;
        for (Map.Entry<ZINDEX, Class<? extends SGLScreen>> pair : activeScreens.entrySet()) {
            if (pair.getValue() == screenclass) {
                zindex = pair.getKey();
                break;
            }
        }
        if (zindex != null) {
            hideScreen(zindex);
        }
    }

    public boolean isLoaded(Class<? extends SGLScreen> screenclass) {
        return screens.containsKey(screenclass);
    }

    public <T extends SGLScreen> T get(Class<T> screenclass) {
        SGLScreen screen = screens.get(screenclass);
        if (ClassReflection.isInstance(screenclass, screen)) {
            return screenclass.cast(screen);
        }
        throw new ScreenNotLoadedException(screenclass);
    }

    private void renderIfNotNull(ZINDEX zindex, float delta) {
        Class<? extends SGLScreen> screenclass = activeScreens.get(zindex);
        if (screenclass != null) {
            SGLScreen screen = screens.get(screenclass);
            if (screen != null) {
                screen.render(delta);
            }
        }
    }

    @Override
    public void show() {
        // we have to present a screen
        for (SGLScreen screen : screens.values()) {
            screen.show();
        }
    }
    
    /*
    Redirect interface calls to affected children
     */

    public void render(float delta) {
        render(delta, false);
    }

    /**
     * Renders all currently active screens. Lower index gets drawn to the background.
     */
    public void render(float delta, boolean forceRender) {
        Gdx.gl.glClearColor(.0f, .0f, .0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        if (paused && !renderWhilePasued && !forceRender) {
            return;
        }
        for (ZINDEX zindex : ZINDEX.asSortedArray()) {
            renderIfNotNull(zindex, delta);
        }
    }

    @Override
    public void resize(int width, int height) {
        // why should I resize not drawn screens? they get resized when the are shown
        for (ZINDEX zindex : ZINDEX.asSortedArray()) {
            Class<? extends SGLScreen> screenclass;
            if ((screenclass = activeScreens.get(zindex)) != null) {
                SGLScreen screen;
                if ((screen = screens.get(screenclass)) != null) {
                    screen.resize(width, height);
                }
            }
        }
    }

    @Override
    public void pause() {
        // we paused the game
        paused = true;
        SGL.game().debug("U can't pause root!");
        for (SGLScreen screen : screens.values()) {
            screen.pause();
        }
    }

    @Override
    public void resume() {
        // we resumed the game
        paused = false;
        SGL.game().debug("Unleash the kraken");
        for (SGLScreen screen : screens.values()) {
            screen.resume();
        }
    }

    @Override
    public void hide() {
        // screen got hidden
        for (SGLScreen screen : screens.values()) {
            screen.hide();
        }
    }

    @Override
    public void dispose() {
        // why would you do that?
        for (SGLScreen screen : screens.values()) {
            screen.dispose();
        }
    }

    public enum ZINDEX {
        FAREST(0), FAR(1), MID(2), NEAR(3), NEAREST(4);

        public final Integer value;

        ZINDEX(Integer value) {
            this.value = value;
        }

        static ArrayList<ZINDEX> asSortedArray() {
            ArrayList<ZINDEX> list = new ArrayList<ZINDEX>(Arrays.asList(ZINDEX.values()));
            Collections.sort(list, new Comparator<ZINDEX>() {
                @Override
                public int compare(ZINDEX o1, ZINDEX o2) {
                    return o1.value.compareTo(o2.value);
                }
            });
            return list;
        }
    }
}