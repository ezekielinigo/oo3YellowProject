package calcu.calcu;

import calcu.data.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/** terminologies
 * employee == profile connected sa account
 * segment == ung GUI ng profile / ung pindutan sa people screen
 * newProfile == temporary profile para idifferentiate ung bago
 * */
public class People extends Menu{
    @FXML
    VBox container;

    @Override
    public void initialize() {
        // List out all employees
        for (Employee employee: account.getEmployees()){
            container.getChildren().add(employee.getProfile());
            System.out.println(employee);
        }
    }

    public void newProfile() throws IOException{
        // set up profile template (peopleSegment.fxml)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("peopleSegment.fxml"));
        Node newSegment = loader.load();
        peopleSegment template = loader.getController();

        // open profile editor para gumawa ng profile
        // showPeopleNew();
        /// bagong fxml / new GUI
        /// meron cguro getName(){ return textField.getText() }
        /// isa ulit FXMLLoader bullshit para maaccess ung getName()

        /// kunin ung info para gumawa ng bagong employee

        /// reflect changes sa GUI ng people screen muna
        //template.create(newSegment, getName(), getSalary(), ...)
        //container.getChildren().add(newSegment);

        /// tapos gawa na ng employee mcmo
        //Employee newProfile = new Employee(newSegment, getName(), getSalary(), ...);

        /// pag complete na lahat ng info, pede na idagdag sa main list of employees
        //account.addEmployee(newProfile);
    }
}
