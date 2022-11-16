package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private List<Animal> animals = new ArrayList<>();
    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static Vector2d upper_bound; /* upper bound inclusive */

    public RectangularMap(int width, int height){
        upper_bound = new Vector2d(width-1, height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d dest){
        return !this.isOccupied(dest) && LOWER_BOUND.precedes(dest) && upper_bound.follows(dest);
    }

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
    public Object objectAt(Vector2d position) {
        return animals.stream()
                .filter(i -> i.isAt(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(LOWER_BOUND, upper_bound);
    }
}
