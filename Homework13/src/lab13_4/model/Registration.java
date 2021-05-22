package lab13_4.model;

import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;


public class Registration {
    private String player1Name, player2Name, player1Symbol, player2Symbol;
    private AtomicInteger player1Score, player2Score;

    public GridPane createGridPane(Scene scene, Stage primaryStage){
        Text player1Text = new Text("Player 1");
        Text player2Text = new Text("Player 2");

        player1Score = new AtomicInteger();
        player2Score = new AtomicInteger();

        player1Text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12));
        player2Text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12));

        player1Text.setFill(Color.web("#333333"));
        player2Text.setFill(Color.web("#333333"));

        TextField player1NameTextField = new TextField();
        TextField player1SymbolTextField = new TextField();
        TextField player2NameTextField = new TextField();
        TextField player2SymbolTextField = new TextField();

        Button playButton = new Button("Play");

        GridPane pane = new GridPane();
        pane.setMinSize(400, 200);

        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(10);
        pane.setHgap(10);

        pane.setAlignment(Pos.CENTER);

        player1NameTextField.setPromptText("Name");
        player1NameTextField.setPrefWidth(180);
        player1NameTextField.setMaxWidth(180);

        player1SymbolTextField.setPromptText("Symbol");
        player1SymbolTextField.setPrefWidth(180);
        player1SymbolTextField.setMaxWidth(180);

        player2NameTextField.setPromptText("Name");
        player2SymbolTextField.setPromptText("Symbol");

        pane.add(player1Text, 0, 0);
        pane.add(player2Text, 0, 3);

        pane.add(player1NameTextField, 0, 1);
        pane.add(player1SymbolTextField, 1, 1);

        pane.add(player2NameTextField, 0, 4);
        pane.add(player2SymbolTextField, 1, 4);

        pane.add(playButton, 0, 6, 2, 1);
        GridPane.setHalignment(playButton, HPos.CENTER);

        playButton.setPrefWidth(200);

        playButton.setStyle("-fx-background-color: #4f9c46;" +
                "-fx-background-radius: 6, 5; -fx-background-insets: 0, 1; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); " +
                "-fx-text-fill: #ffffff;" +
                "-fx-font-weight: bold;");

        playButton.setDisable(true);

        ChangeListener<String> listener = ((observable, oldValue, newValue) -> {
            if(!player1NameTextField.getText().isEmpty() && !player1NameTextField.getText().isEmpty() &&
                    !player1SymbolTextField.getText().isEmpty() && !player2SymbolTextField.getText().isEmpty()) {
                playButton.setDisable(false);
            } else{
                playButton.setDisable(true);
            }
        });

        player1NameTextField.textProperty().addListener(listener);
        player1SymbolTextField.textProperty().addListener(listener);
        player2NameTextField.textProperty().addListener(listener);
        player2SymbolTextField.textProperty().addListener(listener);

        playButton.setOnAction(actionEvent -> {
            this.player1Name = player1NameTextField.getText();
            this.player1Symbol= player1SymbolTextField.getText();
            this.player2Name = player2NameTextField.getText();
            this.player2Symbol = player2SymbolTextField.getText();


            primaryStage.setTitle("Tic-Tac-Toe");
            primaryStage.setScene(scene);

        });


        return pane;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public String getPlayer1Symbol() {
        return player1Symbol;
    }

    public String getPlayer2Symbol() {
        return player2Symbol;
    }

    public AtomicInteger getPlayer1Score() {
        return player1Score;
    }

    public AtomicInteger getPlayer2Score() {
        return player2Score;
    }
}
