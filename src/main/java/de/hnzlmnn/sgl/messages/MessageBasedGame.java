/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.messages;

import com.badlogic.gdx.Game;

/**
 * @author Malte Heinzelmann
 */
public abstract class MessageBasedGame extends Game {

    public MessageBasedGame() {
        this(null);
    }

    public MessageBasedGame(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
    }

    public abstract void message(Message message);

}