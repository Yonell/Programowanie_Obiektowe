package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationEngine implements IEngine{

    public List<Animal> animals;
    private IWorldMap map;
    private MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] placement){
        animals = new ArrayList<>();
        for(int i=0; i<placement.length; i++){
            animals.add(new Animal(map, placement[i]));
            map.place(animals.get(animals.size()-1));
        }
        this.directions = directions;
        this.map = map;
    }

    public List<Animal> yieldList(){
        return Collections.unmodifiableList(animals);
    }
    @Override
    public void run() {
        System.out.println(map);
        for(int i = 0; i < directions.length; i++){
            animals.get(i % animals.size()).move(directions[i]);
            System.out.println(map);
        }
    }
}
