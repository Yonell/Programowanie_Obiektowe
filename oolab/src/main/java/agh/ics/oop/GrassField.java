package agh.ics.oop;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GrassField implements IWorldMap{

    private int grassCount;
    private List<Grass> grasses;


    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        int x, y;
        Vector2d position;
        Random r = new Random(785432636);
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
}
