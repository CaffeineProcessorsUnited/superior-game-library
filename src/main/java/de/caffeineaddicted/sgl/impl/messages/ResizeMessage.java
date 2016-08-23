/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.impl.messages;

import de.caffeineaddicted.sgl.messages.Message;

/**
 * @author Malte Heinzelmann
 */
public class ResizeMessage extends Message {

    public final static String BUNDLE_WIDTH = "ResizeMessageBundleWidth";
    public final static String BUNDLE_HEIGHT = "ResizeMessageBundleHeight";

    public ResizeMessage(int width, int height) {
        super();
        put(BUNDLE_WIDTH, width);
        put(BUNDLE_HEIGHT, height);
    }
}
