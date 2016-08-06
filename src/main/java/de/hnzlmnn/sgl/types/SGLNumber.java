/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.types;

/**
 * @author Malte Heinzelmann
 */

public abstract class SGLNumber<T extends Number> extends SGLType<T> {
    public SGLNumber() {
        super();

    }

    public SGLNumber(T data) {
        super(data);
    }

    /*
     * conversion
     */
    public Byte toByte() {
        return get().byteValue();
    }

    public Short toShort() {
        return get().shortValue();
    }

    public Integer toInteger() {
        return get().intValue();
    }

    public Long toLong() {
        return get().longValue();
    }

    public Float toFloat() {
        return get().floatValue();
    }

    public Double toDouble() {
        return get().doubleValue();
    }
}