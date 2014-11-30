package gui.people;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

class ButtonDialog extends Stage implements EventHandler<ActionEvent> {

    private int returnValue = -1;

    public ButtonDialog(String title, String message, String... buttons) {
        this.setTitle(title);
        GridPane rootpane = new GridPane();
        rootpane.add(new Label(message), 0, 0);

        int index = 0;
        for (String button : buttons) {
            Button b = new Button(button);
            rootpane.add(b, index, 1);
            b.setUserData(index++);
            b.setOnAction(this);

        }

        Scene root = new Scene(rootpane);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(root);
    }

    @Override
    public void handle(ActionEvent event) {
        returnValue = (int) ((Button) event.getSource()).getUserData();
        this.close();
    }

    public int showAndWaitWithReturn() {
        this.showAndWait();
        return returnValue;
    }
}