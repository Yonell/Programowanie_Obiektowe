package agh.ics.oop;

public class World {
    private static void run(Direction[] args){
        System.out.println();
        for(Direction argument : args)
        {
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> "Nieznana komenda";
            };
            System.out.println(message);
        }
        System.out.println();
    }

    private static Direction[] switch_to_enum(String[] args){
        Direction[] args_enum = new Direction[args.length];
        for(int i=0; i<args.length; i+=1){
            args_enum[i] = switch(args[i]){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.OTHER;
            };
        }
        return args_enum;
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
        System.out.println();
        if(args.length == 0) {
            System.out.println("Zwierzak nie ma co robic, koncze dzialanie programu");
            System.exit(0);
        }
        for(int i=0; i<args.length-1; i+=1){
            System.out.print(args[i]);
            System.out.print(", ");
        }
        System.out.print(args[args.length-1]);
        Direction[] args_enum = switch_to_enum(args);
        run(args_enum);
        System.out.println("system zakończył działanie");
    }
}
