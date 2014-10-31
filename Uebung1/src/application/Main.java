package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;


public class Main extends Application {
	
	private int counter = 0;
	@FXML
	private Label number;
	
	private String[] hexvalues = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	private StringBuilder sb;
	@FXML
	private Random r;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root =  FXMLLoader.load(getClass().getResource("plusminus.fxml")); 
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			sb = new StringBuilder();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	private void increaseCounter(){
		counter++;
		updateNumber();
	}
	@FXML
	private void decreaseCounter(){
		counter--;
		updateNumber();
	}
	
	private void updateNumber(){
		sb = new StringBuilder();
		r = new Random();
		number.setText(String.valueOf(counter));		
		sb.append("#");
		//R
		sb.append(hexvalues[r.nextInt(16)]);
		sb.append(hexvalues[r.nextInt(16)]);
		//G
		sb.append(hexvalues[r.nextInt(16)]);
		sb.append(hexvalues[r.nextInt(16)]);
		//B
		sb.append(hexvalues[r.nextInt(16)]);
		sb.append(hexvalues[r.nextInt(16)]);
		
		number.setTextFill(Paint.valueOf(sb.toString()));
		//number.setStyle();
	}
}
