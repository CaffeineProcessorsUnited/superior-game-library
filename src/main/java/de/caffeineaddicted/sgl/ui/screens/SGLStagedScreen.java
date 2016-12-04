/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.SGLGame;
import de.caffeineaddicted.sgl.impl.exceptions.ProvidedObjectIsNullException;
import de.caffeineaddicted.sgl.input.SGLScreenInputMultiplexer;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLStagedScreen<T extends SGLGame> extends SGLScreen<T> {
    private SGLStage stage;
    private boolean dimBackground = false;
    private float dimFactor;

    @Override
    public void create() {
        Viewport viewport = null;
        SpriteBatch batch = null;
        try {
            viewport = SGL.provide(Viewport.class);
            batch = SGL.provide(SpriteBatch.class);
        } catch (ProvidedObjectIsNullException pone) {
            // either viewport or batch is null
        }
        if (viewport == null) {
            stage = new SGLStage();
        } else {
            if (batch == null) {
                stage = new SGLStage(viewport);
            } else {
                stage = new SGLStage(viewport, batch);
            }
        }
        camera = stage.getCamera();
        try {
            SGL.provide(SGLScreenInputMultiplexer.class).addProcessor(this, stage);
        } catch (ProvidedObjectIsNullException pone) {
            // don't register stage as InputProcessor
        }
    }

    @Override
    public void act(float delta) {
        stage.act(delta);
    }

    @Override
    public void resize (int width, int height) {
        if (isCreated()) {
            stage.getViewport().update(width, height);
        }
    }

    @Override
    public void draw() {
        if (dimBackground) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            SGL.game().provide(ShapeRenderer.class).begin(ShapeRenderer.ShapeType.Filled);
            SGL.game().provide(ShapeRenderer.class).setColor(0f, 0f, 0f, Math.max(1f, Math.abs(dimFactor)));
            SGL.game().provide(ShapeRenderer.class).rect(stage.getViewOrigX(), stage.getViewOrigY(), stage.getWidth(), stage.getHeight());
            SGL.game().provide(ShapeRenderer.class).end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
        }
        stage.draw();
    }

    public void setDimBackground(boolean dimBackground) {
        this.dimBackground = dimBackground;
    }

    public void setDimFactor(float dimFactor) {
        this.dimFactor = dimFactor;
    }

    public SGLStage stage() {
        return stage;
    }

}
