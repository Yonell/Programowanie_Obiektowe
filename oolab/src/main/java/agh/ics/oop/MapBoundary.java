package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private Vector2d position;
    private final Map<Vector2d, classTypeAndPositionTuple> objects = new HashMap<>();
    private final SortedSet<classTypeAndPositionTuple> objectsX = new TreeSet<>(classTypeAndPositionTuple.compareToByX);
    private final SortedSet<classTypeAndPositionTuple> objectsY = new TreeSet<>(classTypeAndPositionTuple.compareToByY);

    public MapBoundary(){
        return;
    }

    public void place(MapObject object){
        objects.put(object.position, new classTypeAndPositionTuple(object.position, object.getClass()));
        objectsX.add(new classTypeAndPositionTuple(object.position, object.getClass()));
        objectsY.add(new classTypeAndPositionTuple(object.position, object.getClass()));
        if(object instanceof Animal){
            ((Animal) object).addObserver(this);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objectsX.remove(objects.get(oldPosition));
        objectsX.add(new classTypeAndPositionTuple(newPosition, objects.get(oldPosition).classType()));
        objectsY.remove(objects.get(oldPosition));
        objectsY.add(new classTypeAndPositionTuple(newPosition, objects.get(oldPosition).classType()));
        objects.put(newPosition, new classTypeAndPositionTuple(newPosition, objects.remove(oldPosition).classType()));
    }
    public Vector2d lowerLeftBound(){
        return new Vector2d(objectsX.first().position().x(), objectsY.first().position().y());
    }
    public Vector2d upperRightBound(){
        return new Vector2d(objectsX.last().position().x(), objectsY.last().position().y());
    }
}
