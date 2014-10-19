package application;
	
import gui.intro.Computation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	@FXML
	TextField outputField;
	
	Computation comp;
	
	
	
	public Main() {
		super();
		comp = new Computation();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("TaschenrechnerView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Taschenrechner");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	private void clearField(ActionEvent e){
		outputField.setText("");
	}
	
	@FXML
	private void deleteChar(ActionEvent e){
		if(outputField.getText().length()>0)
			outputField.setText(outputField.getText().substring(0,outputField.getText().length()-1));
	}
	
	@FXML
	private void addChar(ActionEvent e){
		if(e.getSource() instanceof Button){
			Button b = (Button)e.getSource();
			outputField.setText(outputField.getText().concat(b.getText()));
		}
	}
	
	
	@FXML
	private void eval(ActionEvent e){
		String erg = "=";
		
		try{
			erg += comp.evaluate(outputField.getText());
		} catch (Exception exp){
			erg = "ERROR";
		}
		
		outputField.setText(outputField.getText().concat(erg));
	}
	
	
}
