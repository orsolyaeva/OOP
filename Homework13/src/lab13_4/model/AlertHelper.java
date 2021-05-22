package lab13_4.model;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Optional;

public class AlertHelper {
    public static void showAlert(Alert.AlertType alertType, String title, String message, Registration registration){
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
            endGameAlert(alertType, new String[]{registration.getPlayer1Name(), registration.getPlayer1Score().toString(),
                    registration.getPlayer2Name(),  registration.getPlayer2Score().toString()});
        }
    }

    public static void endGameAlert(Alert.AlertType alertType, String[] players){
        ButtonType cancelButton = new ButtonType("Cancel");

        Font headerFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12);

        Text[] texts = new Text[6];

        for(int i = 0; i < 4; i++){
            texts[i] = new Text(players[i]);
        }

        texts[4] = new Text("Name:");
        texts[5] = new Text("Score:");

        texts[4].setFont(headerFont);
        texts[5].setFont(headerFont);

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(35);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(35);
        gridPane.getColumnConstraints().addAll(col1,col2,col3);

        gridPane.add(texts[4], 0, 0);
        gridPane.add(texts[5], 0, 1);
        gridPane.add(texts[0], 1, 0);
        gridPane.add(texts[2], 2, 0);
        gridPane.add(texts[1], 1, 1);
        gridPane.add(texts[3], 2, 1);

        gridPane.setHgap(20);
        gridPane.setVgap(20);

        gridPane.setPrefWidth(200);
        gridPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(texts[0], HPos.CENTER);
        GridPane.setHalignment(texts[1], HPos.CENTER);
        GridPane.setHalignment(texts[2], HPos.CENTER);
        GridPane.setHalignment(texts[3], HPos.CENTER);

        Alert alert = new Alert(alertType, "End Game", cancelButton);
        alert.setTitle("End Game");
        alert.setHeaderText(null);
        alert.setGraphic(null);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.requestFocus();

        dialogPane.setContent(gridPane);

        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(cancelButton);

        ((Button)dialogPane.lookupButton(cancelButton)).setPrefWidth(200);

        Region spacer = new Region();
        ButtonBar.setButtonData(spacer, ButtonBar.ButtonData.BIG_GAP);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        dialogPane.applyCss();
        HBox hboxDialogPane = (HBox) dialogPane.lookup(".container");
        hboxDialogPane.getChildren().add(spacer);

        Optional<ButtonType> option = alert.showAndWait();

        if(option.isPresent() && option.get() == cancelButton){
            System.exit(0);
        }
    }
}
