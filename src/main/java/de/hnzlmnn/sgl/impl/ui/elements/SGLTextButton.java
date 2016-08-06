/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.impl.ui.elements;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import de.hnzlmnn.sgl.ui.elements.UIElement;

/**
 * @author Malte Heinzelmann
 */
public class SGLTextButton extends UIElement<TextButton> {


    public SGLTextButton(String text, Skin skin) {
        super(TextButton.class, new TextButton(text, skin));
    }
}
