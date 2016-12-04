package de.caffeineaddicted.sgl.interfaces;

/**
 * @author Malte Heinzelmann
 */
public interface Provider {

    <T> boolean provides(Class<T> key);

    <T> T provide(Class<T> key);

}
