package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SimulationEngineTest {
    @Test
    public void testTheEngine(){
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Animal> animals = engine.yieldList();
        assertEquals(new Vector2d(2, -1), animals.get(0).getPosition());
        assertEquals(MapDirection.SOUTH, animals.get(0).getOrientation());
        assertEquals(new Vector2d(3, 7), animals.get(1).getPosition());
        assertEquals(MapDirection.NORTH, animals.get(1).getOrientation());
    }
}
