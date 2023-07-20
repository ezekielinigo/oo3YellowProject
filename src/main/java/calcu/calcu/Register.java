package calcu.calcu;

import calcu.data.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Register {
    private Stage mainStage;
    public void setMainStage(Stage stage){
        this.mainStage = stage;
    }

    public void showLogin(ActionEvent e) throws IOException {

    }

    /** EXPORT SCREEN **/
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void showExport(ActionEvent e) throws IOException {
        Account input = new Account(username.getText(),password.getText());
        if (Account.loadAccount()){
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("export.fxml"));
            Parent root = loader.load();

            Export export = loader.getController();
            export.setMainStage(mainStage);

            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        }else{
            username.clear();
            password.clear();
        }

    }
}
