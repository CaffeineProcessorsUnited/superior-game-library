package de.caffeineaddicted.sgl;

/**
 * @author Malte Heinzelmann
 */
public class AttributeList {
    public final static Attribute WIDTH = new Attribute<Integer>(Integer.class, "width", 800);
    public final static Attribute HEIGHT = new Attribute<Integer>(Integer.class, "height", 600);
    public final static Attribute RESIZABLE = new Attribute<Boolean>(Boolean.class, "resizable", true);
}
