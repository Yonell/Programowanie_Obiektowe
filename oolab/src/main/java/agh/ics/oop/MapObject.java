package agh.ics.oop;

import java.util.Comparator;
import java.util.Objects;

public class MapObject{
    protected Vector2d position;

    static Comparator<MapObject> compareToByX = new Comparator<>() {
        @Override
        public int compare(MapObject o1, MapObject o2) {
            if (o1.getClass() != o2.getClass()) {
                return (o1 instanceof Animal) ? 1 : -1;
            }
            return Integer.compare(((MapObject) o1).position.x(), ((MapObject) o2).position.x());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

    static Comparator<MapObject> compareToByY = new Comparator<>() {
        @Override
        public int compare(MapObject o1, MapObject o2) {
            if (o1.getClass() != o2.getClass()) {
                return (o1 instanceof Animal) ? 1 : -1;
            }
            return Integer.compare(((MapObject) o1).position.y(), ((MapObject) o2).position.y());
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };

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
        MapObject mapObject = (MapObject) o;
        return position.equals(mapObject.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
