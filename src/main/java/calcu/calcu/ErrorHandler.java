package calcu.calcu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ErrorHandler {
    @FXML
    private Label errorMessage;
    @FXML
    private Button confirm;
    public void setErrorMessage(String error) {
        errorMessage.setText(error);
    }

    public void confirm(){
        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }
}
