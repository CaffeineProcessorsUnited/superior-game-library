/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.messages;

/**
 * @author Malte Heinzelmann
 */
public abstract class Message extends Bundle {

    public Message() {
        this(null);
    }

    public Message(Bundle bundle) {
        super(bundle);
    }

    public Bundle put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public final String toString() {
        return this.getClass().getSimpleName();
    }
}