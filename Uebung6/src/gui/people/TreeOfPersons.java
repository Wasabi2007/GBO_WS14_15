package gui.people;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TreeOfPersons extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        // System.out.println(Dialog.showButtonDialog("HI", "Miep", "ähm", "ok",
        // "natol"));
        // System.out.println(Dialog.showInputButtonDialog("HI", "Miep", "ähm",
        // "ok", "natol")[0]);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TreeOfPersons.fxml"));
            GridPane root = loader.load();

            ((TreeOfPersonsController) loader.getController()).initValues();
            

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
