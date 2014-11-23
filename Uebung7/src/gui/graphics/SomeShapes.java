package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SomeShapes extends Application
{
    public void start(Stage primaryStage)
    {
        Canvas canvas = new Canvas(400, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Einige Formen");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc)
    {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.RED);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 40, 40);
        gc.strokeOval(60, 60, 40, 40);
        gc.fillRoundRect(110, 60, 40, 40, 10, 10);
        gc.strokeRoundRect(160, 60, 40, 40, 10, 10);
        
        gc.setLineWidth(10);
        gc.fillRoundRect(210, 60, 40, 40, 10, 10);
        gc.strokeRoundRect(210, 60, 40, 40, 10, 10);
        gc.strokeRoundRect(265, 60, 40, 40, 10, 10);
        gc.fillRoundRect(265, 60, 40, 40, 10, 10);
        gc.setLineWidth(5);

        gc.fillArc(10, 110, 40, 40, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 40, 40, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 40, 40, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 40, 40, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 40, 40, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 40, 40, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
