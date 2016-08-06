/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.ui.elements;

import com.badlogic.gdx.scenes.scene2d.Actor;
import de.hnzlmnn.sgl.impl.exceptions.RootElementNotProvidedException;
import de.hnzlmnn.sgl.ui.interfaces.RootElementProvider;

/**
 * @author Malte Heinzelmann
 */
public abstract class UIElement<T extends Actor> extends Actor implements RootElementProvider<T> {
    private final Class<T> rootElementClass;
    protected T rootElement;

    public UIElement(Class<T> c) {
        rootElementClass = c;
    }

    @Override
    public T getRootElement() {
        if (rootElement == null) {
            throw new RootElementNotProvidedException(rootElementClass);
        }
        return rootElement;
    }
}
