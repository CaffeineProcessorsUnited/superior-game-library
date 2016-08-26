package de.caffeineaddicted.sgl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */
public class Attribute<T> {

    public final Class<T> type;
    public final String name;
    public final T defaultValue;

    public Attribute(Class<T> type, String name, T defaultValue) {
        this.type = type;
        this.name = name;
        this.defaultValue = defaultValue;
    }
}
