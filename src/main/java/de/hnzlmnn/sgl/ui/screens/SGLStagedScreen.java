/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import de.hnzlmnn.sgl.SGLGame;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLStagedScreen<T extends SGLGame> extends SGLScreen<T> {
    protected SGLStage stage;
    private boolean dimBackground;
    private float dimFactor;

    public SGLStagedScreen(T game) {
        super(game);
    }

    public void render(float delta) {
        if (dimBackground) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
            game.getShapeRenderer().setColor(0f, 0f, 0f, dimFactor > 0 ? Math.max(1f, dimFactor) : Math.max(0f, dimFactor));
            game.getShapeRenderer().rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            game.getShapeRenderer().end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
        }
        stage.render(delta);
    }

    public void create() {
        stage = new SGLStage();
    }

    public void setDimBackground(boolean dimBackground) {
        this.dimBackground = dimBackground;
    }

    public void setDimFactor(float dimFactor) {
        this.dimFactor = dimFactor;
    }
}
