/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.impl.exceptions;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import de.caffeineaddicted.sgl.exceptions.SGLException;

/**
 * @author Malte Heinzelmann
 */
public class ProvidedObjectClassMismatchException extends SGLException {
    public ProvidedObjectClassMismatchException(Class c, Object o) {
        super("The provider provided an object of type " + ClassReflection.getSimpleName(o.getClass()) + " while the was suggested type " + ClassReflection.getSimpleName(c) + "!");
    }
}