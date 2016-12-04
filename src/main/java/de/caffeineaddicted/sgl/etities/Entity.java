package de.caffeineaddicted.sgl.etities;

import com.badlogic.gdx.graphics.Texture;
import de.caffeineaddicted.sgl.SGL;
import de.caffeineaddicted.sgl.utils.Assets;
import de.caffeineaddicted.sgl.utils.MathUtils;

import java.util.ArrayList;

abstract public class Entity extends Group {

    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    public Entity() {
        entities.add(this);
    }

    public static ArrayList<Entity> GetEntitiesInRect(float x1, float y1, float x2, float y2) {
        ArrayList<Entity> list = new ArrayList<Entity>();

        for (Entity entity : entities) {
            if (MathUtils.intersectRect(entity.getX(), entity.getY(),
                    entity.getX() + entity.getHeight(), entity.getY() + entity.getHeight(),
                    x1, y1, x2, y2)) {
                list.add(entity);
            }
        }
        return list;
    }

    public static ArrayList<Entity> getEntitiesInRange(float x, float y, float range) {
        ArrayList<Entity> list = new ArrayList<Entity>();
        for (Entity entity : entities) {
            if (MathUtils.intersectCircleRect(x, y, range,
                    entity.getX(), entity.getY(),
                    entity.getX() + entity.getHeight(), entity.getY() + entity.getHeight())) {
                list.add(entity);
            }
        }
        return list;
    }

    public void destroy() {
        entities.remove(this);
    }

    abstract public void update();

    public String addTexture(String texture) {
        return addTexture(texture, texture);
    }

    public String addTexture(String name, String texture) {
        return addTexture(name, SGL.provide(Assets.class).get(texture, Texture.class));
    }

    public String addTexture(String name, Texture texture) {
        return addActor(name, new Image(texture));
    }


}
