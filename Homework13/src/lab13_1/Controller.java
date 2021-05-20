package lab13_1;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {
    private Counter counter = new Counter();

    public void refresh(MouseEvent mouseEvent) {
        counter.inc();
        String label = "Pressed: " + counter.getValue();
        Button button = (Button)mouseEvent.getSource();
        button.setText(label);
    }
}
