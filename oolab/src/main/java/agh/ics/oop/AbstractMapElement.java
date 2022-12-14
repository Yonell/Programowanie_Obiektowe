package agh.ics.oop;

import java.util.Objects;

public abstract class AbstractMapElement implements IMapElement {
    protected Vector2d position;

    public Vector2d getPosition() {
        return position;
    }

    public boolean isAt(Vector2d pos){
        return Objects.equals(position, pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AbstractMapElement mapObject = (AbstractMapElement) o;
        return position.equals(mapObject.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, this instanceof Animal);
    }
}
