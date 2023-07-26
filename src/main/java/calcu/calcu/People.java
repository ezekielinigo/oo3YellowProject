package calcu.calcu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/** so ngaun, no need na icode ung menu buttons dito, puro calculations nalang baga */
public class People extends Menu{
    @FXML
    private VBox container;
    @FXML
    private FXMLLoader loader;
    @FXML
    private ImageView icon;
    @FXML
    private Label name;
    @FXML
    private ImageView button;

    public void newProfile() throws IOException {
        // load template then add to vBox (di pa tapos)
        loader = new FXMLLoader(Main.class.getResource("peopleSegment.fxml"));
        AnchorPane segment = loader.load();
        container.getChildren().add(segment);


        /*
        ImageView icon = (ImageView) segmentTemplate.getNamespace().get("icon");
        Label name = (Label) segmentTemplate.getNamespace().get("profileName");
        ImageView button = (ImageView) segmentTemplate.getNamespace().get("button");

        ImageView i = new ImageView(icon.getImage());
        Label n = new Label(name.getText());
        ImageView b = new ImageView(button.getImage());

         */

        //segment.getChildren().addAll(i,b,n);

    }
    @Override
    public void initialize() {
        //loader = new FXMLLoader(Main.class.getResource("peopleSegment.fxml"));
        //AnchorPane segment = loader.load();
        //container.getChildren().add(segment);

    }



    public void delProfile(){

    }

    public void openProfile(){

    }
}
