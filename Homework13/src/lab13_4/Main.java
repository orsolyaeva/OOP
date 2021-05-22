package lab13_4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lab13_4.model.Board;
import lab13_4.model.Registration;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    private boolean turn = false;
    private static final int size = 3;
    private static boolean isSetup = false;
    private static final Registration registration = new Registration();

    private Parent createBoard(Board board, Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setPrefSize(600, 600);

        Group grp = new Group();
        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < board.getSize(); ++i) {
            for (int j = 0; j < board.getSize(); ++j) {
                Button btn = new Button();
                btn.setTranslateX(j * 150);
                btn.setTranslateY(i * 150);
                btn.setPrefWidth(140);
                btn.setPrefHeight(140);
                btn.setMaxWidth(140);
                btn.setMaxHeight(140);
                btn.setStyle("-fx-font-size:40");
                int finalJ = j;
                int finalI = i;
                btn.setOnAction(event -> {
                    pane.requestFocus();

                    if (board.getBoardCell(finalI, finalJ) == -1) {
                        if (turn) {
                            btn.setText(registration.getPlayer1Symbol());
                            board.setMove(finalI, finalJ, 1);
                            btn.setDisable(true);
                            turn = false;
                            counter.addAndGet(1);
                        } else {
                            btn.setText(registration.getPlayer2Symbol());
                            board.setMove(finalI, finalJ, 0);
                            btn.setDisable(true);
                            turn = true;
                            counter.addAndGet(1);
                        }

                        if (board.checkState()) {
                            lab13_4.model.AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Game over",
                                    ((!turn) ? registration.getPlayer1Name() : registration.getPlayer2Name())
                                            + " is the winner!");

                            try {
                                start(primaryStage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else if (counter.get() == size * size && !board.checkState()) {
                            lab13_4.model.AlertHelper.showAlert(Alert.AlertType.INFORMATION, "Game over", "Nobody won!");

                            try {
                                start(primaryStage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                grp.getChildren().add(btn);
            }
        }
        pane.getChildren().add(grp);
        StackPane.setAlignment(grp, Pos.CENTER);
        return pane;
    }


    @Override
    public void start(Stage primaryStage) {
        Parent board = createBoard(new Board(size), primaryStage);
        if (!isSetup) {
            GridPane gridPane = registration.createGridPane(new Scene(board), primaryStage);
            Scene scene1 = new Scene(gridPane);

            primaryStage.setTitle("Registration");
            primaryStage.setScene(scene1);
            primaryStage.show();

            gridPane.requestFocus();
            board.requestFocus();

            isSetup = true;
        } else {
            primaryStage.setTitle("Tic-Tac-Toe");
            primaryStage.setScene(new Scene(board));
            primaryStage.show();

            board.requestFocus();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
