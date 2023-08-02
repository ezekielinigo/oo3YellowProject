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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Register extends Menu {
    public void initialize(){
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
    public static int checkAccDatabase(String inputUser, String inputPass) throws IOException {
        String file = "assets/acc_list.csv";
        BufferedReader reader = null;
        String line = "";
        String[][] list = new String[2][100];
        int i;
        int j = 0;
        int columns = 0;
        try{
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] row = line.split(",");
                i = 0;
                for (String index : row){
                    list[i][j] = index;
                    i++;
                }
                columns++;
                j++;
            }
        }catch (Exception e){e.printStackTrace();}finally {
            reader.close();
        }

        for (int a=0; a<columns; a++){
            if ((list[0][a].compareTo(inputUser) == 0))
            {
                if (list[1][a].compareTo(inputPass) == 0)
                {
                    //login successful
                    System.out.println("User Found on row: "+a);
                    return 1;
                }else {
                    //wrong password
                    return 2;
                }
            }
        }
        return 3;
    }
    public void createAccount(ActionEvent e) throws IOException {
        if (username.getText().isBlank() || password.getText().isBlank()) {
            username.clear();
            password.clear();
            return;
        }

        account.setUsername(username.getText());
        account.setPassword(password.getText());

        switch (checkAccDatabase(username.getText(),password.getText())){
            case 1: //login
                account.loadData();
                break;
            case 2: //wrong password
                showError("Wrong password entered.");
                username.clear();
                password.clear();
                return;
            case 3: //new account
                account.newAccount(username.getText(),password.getText());
                account.loadData();
                break;
            default:
                showError("Account already exists.");
                username.clear();
                password.clear();
                return;
        }

        account.setisLoadingData(true);

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("People.fxml"));
        Parent root = loader.load();

        People export = loader.getController();
        export.setMainStage(mainStage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
