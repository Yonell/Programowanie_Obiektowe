package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class App extends Application implements IFrameChangeObserver {
    private AbstractWorldMap map;
    private IEngine engine;
    private Stage primaryStage;
    private final GridPane grid = new GridPane();
    private Scene scene;

    public App(){
        super();
    }

    @Override
    public void init() throws Exception {
        super.init();
        List<String> args = getParameters().getRaw();
        MoveDirection[] directions = new MoveDirection[0];
        try {
            directions = OptionsParser.parse(args.toArray(new String[0]));
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4), new Vector2d(2, 4), new Vector2d(1, 3), new Vector2d(-1, 2)};
            engine = new SimulationEngine(directions, map, positions);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            System.exit(-420);
        }
        scene = new Scene(grid, 700, 700);

        setUpGrid();
        addMapToOutput();
        setUpInterface();
        engine.addObserver(this);
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setUpGrid() {
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        for (int i = 0; i < map.upperRightBound().x() - map.lowerLeftBound().x() + 2; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (int i = 0; i < map.upperRightBound().y() - map.lowerLeftBound().y() + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(40));
        }
        grid.setAlignment(Pos.CENTER); //Uncomment to center the grid
    }

    private void addMapToOutput() {

        List<Node> nodes = new ArrayList<>();
        GuiElementBox box = null;

        nodes.add(new Label("y/x"));
        grid.add(nodes.get(0),0,0);
        for(int x = 0; x<=map.upperRightBound().x()-map.lowerLeftBound().x(); x++){
            nodes.add(new Label(Integer.toString(x + map.lowerLeftBound().x())));
            grid.add(nodes.get(nodes.size()-1),x+1, 0);
        }
        for(int y = 0; y<=map.upperRightBound().y()-map.lowerLeftBound().y(); y++){
            nodes.add(new Label(Integer.toString(map.upperRightBound().y() - y )));
            grid.add(nodes.get(nodes.size()-1),0, y+1);
        }
        for(int x = map.lowerLeftBound().x(); x<=map.upperRightBound().x(); x++){
            for(int y = map.upperRightBound().y(); y>=map.lowerLeftBound().y(); y--){
                if(map.objectAt(new Vector2d(x,y)) == null) {
                    nodes.add(new Label(" "));
                    grid.add(nodes.get(nodes.size()-1),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                }else{
                    try {
                        box = new GuiElementBox((IMapElement) map.objectAt(new Vector2d(x, y)));
                    }catch (FileNotFoundException e){
                        System.out.println("File not found");
                        return;
                    }
                    grid.add(box.getVBox(),
                            x - map.lowerLeftBound().x() + 1, map.upperRightBound().y() - y + 1);
                    nodes.add(box.getVBox());
                }
            }
        }
        for (Node i:
             nodes) {
            GridPane.setHalignment(i, HPos.CENTER);
            GridPane.setValignment(i, VPos.CENTER);
        }
    }

    private void setUpInterface(){
        TextField tf = new TextField();
        Button b = new Button("Update Directions");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine.setDirections(OptionsParser.parse(tf.getText().split(" ")));
                new Thread(engine).start();
            }
        });
        VBox directionsAdder = new VBox(tf, b);
        grid.add(directionsAdder, map.upperRightBound().x() - map.lowerLeftBound().x() + 4, (map.upperRightBound().y() + map.lowerLeftBound().y())/2);
    }


    @Override
    public void FrameChanged() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            grid.getRowConstraints().clear();
            grid.getColumnConstraints().clear();
            addMapToOutput();
            setUpGrid();
            setUpInterface();
            grid.setGridLinesVisible(true);
            primaryStage.show();
        });
    }
}