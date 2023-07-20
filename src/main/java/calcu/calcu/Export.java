package calcu.calcu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** so ngaun, no need na icode ung menu buttons dito, puro calculations nalang baga */
public class Export extends Menu{
    @FXML
    private Label grandTotal;
    private double kunyareEtoYungTotal = 1000.00;
    @Override
    public void initialize(){
        grandTotal.setText("PHP " + kunyareEtoYungTotal);
    }
}
