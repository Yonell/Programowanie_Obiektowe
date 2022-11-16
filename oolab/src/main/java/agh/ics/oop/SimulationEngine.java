package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    public Animal[] animals;
    private IWorldMap map;
    private MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] placement){
        animals = new Animal[placement.length];
        for(int i=0; i<placement.length; i++){
            animals[i] = new Animal(map, placement[i]);
            map.place(animals[i]);
        }
        this.directions = directions;
        this.map = map;
    }
    @Override
    public void run() {
        System.out.println(map);
        for(int i = 0; i < directions.length; i++){
            animals[i % animals.length].move(directions[i]);
            System.out.println(map);
        }
    }
}
