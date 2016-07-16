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

public class SGLDouble extends SGLNumber<Double> {

    public SGLDouble() {
        super();
    }

    public SGLDouble(Double data) {
        super(data);
    }

    public Double cloneData() {
        return new Double(get());
    }

    /*
     * unary operators
     */
    public Double unaryPlus() {
        return +get();
    }

    public Double unaryMinus() {
        return -get();
    }

    public Double inc() {
        return assign(unaryPlus());
    }

    public Double dec() {
        return assign(unaryMinus());
    }

    public Double plus(SGLInteger b) {
        return get() + b.get();
    }

    public Double plus(SGLLong b) {
        return get() + b.get();
    }

    public Double plus(SGLFloat b) {
        return get() + b.get();
    }

    public Double plus(SGLDouble b) {
        return get() + b.get();
    }

    public Double minus(SGLInteger b) {
        return get() - b.get();
    }

    public Double minus(SGLLong b) {
        return get() - b.get();
    }

    public Double minus(SGLFloat b) {
        return get() - b.get();
    }

    public Double minus(SGLDouble b) {
        return get() - b.get();
    }

    public Double times(SGLInteger b) {
        return get() * b.get();
    }

    public Double times(SGLLong b) {
        return get() * b.get();
    }

    public Double times(SGLFloat b) {
        return get() * b.get();
    }

    public Double times(SGLDouble b) {
        return get() * b.get();
    }

    public Double div(SGLInteger b) {
        return get() / b.get();
    }


    public Double div(SGLLong b) {
        return get() / b.get();
    }

    public Double div(SGLFloat b) {
        return get() / b.get();
    }

    public Double div(SGLDouble b) {
        return get() / b.get();
    }

    public Double mod(SGLInteger b) {
        return get() % b.get();
    }

    public Double mod(SGLLong b) {
        return get() % b.get();
    }

    public Double mod(SGLFloat b) {
        return get() % b.get();
    }

    public Double mod(SGLDouble b) {
        return get() % b.get();
    }

    public Integer compareTo(SGLInteger b) {
        return get().compareTo(b.toDouble());
    }

    public Integer compareTo(SGLLong b) {
        return get().compareTo(b.toDouble());
    }

    public Integer compareTo(SGLFloat b) {
        return get().compareTo(b.toDouble());
    }

    public Integer compareTo(SGLDouble b) {
        return get().compareTo(b.get());
    }

    /*
     * binary assignment operators
     */


    public Double plusAssign(SGLInteger b) {
        return assign(plus(b));
    }

    public Double plusAssign(SGLLong b) {
        return assign(plus(b));
    }

    public Double plusAssign(SGLFloat b) {
        return assign(plus(b));
    }

    public Double plusAssign(SGLDouble b) {
        return assign(plus(b));
    }


    public Double minusAssign(SGLInteger b) {
        return assign(minus(b));
    }

    public Double minusAssign(SGLLong b) {
        return assign(minus(b));
    }

    public Double minusAssign(SGLFloat b) {
        return assign(minus(b));
    }

    public Double minusAssign(SGLDouble b) {
        return assign(minus(b));
    }


    public Double timesAssign(SGLInteger b) {
        return assign(times(b));
    }

    public Double timesAssign(SGLLong b) {
        return assign(times(b));
    }

    public Double timesAssign(SGLFloat b) {
        return assign(times(b));
    }

    public Double timesAssign(SGLDouble b) {
        return assign(times(b));
    }

    public Double divAssign(SGLInteger b) {
        return assign(div(b));
    }

    public Double divAssign(SGLLong b) {
        return assign(div(b));
    }

    public Double divAssign(SGLFloat b) {
        return assign(div(b));
    }

    public Double divAssign(SGLDouble b) {
        return assign(div(b));
    }

    public Double modAssign(SGLInteger b) {
        return assign(mod(b));
    }

    public Double modAssign(SGLLong b) {
        return assign(mod(b));
    }

    public Double modAssign(SGLFloat b) {
        return assign(mod(b));
    }

    public Double modAssign(SGLDouble b) {
        return assign(mod(b));
    }
}