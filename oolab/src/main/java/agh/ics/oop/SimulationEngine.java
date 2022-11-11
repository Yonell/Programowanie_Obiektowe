package agh.ics.oop;

public class SimulationEngine implements IEngine{

    IWorldMap map;
    MoveDirection[] directions;

    SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] placement){
        for(Vector2d i : placement){
            map.place(new Animal(map, i));
        }
        this.directions = directions;
        this.map = map;
    }
    @Override
    public void run() {
        System.out.println(map);
        for(int i = 0; i < directions.length; i++){
            map.moveAnimals(directions[i], i);
            System.out.println(map);
        }
    }
}
