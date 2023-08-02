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
import javafx.scene.input.MouseEvent;
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
 * controller == yung controller mcmo, used to call the functions inside
 * */
public class People extends Menu{
    /*** variables to be used by peopleEdit.java ***/
    public static Employee editEmployee;

    @FXML
    private VBox container; // VBox where profile previews are added
    public peopleSegment controllerSegment; // used to call the functions inside peopleSegment
    @Override
    public void initialize() throws IOException { // keeps track of the profile previews to make them persistent
        // List out all employees
        if (container != null){
            for (Employee employee : account.getEmployees()) {
                addProfileToContainer(employee);
            }
        }
    }

    private void addProfileToContainer(Employee employee) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("peopleSegment.fxml"));
        Node newSegment = loader.load();
        peopleSegment controllerSegment = loader.getController();

        controllerSegment.create(employee.getName(), employee.getNote(), "PHP " + employee.getNetSalary());

        container.getChildren().add(newSegment);

        ImageView delButton = (ImageView) newSegment.lookup("#button");
        delButton.setOnMouseClicked(event -> delProfile(employee));

        Label editButton = (Label) newSegment.lookup("#profileName");
        editButton.setOnMouseClicked(event -> editProfile(employee));
    }

    public void newProfile() throws IOException { // used to create a new profile incl. preview, info, etc.
        // set up profile menu segment (peopleSegment.fxml)
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("peopleSegment.fxml"));
//        Node newSegment = loader.load();
//        controllerSegment = loader.getController();
//
//        // create an empty profile
//        Employee newEmployee = new Employee(null);
//        account.addEmployee(newEmployee);
//        editEmployee = newEmployee;
//
//
//        // profile editor
//        // this will check if the current editEmployee variable is empty or not
//        // we are creating a new profile so it will detect that it has a null name
//        // it will call the create() method, which displays a blank edit form
//        // after saving, this will get the information found on the form and assign to the editEmployee
//        showPeopleEdit();
//
//        // and this will create and assign the brief profile info to it
//        controllerSegment.create(editEmployee.getName(), "PHP " + 100, "Hourly");
//        editEmployee.setProfile(controllerSegment);
//
//        // this will set up the other function buttons of the profile menu segment
//        container.getChildren().add(newSegment);
//        ImageView delButton = (ImageView) newSegment.lookup("#button");
//        delButton.setOnMouseClicked(this::delProfile);
//        Label editButton = (Label) newSegment.lookup("#profileName");
//        editButton.setOnMouseClicked(this::editProfile);

        Employee newEmployee = new Employee(null);
        account.addEmployee(newEmployee);
        addProfileToContainer(newEmployee);

        editEmployee = newEmployee;
        showPeopleEdit();
        controllerSegment.create(editEmployee.getName(), "PHP " + 100, "Hourly");
        editEmployee.setProfile(controllerSegment);
    }

    private void delProfile(Employee employee) {
        try {
            // when button is pressed, call this method
//            controllerSegment.delProfile(); // do the actual deletion
//            showPeople(); // refresh screen to reflect changes
            account.delEmployee(employee);
            container.getChildren().clear();
            for (Employee emp : account.getEmployees()) {
                addProfileToContainer(emp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editProfile(Employee employee){
        try {
//            container.getChildren().clear();
//            // first, get employee info
//            editEmployee = account.getEmployee(controllerSegment.getSegment().getName());
//            showPeopleEdit();
            container.getChildren().clear();
            editEmployee = account.getEmployee(employee.getName());
            showPeopleEdit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Employee getEmployee(){
        return editEmployee;
    }

}
