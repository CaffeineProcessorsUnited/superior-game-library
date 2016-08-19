/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.impl.types;

import de.caffeineaddicted.sgl.types.SGLType;

/**
 * @author Malte Heinzelmann
 */
public class SGLBoolean extends SGLType<Boolean> {
    public SGLBoolean(Boolean data) {
        super(data);
    }

    public Boolean cloneData() {
        return new Boolean(get());
    }

    public Boolean not() {
        return !get();
    }

    public Integer compareTo(SGLBoolean b) {
        return get().compareTo(b.get());
    }

    public Boolean and(SGLBoolean b) {
        return get() && b.get();
    }

    public Boolean or(SGLBoolean b) {
        return get() || b.get();
    }

    public Boolean xor(SGLBoolean b) {
        return get() ^ b.get();
    }
}