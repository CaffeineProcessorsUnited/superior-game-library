/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.ui.screens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * @author Malte Heinzelmann
 */
public class SGLStage extends Stage {
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
}
