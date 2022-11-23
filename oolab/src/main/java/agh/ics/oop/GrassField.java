package agh.ics.oop;

import java.util.*;

import static java.lang.Integer.*;

public class GrassField extends AbstractWorldMap{
    private List<Grass> grasses = new ArrayList<>();

    private List<Grass> nDistinctRandomGrasses(int n){
        Random r = new Random(78543266);
        Set<Vector2d> vectors = new HashSet<>();
        while(vectors.size() != n){
            vectors.add(new Vector2d(r.nextInt(0, (int) Math.sqrt(10*n)),  r.nextInt(0, (int) Math.sqrt(10*n))));
        }

        return vectors.stream()
                .map(Grass::new)
                .toList();

    }


    public GrassField(int grassCount) {
        grasses = nDistinctRandomGrasses(grassCount);
    }


    @Override
    public boolean canMoveTo(Vector2d dest){
        return !(objectAt(dest) instanceof Animal);
    }


    @Override
    public Object objectAt(Vector2d position) {
        if(animals.containsKey(position)){
            return animals.get(position);
        }
        for(Grass i : grasses){
            if(i.isAt(position)){
                return i;
            }
        }
        return null;


/*        try {
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
        } // czasem streamy się nie opłacają */
    }

    public Vector2d lowerLeftBound(){
        Vector2d minimum = new Vector2d(MAX_VALUE, MAX_VALUE);

        for(Grass i : grasses){
            minimum = minimum.lowerLeft(i.getPosition());
        }

        for(Map.Entry<Vector2d, Animal> i : animals.entrySet()){
            minimum = minimum.lowerLeft(i.getValue().getPosition());
        }

        return minimum;
    }

    public Vector2d upperRightBound(){
        Vector2d maximum = new Vector2d(MIN_VALUE, MIN_VALUE);

        for(Grass i : grasses){
            maximum = maximum.upperRight(i.getPosition());
        }

        for(Map.Entry<Vector2d, Animal> i : animals.entrySet()){
            maximum = maximum.upperRight(i.getValue().getPosition());
        }

        return maximum;
    }
}
