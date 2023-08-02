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

public class Register extends Menu {
    public void initialize(){
        // IDK para san to
    }
    public void showLogin(ActionEvent e) throws IOException {
        // TBA
    }

    public void updateUsername(){
    }
    public void updatePassword(){
    }

    /** EXPORT SCREEN **/
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void createAccount(ActionEvent e) throws IOException {
        String user = username.getText();
        String pass = password.getText();
        account.setUsername(user.replaceAll("\\s", ""));
        account.setPassword(pass.replaceAll("\\s", ""));

        System.out.println(account.getUsername());

        if (account.loadAccount()){
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
