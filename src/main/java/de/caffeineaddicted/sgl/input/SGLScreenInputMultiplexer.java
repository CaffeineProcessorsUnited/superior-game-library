/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.ui.screens.SGLScreen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Malte Heinzelmann
 */
public class SGLScreenInputMultiplexer implements InputProcessor {
    private boolean debug = false;
    private Map<SGLScreen, InputProcessor> processors;

    public SGLScreenInputMultiplexer() {
        processors = new HashMap<SGLScreen, InputProcessor>();
    }

    public void addProcessor(SGLScreen screen, InputProcessor processor) {
        if (screen == null) throw new NullPointerException("screen cannot be null");
        if (processor == null) throw new NullPointerException("processor cannot be null");
        if (debug) SGL.debug("added processor for screen " + screen.getClass().getSimpleName());
        processors.put(screen, processor);
    }

    public void removeProcessor(SGLScreen screen) {
        if (screen == null) throw new NullPointerException("screen cannot be null");
        if (debug) SGL.debug("deleted processor for screen " + screen.getClass().getSimpleName());
        processors.remove(screen);
    }

    public final void enableDebugging() {
        debug = true;
    }

    public final void disableDebugging() {
        debug = false;
    }

    /**
     * @return the number of processors in this multiplexer
     */
    public int size() {
        return processors.size();
    }

    public void clear() {
        processors.clear();
    }

    public Map<SGLScreen, InputProcessor> getProcessors() {
        return processors;
    }

    public void setProcessors(Map<SGLScreen, InputProcessor> processors) {
        this.processors = processors;
    }

    public boolean keyDown(int keycode) {
        if (debug) SGL.debug("keyDown(keycode: " + keycode + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                processors.get(s).keyDown(keycode);
            }
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (debug) SGL.debug("keyUp(keycode: " + keycode + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                processors.get(s).keyUp(keycode);
            }
        }
        return false;
    }

    public boolean keyTyped(char character) {
        if (debug) SGL.debug("keyTyped(character: " + character + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                processors.get(s).keyTyped(character);
            }
        }
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (debug) SGL.debug("touchDown(screenX: " + screenX + ", screenY: " + screenY + ", pointer: " + pointer + ", button: " + button + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                Vector3 unprojected = s.unproject(new Vector3(screenX, screenY, 0));
                processors.get(s).touchDown((int) unprojected.x, (int) unprojected.y, pointer, button);
            }
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (debug) SGL.debug("touchUp(screenX: " + screenX + ", screenY: " + screenY + ", pointer: " + pointer + ", button: " + button + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                Vector3 unprojected = s.unproject(new Vector3(screenX, screenY, 0));
                processors.get(s).touchUp((int) unprojected.x, (int) unprojected.y, pointer, button);
            }
        }
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (debug) SGL.debug("touchDragged(screenX: " + screenX + ", screenY: " + screenY + ", pointer: " + pointer + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                Vector3 unprojected = s.unproject(new Vector3(screenX, screenY, 0));
                processors.get(s).touchDragged((int) unprojected.x, (int) unprojected.y, pointer);
            }
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if (debug) SGL.debug("mouseMoved(screenX: " + screenX + ", screenY: " + screenY + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                Vector3 unprojected = s.unproject(new Vector3(screenX, screenY, 0));
                processors.get(s).mouseMoved((int) unprojected.x, (int) unprojected.y);
            }
        }
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        if (debug) SGL.debug("scrolled(amount: " + amount + ")");
        Set<SGLScreen> k = new HashSet<SGLScreen>(processors.keySet());
        for (SGLScreen s : k) {
            if (s.isVisible() && processors.get(s) != null) {
                processors.get(s).scrolled(amount);
            }
        }
        return false;
    }
}
