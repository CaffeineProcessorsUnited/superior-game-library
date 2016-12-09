/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.messages;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.impl.messages.DisposeMessage;
import de.caffeineaddicted.sgl.impl.messages.PauseMessage;
import de.caffeineaddicted.sgl.impl.messages.ResizeMessage;
import de.caffeineaddicted.sgl.impl.messages.ResumeMessage;
import de.caffeineaddicted.sgl.ui.interfaces.Creatable;
import de.caffeineaddicted.sgl.ui.interfaces.Disposeable;
import de.caffeineaddicted.sgl.ui.interfaces.Pausable;
import de.caffeineaddicted.sgl.ui.interfaces.Resizable;

/**
 * @author Malte Heinzelmann
 */
public abstract class MessageBasedGame extends Game implements Pausable, Disposeable, Resizable {
    protected Bundle bundle;
    private boolean paused = false;

    public MessageBasedGame() {
        this(null);
    }

    public MessageBasedGame(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.bundle = bundle;
    }

    @Override
    public void dispose() {
        super.dispose();
        onDispose();
        SGL.message(new DisposeMessage());
    }

    @Override
    public void pause() {
        super.pause();
        onPause();
        paused = true;
        SGL.message(new PauseMessage());
    }

    @Override
    public void resume() {
        super.resume();
        onResume();
        paused = false;
        SGL.message(new ResumeMessage());
    }

    @Override
    public final boolean isPaused() {
        return paused;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        onResize(width, height);
        SGL.message(new ResizeMessage(width, height));
    }

}