package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{

    private final List<IFrameChangeObserver> observers = new ArrayList<>();
    public List<Animal> animals;
    private IWorldMap map;

    private MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] placement){
        animals = new ArrayList<>();
        for (Vector2d vector2d : placement) {
            animals.add(new Animal(map, vector2d));
            map.place(animals.get(animals.size() - 1));
        }
        this.directions = directions;
        this.map = map;
    }

    public SimulationEngine(IWorldMap map, Vector2d[] placement){
        animals = new ArrayList<>();
        for (Vector2d vector2d : placement) {
            animals.add(new Animal(map, vector2d));
            map.place(animals.get(animals.size() - 1));
        }
        this.map = map;
    }

    private void notifyObservers(){
        for (IFrameChangeObserver i: observers) {
            i.FrameChanged();
        }
    }

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }

    public void addObserver(IFrameChangeObserver o){
        observers.add(o);
    }

    public List<Animal> yieldList(){
        return Collections.unmodifiableList(animals);
    }
    @Override
    public void run() {
        System.out.println(map);
        for(int i = 0; i < directions.length; i++){
            if(i % animals.size() == 0){
                notifyObservers();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    System.out.println("Simulation engine thread interrupted");
                }
            }
            animals.get(i % animals.size()).move(directions[i]);
            System.out.println(map);
        }
        notifyObservers();
    }
}
