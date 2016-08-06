/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.impl.types;

import de.hnzlmnn.sgl.types.SGLNumber;

/**
 * @author Malte Heinzelmann
 */

public class SGLLong extends SGLNumber<Long> {
    public SGLLong() {
        super();

    }

    public SGLLong(Long data) {
        super(data);
    }

    public Long cloneData() {
        return new Long(get());
    }


    /*
     * unary operators
     */
    public Long unaryPlus() {
        return +get();
    }

    public Long unaryMinus() {
        return -get();
    }

    public Long inc() {
        return assign(unaryPlus());
    }

    public Long dec() {
        return assign(unaryMinus());
    }

    public Long plus(SGLInteger b) {
        return get() + b.get();
    }

    public Long plus(SGLLong b) {
        return get() + b.get();
    }

    public Float plus(SGLFloat b) {
        return get() + b.get();
    }

    public Double plus(SGLDouble b) {
        return get() + b.get();
    }

    public Long minus(SGLInteger b) {
        return get() - b.get();
    }

    public Long minus(SGLLong b) {
        return get() - b.get();
    }

    public Float minus(SGLFloat b) {
        return get() - b.get();
    }

    public Double minus(SGLDouble b) {
        return get() - b.get();
    }

    public Long times(SGLInteger b) {
        return get() * b.get();
    }

    public Long times(SGLLong b) {
        return get() * b.get();
    }

    public Float times(SGLFloat b) {
        return get() * b.get();
    }

    public Double times(SGLDouble b) {
        return get() * b.get();
    }

    public Long div(SGLInteger b) {
        return get() / b.get();
    }

    public Long div(SGLLong b) {
        return get() / b.get();
    }

    public Float div(SGLFloat b) {
        return get() / b.get();
    }

    public Double div(SGLDouble b) {
        return get() / b.get();
    }

    public Long mod(SGLInteger b) {
        return get() % b.get();
    }

    public Long mod(SGLLong b) {
        return get() % b.get();
    }

    public Float mod(SGLFloat b) {
        return get() % b.get();
    }

    public Double mod(SGLDouble b) {
        return get() % b.get();
    }


    public Integer compareTo(SGLInteger b) {
        return get().compareTo(b.toLong());
    }

    public Integer compareTo(SGLLong b) {
        return get().compareTo(b.toLong());
    }

    public Integer compareTo(SGLFloat b) {
        return get().compareTo(b.toLong());
    }

    public Integer compareTo(SGLDouble b) {
        return get().compareTo(b.toLong());
    }

    /*
     * binary assignment operators
     */


    public Long plusAssign(SGLInteger b) {
        return assign(plus(b));
    }

    public Long plusAssign(SGLLong b) {
        return assign(plus(b));
    }

    public Long plusAssign(SGLFloat b) {
        return assign(plus(b).longValue());
    }

    public Long plusAssign(SGLDouble b) {
        return assign(plus(b).longValue());
    }


    public Long minusAssign(SGLInteger b) {
        return assign(minus(b));
    }

    public Long minusAssign(SGLLong b) {
        return assign(minus(b));
    }

    public Long minusAssign(SGLFloat b) {
        return assign(minus(b).longValue());
    }

    public Long minusAssign(SGLDouble b) {
        return assign(minus(b).longValue());
    }


    public Long timesAssign(SGLInteger b) {
        return assign(times(b));
    }

    public Long timesAssign(SGLLong b) {
        return assign(times(b));
    }

    public Long timesAssign(SGLFloat b) {
        return assign(times(b).longValue());
    }

    public Long timesAssign(SGLDouble b) {
        return assign(times(b).longValue());
    }

    public Long divAssign(SGLInteger b) {
        return assign(div(b));
    }

    public Long divAssign(SGLLong b) {
        return assign(div(b));
    }

    public Long divAssign(SGLFloat b) {
        return assign(div(b).longValue());
    }

    public Long divAssign(SGLDouble b) {
        return assign(div(b).longValue());
    }

    public Long modAssign(SGLInteger b) {
        return assign(mod(b));
    }

    public Long modAssign(SGLLong b) {
        return assign(mod(b));
    }

    public Long modAssign(SGLFloat b) {
        return assign(mod(b).longValue());
    }

    public Long modAssign(SGLDouble b) {
        return assign(mod(b).longValue());
    }
}