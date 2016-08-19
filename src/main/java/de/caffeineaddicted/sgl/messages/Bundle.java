/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl.messages;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */


public class Bundle {

    private Map<String, Object> context;

    public Bundle() {
        this(null);
    }

    public Bundle(Bundle bundle) {
        this.context = new HashMap<String, Object>();
        if (bundle != null) {
            this.context.putAll(bundle.getAll());
        }
    }

    public Bundle put(String key, Object value) {
        context.put(key, value);
        return this;
    }

    public Object get(String key) {
        return context.get(key);
    }

    public Object get(String key, Object defaultValue) {
        Object value = context.get(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }

    public <T> T get(String key, Class<T> type) {
        return (T) get(key);
    }

    public <T> T get(String key, Class<T> type, T defaultValue) {
        T value = (T) get(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }

    public Map<String, Object> getAll() {
        return context;
    }

    public boolean hasKey(String key) {
        return context.containsKey(key);
    }
}