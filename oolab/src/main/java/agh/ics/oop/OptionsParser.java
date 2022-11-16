package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        return Arrays.stream(args)
                .map(arg -> {
                    return switch (arg){
                        case "f", "forward" -> MoveDirection.FORWARD;
                        case "b", "backward" -> MoveDirection.BACKWARD;
                        case "l", "left" -> MoveDirection.LEFT;
                        case "r", "right" -> MoveDirection.RIGHT;
                        default -> null;
                    };
                })
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }
}
