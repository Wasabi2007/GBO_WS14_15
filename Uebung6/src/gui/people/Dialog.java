package gui.people;


public class Dialog {

    public static int showButtonDialog(String title, String message, String... buttons) {
        ButtonDialog dialogstage = new ButtonDialog(title, message, buttons);
        return dialogstage.showAndWaitWithReturn();
    }

    public static String[] showInputButtonDialog(String title, String message, String... lable) {
        InputDialog dialogstage = new InputDialog(title, message, lable);
        return dialogstage.showAndWaitWithReturn();
    }
}
