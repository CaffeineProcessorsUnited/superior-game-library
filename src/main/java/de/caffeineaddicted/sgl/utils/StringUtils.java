package de.caffeineaddicted.sgl.utils;

import com.badlogic.gdx.math.Vector2;
import de.caffeineaddicted.sgl.etities.Entity;

import java.util.Random;

public class StringUtils {

    public static boolean containsAny(String haystack, String... needles) {
        for (String needle: needles) {
            if (haystack.contains(needle)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAll(String haystack, String... needles) {
        for (String needle: needles) {
            if (!haystack.contains(needle)) {
                return false;
            }
        }
        return true;
    }
}
