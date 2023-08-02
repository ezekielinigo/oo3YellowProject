package calcu.calcu;
import calcu.data.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/** LAHAT NG MENU PAGES, DITO HUMIHIRAM NG METHODS ************
 * kumbaga yung menu sa gilid ng program hindi naman nabago un
 * so pwedeng isang code nalang sya (eto un)
 * next is Export.java
 * */
public abstract class Menu extends Main{
    public abstract void initialize() throws IOException;
    protected Stage mainStage;
    public void setMainStage(Stage stage){
        this.mainStage = stage;
    }
    private ArrayList<Node> segments = new ArrayList<>();
    public ArrayList<Node> getSegments(){
        return segments;
    }
    public void setSegments(Node segment){
        segments.add(segment);
    }

    public void showPeople() throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("people.fxml"));
        Parent root = loader.load();

        People people = loader.getController();
        people.setMainStage(mainStage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showPeopleEdit() throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("peopleEdit.fxml"));
        Parent root = loader.load();

        peopleEdit people = loader.getController();
        people.setMainStage(mainStage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showExport() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("export.fxml")); // baguhin lang ung fxml file
        Parent root = loader.load();

        Export export = loader.getController(); // tas baguhin to from "Export export" -> "Class class"
        export.setMainStage(mainStage); // same d2 dapat "class.setMainStage(mainStage)"

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showError(String error) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("errorHandler.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setTitle("Error");

        stage.setScene(scene);
        stage.show();

        ErrorHandler controller = loader.getController();
        controller.setErrorMessage(error);
    }
    public void showSettings() throws IOException{

    }
    public void showRegister() throws IOException{
        account.saveAccount();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Parent root = loader.load();

        Register register = loader.getController();
        register.setMainStage(mainStage);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
