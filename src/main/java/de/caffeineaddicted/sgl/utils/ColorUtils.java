package de.caffeineaddicted.sgl.utils;

import com.badlogic.gdx.graphics.Color;

/**
 * @author Malte Heinzelmann
 */
public class ColorUtils {

    public static Color fromRGB(int r, int g, int b) {
        return new Color(r / 255.0f, g / 255.0f, b / 255.0f, 1);
    }

    public static Color fromRGBA(int r, int g, int b, int a) {
        return new Color(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f);
    }
}
