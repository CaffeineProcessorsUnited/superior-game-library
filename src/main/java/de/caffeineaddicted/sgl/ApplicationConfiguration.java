package de.caffeineaddicted.sgl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */
public class ApplicationConfiguration {
    protected final Map<Attribute, Object> attributes = new HashMap<Attribute, Object>();

    public ApplicationConfiguration() {
    }

    public ApplicationConfiguration(ApplicationConfiguration configuration) {
        for (Attribute<?> a : configuration.attributes.keySet()) {
            attributes.put(a, configuration.get(a));
        }
    }

    public <T> T get(Attribute<T> attribute) {
        if (attributes.containsKey(attribute)) {
            return attribute.type.cast(attributes.get(attribute));
        }
        return attribute.defaultValue;
    }

    public <T> ApplicationConfiguration set(Attribute<T> attribute, T value) {
        attributes.put(attribute, value);
        return this;
    }
}
