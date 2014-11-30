package gui.charts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartSample extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PieChartSample.fxml"));
			
			VBox pane = loader.load();
			
			PieChartSampleController cont = loader.getController();
			cont.init();
			
			Scene scene = new Scene(pane);
			arg0.setScene(scene);
			arg0.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
