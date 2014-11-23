package gui.people;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

class InputDialog extends Stage implements EventHandler<ActionEvent> {

    private ArrayList<TextField> fields;

    private String[] returnValue;

    public InputDialog(String title, String message, String... lables) {
        this.setTitle(title);
        GridPane rootpane = new GridPane();
        rootpane.add(new Label(message), 0, 0);

        fields = new ArrayList<>();

        int index = 0;
        for (String lable : lables) {
            Label l = new Label(lable);
            rootpane.add(l, 0, index + 1);
            TextField input = new TextField();
            fields.add(input);
            rootpane.add(input, 1, index + 1);
            index++;
        }
        Button ok = new Button("Ok");
        ok.setUserData(true);
        ok.setOnAction(this);
        rootpane.add(ok, 0, index + 1);

        Button abbr = new Button("Abbrechen");
        abbr.setUserData(false);
        abbr.setOnAction(this);
        rootpane.add(abbr, 1, index + 1);

        Scene root = new Scene(rootpane);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(root);
    }

    @Override
    public void handle(ActionEvent event) {
        if ((boolean) ((Button) event.getSource()).getUserData()) {
            returnValue = new String[fields.size()];
            int index = 0;
            for (TextField tf : fields) {
                returnValue[index] = tf.getText();
                index++;
            }
        }
        this.close();
    }

    public String[] showAndWaitWithReturn() {
        this.showAndWait();
        return returnValue;
    }
}