package de.caffeineaddicted.sgl;

import com.badlogic.gdx.Files;

/**
 * @author Malte Heinzelmann
 */
public class AttributeList {
    public final static Attribute<Integer> WIDTH = new Attribute<Integer>(Integer.class, "width", 800);
    public final static Attribute<Integer> HEIGHT = new Attribute<Integer>(Integer.class, "height", 600);
    public final static Attribute<Boolean> RESIZABLE = new Attribute<Boolean>(Boolean.class, "resizable", true);
    public final static Attribute<Boolean> FULLSCREEN = new Attribute<Boolean>(Boolean.class, "fullscreen", false);
    public final static Attribute<String> ICON_PATH = new Attribute<String>(String.class, "icon_path", "");
    public final static Attribute<Files.FileType> ICON_TYPE = new Attribute<Files.FileType>(Files.FileType.class, "icon_type", Files.FileType.Internal);
}
