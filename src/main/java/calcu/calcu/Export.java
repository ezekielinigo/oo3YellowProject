package calcu.calcu;

import calcu.data.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** so ngaun, no need na icode ung menu buttons dito, puro calculations nalang baga */
public class Export extends Menu{
    @FXML
    private Label grandTotal;
    @Override
    public void initialize(){
        double value = 0;
        for (Employee employee : account.getEmployees())
            value = value + employee.getNetSalary();
        grandTotal.setText("PHP " + value);
    }
}
