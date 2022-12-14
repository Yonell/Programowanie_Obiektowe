package agh.ics.oop;

import java.util.*;

import static java.lang.Integer.*;

public class GrassField extends AbstractWorldMap{
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    MapBoundary boundaryCalculator = new MapBoundary();

    public GrassField(int grassCount) {
        grasses = nDistinctRandomGrasses(grassCount);
    }

    private Map<Vector2d, Grass> nDistinctRandomGrasses(int n){
        Random r = new Random(78543266);
        Set<Vector2d> vectors = new HashSet<>();
        while(vectors.size() != n){
            vectors.add(new Vector2d(r.nextInt(0, (int) Math.sqrt(10*n)),  r.nextInt(0, (int) Math.sqrt(10*n))));
        }
        Map<Vector2d, Grass> grasses = new HashMap<>();
        Grass grass;
        for (Vector2d pos : vectors) {
            grass = new Grass(pos);
            grasses.put(pos, grass);
            boundaryCalculator.place(grass);
        }
        return grasses;

    }

    @Override
    public boolean place(Animal animal){
        super.place(animal);
        boundaryCalculator.place(animal);
        animal.addObserver(boundaryCalculator);
        return true;
    }


    @Override
    public boolean canMoveTo(Vector2d dest){
        return !(objectAt(dest) instanceof Animal);
    }


    @Override
    public Object objectAt(Vector2d position) {
        if(animals.get(position) != null)
            return animals.get(position);
        return grasses.get(position);
    }

    public Vector2d lowerLeftBound(){
        return boundaryCalculator.lowerLeftBound();
    }

    public Vector2d upperRightBound(){
        return boundaryCalculator.upperRightBound();
    }
}
