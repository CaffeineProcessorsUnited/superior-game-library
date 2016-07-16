/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.input;

import com.badlogic.gdx.InputProcessor;
import de.hnzlmnn.sgl.screens.SGLScreen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Malte Heinzelmann
 */
public class SGLScreenInputMultiplexer implements InputProcessor {
    private Map<SGLScreen, InputProcessor> processors;

    public SGLScreenInputMultiplexer() {
        processors = new HashMap<SGLScreen, InputProcessor>();
    }

    public void addProcessor(SGLScreen screen, InputProcessor processor) {
        screen.game.debug(screen.getClass().getSimpleName() + " added Processor " + processor.getClass().getSimpleName());
        if (screen == null) throw new NullPointerException("screen cannot be null");
        if (processor == null) throw new NullPointerException("processor cannot be null");
        processors.put(screen, processor);
    }

    public void removeProcessor(SGLScreen screen) {
        if (screen == null) throw new NullPointerException("screen cannot be null");
        processors.remove(screen);
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
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).keyDown(keycode);
        return false;
    }

    public boolean keyUp(int keycode) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).keyUp(keycode);
        return false;
    }

    public boolean keyTyped(char character) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).keyTyped(character);
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null)
                processors.get(s).touchDown(screenX, screenY, pointer, button);
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null)
                processors.get(s).touchUp(screenX, screenY, pointer, button);
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).touchDragged(screenX, screenY, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).mouseMoved(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        Set<SGLScreen> k = new HashSet(processors.keySet());
        for (SGLScreen s : k)
            if (s.isVisible() && processors.get(s) != null) processors.get(s).scrolled(amount);
        return false;
    }
}
