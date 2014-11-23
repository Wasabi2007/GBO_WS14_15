package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.scene.layout.*;

public class Layering extends Application
{
    private static final int DIAMETER = 40;
    private static final int RADIUS = DIAMETER/2;

    private BorderPane borderPane;
    private Canvas layer1;
    private Canvas layer2;
    private GraphicsContext gc1;
    private GraphicsContext gc2;
    private ChoiceBox<String> cb;

    private void createLayers()
    {
        layer1 = new Canvas(300, 250);
        layer2 = new Canvas(300, 250);

        gc1 = layer1.getGraphicsContext2D();
        gc1.setFill(Color.GREEN);
        gc1.fillOval(50, 50, DIAMETER, DIAMETER);
        gc2 = layer2.getGraphicsContext2D();
        gc2.setFill(Color.RED);
        gc2.fillOval(100, 100, DIAMETER, DIAMETER);
    }

    private void addMouseListeners()
    {
        layer1.setOnMousePressed
        (
            e -> gc1.fillOval(e.getX()-RADIUS, e.getY()-RADIUS,
                              DIAMETER, DIAMETER)
        );

        layer2.setOnMousePressed
        (
            e -> gc2.fillOval(e.getX()-RADIUS, e.getY()-RADIUS,
                              DIAMETER, DIAMETER)
        );
    }

    private void createChoiceBox()
    {
        cb = new ChoiceBox<>();
        cb.setItems(FXCollections.observableArrayList("Schicht 1", "Schicht 2"));
        cb.getSelectionModel().selectedItemProperty().addListener
        (
            (o, oldValue, newValue) ->
            {
                if(newValue.toString().equals("Schicht 1"))
                {
                    layer1.toFront();
                }
                else if(newValue.toString().equals("Schicht 2"))
                {
                    layer2.toFront();
                }
            }
        );
        cb.setValue("Schicht 1");
    }

    public void start(Stage primaryStage)
    {
        createLayers();
        addMouseListeners();
        createChoiceBox();

        borderPane = new BorderPane(); 
        borderPane.setTop(cb);
        Pane pane = new Pane();
        pane.getChildren().add(layer1);
        pane.getChildren().add(layer2);
        layer1.toFront();
        borderPane.setCenter(pane);

        primaryStage.setTitle("Zwei Schichten");
        primaryStage.setScene(new Scene(borderPane, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
