package gui.people;

import java.util.Vector;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeOfPersonsController implements ChangeListener<TreeItem<Person>> {
    @FXML
    private Label nameOut;

    @FXML
    private Label funktionOut;

    @FXML
    private Label untergebenerOut;

    @FXML
    private Label vorgesetzterOut;

    @FXML
    private TreeView<Person> personTreeView;

    private TreeItem<Person> selectedItem;

    private TreeItem<Person> root;

    public TreeOfPersonsController() {
        super();
    }

    public void initValues() {
        personTreeView.getSelectionModel().selectedItemProperty().addListener(this);
        root = new TreeItem<Person>(new Person("miep", "map", "moep"));
        root.getChildren().add(new TreeItem<Person>(new Person("miep", "map1", "moep")));
        root.getChildren().add(new TreeItem<Person>(new Person("miep", "map2", "moep")));
        root.getChildren().add(new TreeItem<Person>(new Person("miep", "map3", "moep")));
        root.getChildren().add(new TreeItem<Person>(new Person("miep", "map4", "moep")));
        root.getChildren().add(new TreeItem<Person>(new Person("miep", "map5", "moep")));
        personTreeView.setRoot(root);

    }

    @FXML
    private void addPerson() {
        // System.out.println("Hi");
        String[] infos = Dialog.showInputButtonDialog("Eingabe", "Geben sie Die notwendingen Werte ein!", "Vorname:", "Name:", "Funktion:");
        if (infos != null) {
            if (selectedItem != null) {
                selectedItem.getChildren().add(new TreeItem<Person>(new Person(infos[0], infos[1], infos[2])));
            } else if (root == null) {
                root = new TreeItem<Person>(new Person(infos[0], infos[1], infos[2]));
                personTreeView.setRoot(root);
            }
        }
    }

    @FXML
    private void removePerson() {
        if (selectedItem == root) {
            Dialog.showButtonDialog("Error", "Die wurzel kann nicht gesclöscht werden", "Ok");
        } else if (selectedItem == null) {
            Dialog.showButtonDialog("Error", "Es muss ein knoten ausgewählt sein.", "Ok");
        } else {
            if (Dialog.showButtonDialog("Löschen", "Soll der Knoten gelöscht werden?", "Ok", "Abbrechen") == 0) {
                TreeItem<Person> p = selectedItem.getParent();
                p.getChildren().remove(selectedItem);
            }
        }
    }

    @Override
    public void changed(ObservableValue<? extends TreeItem<Person>> observable, TreeItem<Person> oldValue, TreeItem<Person> newValue) {
        selectedItem = newValue;

        Person selectedPerson = newValue.getValue();
        nameOut.setText(selectedPerson.getVornamen() + " " + selectedPerson.getNachnamen());
        funktionOut.setText(selectedPerson.getFunktion());
        int minions = -1;
        Vector<TreeItem<Person>> toInvestigate = new Vector<>();
        toInvestigate.add(selectedItem);
        while (toInvestigate.size() > 0) {
            toInvestigate.addAll(toInvestigate.get(0).getChildren());
            minions++;
            toInvestigate.remove(0);
        }
        untergebenerOut.setText(String.valueOf(minions));
        if (selectedItem.getParent() != null) {
            Person p = selectedItem.getParent().getValue();
            vorgesetzterOut.setText(p.getVornamen() + " " + p.getNachnamen());
        } else {
            vorgesetzterOut.setText("-");
        }

    }

}
