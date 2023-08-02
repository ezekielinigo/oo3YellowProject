package calcu.calcu;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Settings extends Menu{

    @FXML
    private TextField oldPass;
    @FXML
    private TextField newPass;
    public void changePass() throws IOException {
        if (oldPass.getText().equals(account.getPassword())) {
            account.setPassword(newPass.getText());
            showError("Password changed!");
        }else if (newPass.getText().isBlank() || newPass.getText().indexOf(' ') != -1){
            showError("Password should be valid and without spaces.");
        }else{
            showError("Incorrect Password.");
        }
    }
    @Override
    public void initialize() throws IOException {

    }
}
