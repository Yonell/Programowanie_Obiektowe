package agh.ics.oop;

import java.util.*;

import static java.lang.Integer.*;

public class GrassField implements IWorldMap{

    private List<Animal> animals = new ArrayList<>();
    private int grassCount;
    private List<Grass> grasses = new ArrayList<>();


    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        int x, y;
        Vector2d position;
        Random r = new Random(78543266);
        boolean found;
        for(int i=0; i<grassCount; i++)
        {
            while(true){
                position = new Vector2d(r.nextInt(0, (int) Math.sqrt(10*grassCount)),  r.nextInt(0, (int) Math.sqrt(10*grassCount)));
                found = false;
                for (Grass j : grasses) {
                    if (Objects.equals(j.getPosition(), position)) {
                        found = true;
                        break;
                    }
                }
                if(found) {
                    continue;
                } else {
                    break;
                }
            }
            grasses.add(new Grass(position));
        }
    }


    @Override
    public boolean canMoveTo(Vector2d dest){
        return !this.isOccupied(dest);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position) != null);
    }


    @Override
    public Object objectAt(Vector2d position) {
        try {
            return Objects.requireNonNullElse(
                animals.stream()
                        .filter(i -> i.isAt(position))
                        .findFirst()
                        .orElse(null),
                grasses.stream()
                        .filter(i -> Objects.equals(i.getPosition(), position))
                        .findFirst()
                        .orElse(null)
                );
        }
        catch(Exception e){
            return null;
        } //Do zmiany XD
    }

    @Override
    public boolean place(Animal animal){
        if(!canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public String toString(){
        Vector2d maximum = new Vector2d(MIN_VALUE, MIN_VALUE);
        Vector2d minimum = new Vector2d(MAX_VALUE, MAX_VALUE);

        for(Grass i : grasses){
            maximum = maximum.upperRight(i.getPosition());
            minimum = minimum.lowerLeft(i.getPosition());
        }

        for(Animal i : animals){
            maximum = maximum.upperRight(i.getPosition());
            minimum = minimum.lowerLeft(i.getPosition());
        }


        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(minimum, maximum);
    }
}
