package lab13_4.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertHelper {
    public static void showAlert(Alert.AlertType alertType, String title, String message){
        ButtonType cancelButton = new ButtonType("Finish game");
        ButtonType playAgainButton = new ButtonType("Play again");

        Alert alert = new Alert(alertType, title, cancelButton, playAgainButton);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.getDialogPane().requestFocus();

        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(cancelButton, playAgainButton);
        
        Optional<ButtonType> option = alert.showAndWait();
        
        if(option.isPresent() && option.get() == cancelButton){
           System.exit(0);
        }
    }



}
