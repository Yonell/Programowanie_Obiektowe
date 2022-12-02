package agh.ics.oop;

import java.util.*;

import static java.lang.Integer.*;

public class GrassField extends AbstractWorldMap{
    private Map<Vector2d, Grass> grasses = new HashMap<>();

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
        for (Vector2d pos : vectors) {
            grasses.put(pos, new Grass(pos));
        }
        return grasses;

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
        Vector2d minimum = new Vector2d(MAX_VALUE, MAX_VALUE);

        for(Vector2d i : grasses.keySet()){
            minimum = minimum.lowerLeft(i);
        }

        for(Vector2d i : animals.keySet()){
            minimum = minimum.lowerLeft(i);
        }

        return minimum;
    }

    public Vector2d upperRightBound(){
        Vector2d maximum = new Vector2d(MIN_VALUE, MIN_VALUE);

        for(Vector2d i : grasses.keySet()){
            maximum = maximum.upperRight(i);
        }

        for(Vector2d i : animals.keySet()){
            maximum = maximum.upperRight(i);
        }

        return maximum;
    }
}
