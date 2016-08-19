/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.impl.input;

import de.caffeineaddicted.sgl.SGLGame;
import de.caffeineaddicted.sgl.input.SGLInputProcessor;

/**
 * @author Malte Heinzelmann
 */

public class GlobalInputProcessor extends SGLInputProcessor {

    SGLGame game;

    public GlobalInputProcessor(SGLGame game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
//            case Input.Keys.F11:
//                game.message(new ToggleFullscreenMessage());
//                break;
        }
        return false;
    }

}