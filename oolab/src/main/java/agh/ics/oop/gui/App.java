package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class App extends Application {
    private AbstractWorldMap map;

    public void start(Stage primaryStage) {
        List<String> args = getParameters().getRaw();
        MoveDirection[] directions = new MoveDirection[0];
        IEngine engine = null;
        try {
            directions = OptionsParser.parse(args.toArray(new String[0]));
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println(e);
                System.exit(-420);
            }
        }

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        grid.setGridLinesVisible(true);

        addMapToOutput(grid);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        for (int i = 0; i < map.upperRightBound().x() - map.lowerLeftBound().x() + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(15));
        }
        for (int i = 0; i < map.upperRightBound().y() - map.lowerLeftBound().y() + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(15));
        }
        //grid.setAlignment(Pos.CENTER); //Uncomment to center the grid

        primaryStage.show();
    }

    private void addMapToOutput(GridPane grid) {

        List<Label> labels = new ArrayList<>();

        labels.add(new Label("y/x"));
        grid.add(labels.get(0),0,0);
        for(int x = 0; x<=map.upperRightBound().x()-map.lowerLeftBound().x(); x++){
            labels.add(new Label(Integer.toString(x + map.lowerLeftBound().x())));
            grid.add(labels.get(labels.size()-1),x+1, 0);
        }
        for(int y = 0; y<=map.upperRightBound().y()-map.lowerLeftBound().y(); y++){
            labels.add(new Label(Integer.toString(map.upperRightBound().y() - y )));
            grid.add(labels.get(labels.size()-1),0, y+1);
        }
        for(int x = map.lowerLeftBound().x(); x<=map.upperRightBound().x(); x++){
            for(int y = map.upperRightBound().y(); y>=map.lowerLeftBound().y(); y--){
                if(map.objectAt(new Vector2d(x,y)) == null) {
                    labels.add(new Label(" "));
                    grid.add(labels.get(labels.size()-1),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                }else{
                    labels.add(new Label(map.objectAt(new Vector2d(x, y)).toString()));
                    grid.add(labels.get(labels.size()-1),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                }
            }
        }
        for (Label i:
             labels) {
            GridPane.setHalignment(i, HPos.CENTER);
            GridPane.setValignment(i, VPos.CENTER);
        }
    }


}