package lab13_3;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Controller {
    @FXML
    private TextField firstnameField, lastnameField, emailField;
    @FXML
    private Button submitButton;

    public PrintStream out;

    {
        try {
            out = new PrintStream(new File("students.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("COULD NOT OPEN THE FILE.");
            System.exit(1);
        }
    }


    @FXML
    protected void handleSubmitButton(ActionEvent actionEvent) {
        Window owner = submitButton.getScene().getWindow();

        if(firstnameField.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "From Error!", "Please enter your first name");
            return;
        }

        if(lastnameField.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your last name");
            return;
        }

        if(emailField.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email");
            return;
        }

        out.println(firstnameField.getText() + "," + lastnameField.getText() + "," + emailField.getText());

        handleClearButton(actionEvent);
    }

    public void handleClearButton(ActionEvent actionEvent) {
        firstnameField.clear();
        lastnameField.clear();
        emailField.clear();
    }
}

class AlertHelper{
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
