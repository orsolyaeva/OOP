package lab13_2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import lab13_2.model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main extends Application {
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

    @Override
    public void start(Stage primaryStage){
            GridPane gridPane = gridPane();

            Scene scene = new Scene(gridPane);
            primaryStage.setTitle("Data App");
            primaryStage.setScene(scene);
            primaryStage.show();

    }

    public GridPane gridPane(){
        Text firstnameText = new Text("Firstname");
        Text lastnameText = new Text("Lastname");
        Text emailText = new Text("Email");

        TextField firstnameTextField = new TextField();
        TextField lastnameTextField = new TextField();
        TextField emailTextField = new TextField();

        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(firstnameText, 0, 0);
        gridPane.add(lastnameText, 0, 1);
        gridPane.add(emailText, 0, 2);
        gridPane.add(firstnameTextField, 1, 0);
        gridPane.add(lastnameTextField, 1, 1);
        gridPane.add(emailTextField, 1, 2);

        gridPane.add(submitButton, 0, 3);
        gridPane.add(clearButton, 1, 3);

        submitButton.setOnAction(actionEvent -> {
            Window owner = submitButton.getScene().getWindow();

            if(firstnameTextField.getText().isEmpty()){
                AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "From Error!", "Please enter your first name");
                return;
            }
            String firstname = firstnameTextField.getText();

            if(lastnameTextField.getText().isEmpty()){
                AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your last name");
                return;
            }
            String lastname = lastnameTextField.getText();

            if(emailTextField.getText().isEmpty()){
                AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email");
                return;
            }
            String email = emailTextField.getText();


            out.println(new Student(firstname, lastname, email));

            firstnameTextField.clear();
            lastnameTextField.clear();
            emailTextField.clear();
        });

        clearButton.setOnAction(actionEvent -> {
            firstnameTextField.clear();
            lastnameTextField.clear();
            emailTextField.clear();
        });

        return gridPane;
    }

    public static class AlertHelper{
        public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message){
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.initOwner(owner);
            alert.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
