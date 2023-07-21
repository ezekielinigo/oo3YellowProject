package calcu.calcu;
import calcu.data.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/** LAHAT NG MENU PAGES, DITO HUMIHIRAM NG METHODS ************
 * kumbaga yung menu sa gilid ng program hindi naman nabago un
 * so pwedeng isang code nalang sya (eto un)
 * next is Export.java
 * */
public abstract class Menu extends Main{
    public abstract void initialize();
    protected Stage mainStage;
    public void setMainStage(Stage stage){
        this.mainStage = stage;
    }
    public void showPeople(ActionEvent e) throws IOException{
        // in short yung code d2 is somewhat similar lang sa iba pang "show" methods
    }
    public void showExport(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("export.fxml")); // baguhin lang ung fxml file
        Parent root = loader.load();

        Export export = loader.getController(); // tas baguhin to from "Export export" -> "Class class"
        export.setMainStage(mainStage); // same d2 dapat "class.setMainStage(mainStage)"

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showTemplate(ActionEvent e) throws IOException{

    }
    public void showSettings(ActionEvent e) throws IOException{

    }
    public void showRegister(ActionEvent e) throws IOException{



        FXMLLoader loader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Parent root = loader.load();

        Register register = loader.getController();
        register.setMainStage(mainStage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}