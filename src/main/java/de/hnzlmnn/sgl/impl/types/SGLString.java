/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.impl.types;

import de.hnzlmnn.sgl.types.SGLType;

/**
 * @author Malte Heinzelmann
 */

public class SGLString extends SGLType<String> {

    public SGLString() {
        super();
    }

    public SGLString(String data) {
        super(data);
    }

    public String cloneData() {
        return new String(get());
    }

    public String plus(SGLString b) {
        return get() + b.get();
    }

    public Integer compareTo(SGLString b) {
        return get().compareTo(b.get());
    }

    public String plusAssign(SGLString b) {
        return assign(plus(b));
    }
}