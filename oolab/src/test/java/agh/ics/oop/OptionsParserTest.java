package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void parserTest(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->{
            parse(new String[]{"f", "b", "l", "r", "dsgsvcz", "", "forward", "backward", "left", "right", "b"});
        });
        assertEquals(new IllegalArgumentException("dsgsvcz is not legal move specification").toString(), e.toString());
        assertArrayEquals(new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,
                MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.LEFT,MoveDirection.RIGHT},
                parse(new String[]{"f", "b", "l", "r", "forward", "backward", "left", "right"}));
    }
}