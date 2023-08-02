package calcu.calcu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class peopleSegment extends Menu{
    @FXML
    private AnchorPane segment;
    @FXML
    private ImageView button;
    @FXML
    private Label profileName;
    @FXML
    private Label salaryTotal;
    @FXML
    private Label salaryType;

    @Override
    public void initialize(){

    }
    public void create(String name, String sTotal, String sType){
        this.profileName.setText(name);
        this.salaryTotal.setText(sTotal);
        this.salaryType.setText(sType);
    }
    public void delProfile() throws IOException{
        account.delEmployee(account.getEmployee(profileName.getText()));
    }
    public String getName() {
        return this.profileName.getText();
    }

    public peopleSegment getSegment(){
        return this;
    }

    public AnchorPane getAnchorPane(){
        return this.segment;
    }


    public void setName(String name) {
        this.profileName.setText(name);
    }

    public void setNote(String note) {
        this.salaryTotal.setText(note);

    }

    public void setMonthlyRate(double monthlySalary) {
        this.salaryType.setText(String.valueOf(monthlySalary));

    }
}
