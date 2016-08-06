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

public class SGLFloat extends SGLNumber<Float> {
    public SGLFloat() {
        super();
    }

    public SGLFloat(Float data) {
        super(data);
    }

    public Float cloneData() {
        return new Float(get());
    }


    /*
     * unary operators
     */
    public Float unaryPlus() {
        return +get();
    }

    public Float unaryMinus() {
        return -get();
    }

    public Float inc() {
        return assign(unaryPlus());
    }

    public Float dec() {

        return assign(unaryMinus());
    }

    public Float plus(SGLInteger b) {
        return get() + b.get();
    }

    public Float plus(SGLLong b) {
        return get() + b.get();
    }

    public Float plus(SGLFloat b) {
        return get() + b.get();
    }


    public Double plus(SGLDouble b) {
        return get() + b.get();
    }

    public Float minus(SGLInteger b) {
        return get() - b.get();
    }


    public Float minus(SGLLong b) {
        return get() - b.get();
    }


    public Float minus(SGLFloat b) {
        return get() - b.get();
    }


    public Double minus(SGLDouble b) {
        return get() - b.get();
    }


    public Float times(SGLInteger b) {
        return get() * b.get();
    }


    public Float times(SGLLong b) {
        return get() * b.get();
    }

    public Float times(SGLFloat b) {
        return get() * b.get();
    }


    public Double times(SGLDouble b) {
        return get() * b.get();
    }


    public Float div(SGLInteger b) {
        return get() / b.get();
    }


    public Float div(SGLLong b) {
        return get() / b.get();
    }

    public Float div(SGLFloat b) {
        return get() / b.get();
    }

    public Double div(SGLDouble b) {
        return get() / b.get();
    }

    public Float mod(SGLInteger b) {
        return get() % b.get();
    }

    public Float mod(SGLLong b) {
        return get() % b.get();
    }

    public Float mod(SGLFloat b) {
        return get() % b.get();
    }

    public Double mod(SGLDouble b) {
        return get() % b.get();
    }


    public Integer compareTo(SGLInteger b) {
        return get().compareTo(b.toFloat());
    }

    public Integer compareTo(SGLLong b) {
        return get().compareTo(b.toFloat());
    }

    public Integer compareTo(SGLFloat b) {
        return get().compareTo(b.get());
    }

    public Integer compareTo(SGLDouble b) {
        return get().compareTo(b.toFloat());
    }

    /*
     * binary assignment operators
     */


    public Float plusAssign(SGLInteger b) {
        return assign(plus(b).floatValue());
    }

    public Float plusAssign(SGLLong b) {
        return assign(plus(b).floatValue());
    }

    public Float plusAssign(SGLFloat b) {
        return assign(plus(b).floatValue());
    }

    public Float plusAssign(SGLDouble b) {
        return assign(plus(b).floatValue());
    }


    public Float minusAssign(SGLInteger b) {
        return assign(minus(b).floatValue());
    }

    public Float minusAssign(SGLLong b) {
        return assign(minus(b).floatValue());
    }

    public Float minusAssign(SGLFloat b) {
        return assign(minus(b).floatValue());
    }

    public Float minusAssign(SGLDouble b) {
        return assign(minus(b).floatValue());
    }


    public Float timesAssign(SGLInteger b) {
        return assign(times(b).floatValue());
    }

    public Float timesAssign(SGLLong b) {
        return assign(times(b).floatValue());
    }

    public Float timesAssign(SGLFloat b) {
        return assign(times(b).floatValue());
    }

    public Float timesAssign(SGLDouble b) {
        return assign(times(b).floatValue());
    }

    public Float divAssign(SGLInteger b) {
        return assign(div(b)).floatValue();
    }

    public Float divAssign(SGLLong b) {
        return assign(div(b).floatValue());
    }

    public Float divAssign(SGLFloat b) {
        return assign(div(b).floatValue());
    }

    public Float divAssign(SGLDouble b) {
        return assign(div(b).floatValue());
    }

    public Float modAssign(SGLInteger b) {
        return assign(mod(b).floatValue());
    }

    public Float modAssign(SGLLong b) {
        return assign(mod(b).floatValue());
    }

    public Float modAssign(SGLFloat b) {
        return assign(mod(b).floatValue());
    }

    public Float modAssign(SGLDouble b) {
        return assign(mod(b).floatValue());
    }
}