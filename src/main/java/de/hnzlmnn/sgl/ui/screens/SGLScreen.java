/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.ui.screens;

import com.badlogic.gdx.Screen;
import de.hnzlmnn.sgl.SGLGame;
import de.hnzlmnn.sgl.impl.messages.DefaultMessage;
import de.hnzlmnn.sgl.interfaces.MessageReceiver;
import de.hnzlmnn.sgl.messages.Bundle;
import de.hnzlmnn.sgl.messages.Message;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLScreen<T extends SGLGame> implements Screen, MessageReceiver {
    public final T game;
    private boolean paused;
    private boolean visible;
    private boolean created;

    public SGLScreen(T game) {
        this.game = game;
        created = false;
        created = false;
        visible = false;
    }

    public abstract void render(float delta);

    public abstract void create();

    @Override
    public void show() {
        if (!created) {
            create();
            created = true;
        }
        visible = true;
        game.debug(getClass().getSimpleName(), "visible=" + (visible ? "true" : "false"));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void hide() {
        visible = false;
        game.debug(getClass().getSimpleName(), "visible=" + (visible ? "true" : "false"));
    }

    @Override
    public void dispose() {

    }

    public boolean isCreated() {
        return created;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public void onMessageReceived(Message message) {
        onMessageReceived(message, new Bundle());
    }

    @Override
    public void onMessageReceived(Bundle bundle) {
        onMessageReceived(new DefaultMessage(), bundle);
    }

    @Override
    public void onMessageReceived(Message message, Bundle bundle) {
        game.warning(getClass().getName() + ": Doesn't handle Messages in a message based game!");
    }
}