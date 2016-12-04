package de.caffeineaddicted.sgl.utils;

import com.badlogic.gdx.assets.AssetManager;

/**
 * @author Malte Heinzelmann
 */
public abstract class Assets extends AssetManager {

    public abstract void setup();

    public abstract void preload();

    public abstract void load();
}
