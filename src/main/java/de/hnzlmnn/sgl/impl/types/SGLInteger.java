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

public class SGLInteger extends SGLNumber<Integer> {
    public SGLInteger() {
        super();

    }

    public SGLInteger(Integer data) {
        super(data);
    }

    public Integer cloneData() {
        return new Integer(get());
    }


    /*
     * unary operators
     */
    public Integer unaryPlus() {
        return +get();
    }

    public Integer unaryMinus() {
        return -get();
    }

    public Integer inc() {
        return assign(unaryPlus());
    }

    public Integer dec() {
        return assign(unaryMinus());
    }

    public Integer plus(SGLInteger b) {
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

    public Integer minus(SGLInteger b) {
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

    public Integer times(SGLInteger b) {
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

    public Integer div(SGLInteger b) {
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

    public Integer mod(SGLInteger b) {
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
        return get().compareTo(b.get());
    }

    public Integer compareTo(SGLLong b) {
        return get().compareTo(b.toInteger());
    }

    public Integer compareTo(SGLFloat b) {
        return get().compareTo(b.toInteger());
    }

    public Integer compareTo(SGLDouble b) {
        return get().compareTo(b.toInteger());
    }

    /*
     * binary assignment operators
     */


    public Integer plusAssign(SGLInteger b) {
        return assign(plus(b));
    }

    public Integer plusAssign(SGLLong b) {
        return assign(plus(b).intValue());
    }

    public Integer plusAssign(SGLFloat b) {
        return assign(plus(b).intValue());
    }

    public Integer plusAssign(SGLDouble b) {
        return assign(plus(b).intValue());
    }


    public Integer minusAssign(SGLInteger b) {
        return assign(minus(b));
    }

    public Integer minusAssign(SGLLong b) {
        return assign(minus(b).intValue());
    }

    public Integer minusAssign(SGLFloat b) {
        return assign(minus(b).intValue());
    }

    public Integer minusAssign(SGLDouble b) {
        return assign(minus(b).intValue());
    }


    public Integer timesAssign(SGLInteger b) {
        return assign(times(b));
    }

    public Integer timesAssign(SGLLong b) {
        return assign(times(b).intValue());
    }

    public Integer timesAssign(SGLFloat b) {
        return assign(times(b).intValue());
    }

    public Integer timesAssign(SGLDouble b) {
        return assign(times(b).intValue());
    }

    public Integer divAssign(SGLInteger b) {
        return assign(div(b));
    }

    public Integer divAssign(SGLLong b) {
        return assign(div(b).intValue());
    }

    public Integer divAssign(SGLFloat b) {
        return assign(div(b).intValue());
    }

    public Integer divAssign(SGLDouble b) {
        return assign(div(b).intValue());
    }

    public Integer modAssign(SGLInteger b) {
        return assign(mod(b));
    }

    public Integer modAssign(SGLLong b) {
        return assign(mod(b).intValue());
    }

    public Integer modAssign(SGLFloat b) {
        return assign(mod(b).intValue());
    }

    public Integer modAssign(SGLDouble b) {
        return assign(mod(b).intValue());
    }
}