package calcu.calcu;

import calcu.data.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class peopleEdit extends People{
/*** SETTING UP TEXT FIELDS TO BE USED ***/
    @FXML
    private TextField name;
    @FXML
    private TextField note;
    @FXML
    private TextField hourly;
    @FXML
    private TextField hours;
    @FXML
    private TextField monthly;
    @FXML
    private TextField multi;
    @FXML
    private TextField ohours;
    @FXML
    private TextField totalSalary;
    @FXML
    private TextField insurance;
    @FXML
    private TextField pgb;
    @FXML
    private TextField phil;
    @FXML
    private TextField incomeTax;
    @FXML
    private TextField totalTax;
    @FXML
    private TextField totalFinal;
    @FXML
    private ImageView button;

/*** SETTING UP FUNCTIONALITIES ***/
    @FXML
    private ChoiceBox<String> insuranceType;
    private final String[] insuranceTypes = {"SSS","GSIS"};
    public void initialize(){
        insuranceType.getItems().addAll(insuranceTypes);
        insuranceType.setOnAction(this::insuranceUpdate);

        if (editEmployee.getName() != null)
            edit();
    }

/*** ADDING A NEW PROFILE WILL DISPLAY PRE-DEFINED VALUES
 *   EDITING A PROFILE WILL DISPLAY ITS VALUES
 * ***/
    public void edit(){
        name.setText(editEmployee.getName());
        note.setText(editEmployee.getNote());
        hourly.setText(String.valueOf(editEmployee.getHourlyRate()));
        monthly.setText(String.valueOf(editEmployee.getMonthlySalary()));
        hours.setText(String.valueOf(editEmployee.getHours()));
        ohours.setText(String.valueOf(editEmployee.getOvertimeHours()));
        multi.setText(String.valueOf(editEmployee.getMultiplier()));
        totalSalary.setText(String.valueOf(editEmployee.getTotalSalary()));
        insurance.setText(String.valueOf(editEmployee.getInsurance()));
        insuranceType.setValue(editEmployee.getInsuranceType());
        pgb.setText(String.valueOf(editEmployee.getPgb()));
        phil.setText(String.valueOf(editEmployee.getPhil()));
        incomeTax.setText(String.valueOf(editEmployee.getIncomeTax()));
        totalTax.setText(String.valueOf(editEmployee.getTotalTax()));
        totalFinal.setText(String.valueOf(editEmployee.getNetSalary()));
    }

/*** insuranceUpdate calls update method when insurance option is modified
 *   textUpdate calls update method when any text field is modified
 *   update method does all the calculations
 * ***/
    public void insuranceUpdate(ActionEvent e){
        update();
    }
    public void textUpdate(InputMethodEvent inputMethodEvent) {
        update();
    }
    public void update(){
        // PA ADD NA NG COMPUTATIONS DITO TY !
        // GOAL IS PAG MAY BINAGO SA EDITABLE FIELDS, MATIC MAGBABAGO DIN YUNG IBA
        // LAHAT NG VALUE IS STORED MUNA SA TEXTFIELDS TEMPORARILY
        // (UNLESS MAGLAGAY KA NG TEMP VARIABLES BA D2 SA LOOB NG METHOD)
        // SAKA LANG MAGIGING FINAL YUNG CHANGES PAG PININDOT YUNG CHECK
        // (TAPOS NA TO CHECK SAVE() METHOD PERO IDK KUNG GUMAGANA KASI WALA PANG COMPUTATIONS)

        if (insuranceType.getValue().equals("SSS")) {
            // ETO SSS COMPUTATIONS
            //insurance.setText(String.valueOf(COMPUTATIONS));
            // GANTO SAMPLE PANO MAG OUTPUT NG VALUE
            // CONVERT MUNA TO STRING THEN LAGAY SA TEXT FIELD
        }else if (insuranceType.getValue().equals("GSIS")) {
            // ETO GSIS
        }else{
            insurance.setText(String.valueOf(0));
        }

        // FOR TESTING, DELETE NALANG TO PAGKATAPOS
        hourly.setText("10");
        monthly.setText("20");
        hours.setText("30");
        ohours.setText("40");
        multi.setText("50");
        totalSalary.setText("60");
        insurance.setText("70");
        pgb.setText("80");
        phil.setText("90");
        incomeTax.setText("11");
        totalTax.setText("21");
        totalFinal.setText("31");
    }

/*** CLICKING CHECK WILL SAVE CHANGES AND WILL REFLECT TO ACTUAL EMPLOYEE INFO ***/
    public void save() {
        try {
            if (editEmployee != null) {
                editEmployee.getProfile().create(name.getText(), note.getText(), "PHP " + totalFinal.getText());
                editEmployee.setName(name.getText());
                editEmployee.setNote(note.getText());
                editEmployee.setInsuranceType(insuranceType.getValue());

                // convert to double
                double dhourly = Double.parseDouble(hourly.getText());
                double dhours = Double.parseDouble(hours.getText());
                double dmonthly = Double.parseDouble(monthly.getText());
                double dmulti = Double.parseDouble(multi.getText());
                double dohours = Double.parseDouble(ohours.getText());
                double dtotalSalary = Double.parseDouble(totalSalary.getText());
                double dinsurance = Double.parseDouble(insurance.getText());
                double dpgb = Double.parseDouble(pgb.getText());
                double dphil = Double.parseDouble(phil.getText());
                double dincomeTax = Double.parseDouble(incomeTax.getText());
                double dtotalTax = Double.parseDouble(totalTax.getText());
                double dnetSalary = Double.parseDouble(totalFinal.getText());

                // Update the employee's fields
                editEmployee.setHourlyRate(dhourly);
                editEmployee.setHours(dhours);
                editEmployee.setMonthlySalary(dmonthly);
                editEmployee.setMultiplier(dmulti);
                editEmployee.setOvertimeHours(dohours);
                editEmployee.setTotalSalary(dtotalSalary);
                editEmployee.setInsurance(dinsurance);
                editEmployee.setPgb(dpgb);
                editEmployee.setPhil(dphil);
                editEmployee.setIncomeTax(dincomeTax);
                editEmployee.setTotalTax(dtotalTax);
                editEmployee.setNetSalary(dnetSalary);

                // return to People screen
                showPeople();
            } else {

            }
        } catch (IOException e){
            System.out.println();
        }
    }
}
