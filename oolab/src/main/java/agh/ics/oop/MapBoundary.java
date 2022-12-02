package agh.ics.oop;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class MapBoundary implements IPositionChangeObserver{
    private Vector2d position;
    SortedSet<MapObject> objectsX = new TreeSet<>(MapObject.compareToByX);
    SortedSet<MapObject> objectsY = new TreeSet<>(MapObject.compareToByY);
}
