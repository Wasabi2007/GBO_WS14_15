package gui.graphics;

import java.util.Vector;

import com.sun.javafx.geom.Vec2d;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bezier extends Application
{
    private static final int DIAMETER = 10;
    private static final int RADIUS = DIAMETER/2;
    
    private Canvas canvas;
    private Vector<Vec2d> points;
    private int selectedPoint = -1;

    public void start(Stage primaryStage)
    {
        canvas = new Canvas(600, 600);
        points = new Vector<>();
        points.add(new Vec2d(100, 100));
        points.add(new Vec2d(200, 70));
        points.add(new Vec2d(200, 200));
        points.add(new Vec2d(125, 200));
        drawShapes();

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent arg0) {
        		Vec2d vm = new Vec2d(arg0.getSceneX(), arg0.getSceneY());
        		for(int i = 0; i < points.size();i++){
                	Vec2d vp = points.get(i);
                	if(vp.distance(vm)< RADIUS){
                		selectedPoint = i;
                	}
                }    		
        	};
		});
        
        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent arg0) {
                		selectedPoint = -1;
        	};
		});
        
        
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent arg0) {
        		if(selectedPoint >= 0){
        			Vec2d vp = points.get(selectedPoint);
        			vp.x = arg0.getSceneX();
        			vp.y = arg0.getSceneY();	
        			drawShapes();
        		}
        	};
		});
        BorderPane root = new BorderPane();
        root.getChildren().add(canvas);
        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
    
    private void drawShapes()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        gc.setFill(Color.RED);
        for(Vec2d v : points){
        	gc.fillOval(v.x-RADIUS, v.y-RADIUS, DIAMETER, DIAMETER);
        }
        
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(points.get(0).x,points.get(0).y );
        gc.bezierCurveTo(points.get(1).x,points.get(1).y,points.get(2).x,points.get(2).y,points.get(3).x,points.get(3).y);
        //gc.closePath();
        gc.stroke();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
