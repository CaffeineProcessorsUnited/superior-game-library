package de.caffeineaddicted.sgl.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.GdxRuntimeException;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.impl.exceptions.AssetNotLoadedException;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLAssets extends AssetManager {

    private boolean setup = false;
    private boolean preloaded = false;
    private boolean loaded = false;

    @Override
    public final synchronized <T> T get (String fileName) {
        if (!isPreloaded()) {
            preload();
            finishLoading();
        }
        try {
            return super.get(fileName);
        } catch (GdxRuntimeException gdxre) {
            throw new AssetNotLoadedException(fileName);
        }
    }

    @Override
    public final synchronized <T> T get (String fileName, Class<T> type) {
        if (!isPreloaded()) {
            preload();
            finishLoading();
        }
        try {
            return super.get(fileName, type);
        } catch (GdxRuntimeException gdxre) {
            throw new AssetNotLoadedException(fileName);
        }
    }

    @Override
    public final synchronized <T> T get (AssetDescriptor<T> assetDescriptor) {
        if (!isPreloaded()) {
            preload();
            finishLoading();
        }
        try {
            return super.get(assetDescriptor);
        } catch (GdxRuntimeException gdxre) {
            throw new AssetNotLoadedException(assetDescriptor.fileName);
        }
    }

    public final void setup() {
        SGL.debug("Setting asset loader up...");
        onSetup();
        setup = true;
    }

    public final boolean isSetup() {
        return setup;
    }

    public abstract void onSetup();

    public final void preload() {
        if (!isSetup()) {
            setup();
        }
        SGL.debug("Preloading assets...");
        onPreload();
        preloaded = true;
    }

    public final boolean isPreloaded() {
        return preloaded;
    }

    public abstract void onPreload();

    public final void load() {
        if (!isSetup()) {
            setup();
        }
        SGL.debug("Loading assets...");
        onLoad();
        loaded = true;
    }

    public final boolean isLoaded() {
        return loaded;
    }

    public abstract void onLoad();
}
