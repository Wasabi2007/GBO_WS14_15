package gui.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class BezierDeLuxe extends Application
{
    private Canvas canvas;

    public void start(Stage primaryStage)
    {
        canvas = new Canvas(600, 600);
        drawShapes();

        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
    
    private void drawShapes()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
                
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(100, 100);
        gc.bezierCurveTo(200, 70, 200, 200, 
                         125, 200);
        gc.closePath();
        gc.stroke();
        
        drawRadialGradient(gc, Color.BLUE, Color.YELLOW);
        drawLinearGradient(gc, Color.RED, Color.GREEN);
        drawDropShadow(gc, Color.GRAY, Color.GREEN, Color.BLUE, Color.RED);
    }
    
    private void drawRadialGradient(GraphicsContext gc,
                                    Color firstColor, 
                                    Color lastColor) 
    {
        gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
                                      CycleMethod.REFLECT,
                                      new Stop(0.0, firstColor),
                                      new Stop(1.0, lastColor)));
        gc.fill();
    }
    
    private void drawLinearGradient(GraphicsContext gc,
                                    Color firstColor, 
                                    Color secondColor) 
    {
        LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                                               CycleMethod.REFLECT,
                                               new Stop(0.0, firstColor),
                                               new Stop(1.0, secondColor));
        gc.setStroke(lg);
        gc.setLineWidth(20);
        gc.stroke();
    }
    
    private void drawDropShadow(GraphicsContext gc,
                                Color firstColor, 
                                Color secondColor,
                                Color thirdColor, 
                                Color fourthColor)
    {
        gc.applyEffect(new DropShadow(20, 20, 0, firstColor));
        gc.applyEffect(new DropShadow(20, 0, 20, secondColor));
        gc.applyEffect(new DropShadow(20, -20, 0, thirdColor));
        gc.applyEffect(new DropShadow(20, 0, -20, fourthColor));
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
