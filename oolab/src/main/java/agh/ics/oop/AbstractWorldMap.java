package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{

    protected List<Animal> animals = new ArrayList<>();

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position) != null);
    }

    @Override
    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftBound(), upperRightBound());
    }

    protected abstract Vector2d upperRightBound();

    protected abstract Vector2d lowerLeftBound();
}
