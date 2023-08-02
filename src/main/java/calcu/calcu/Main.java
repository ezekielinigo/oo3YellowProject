package calcu.calcu;

import calcu.data.Account;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*** GUIDE KASI MAKAKALIMUTIN AQ ***************************
 *
 * // stage -> window mcmo
 *
 * dahil isang window lang, isang stage lang gagamitin natin
 * ang need natin baguhin is yung "scene"
 *
 * // scene -> contents ng window
 * // fxml -> graphics mcmo
 * // controller -> kung ano ginagawa ng graphics
 *
 * pag gusto mo baguhin ung itsura, fxml (scenebuilder) gagamitin
 * pag gusto mo baguhin ung pindutan, controller gagamitin
 * now if gusto mo lumipat ng scene, kailangan mo ng "stage" ( check footnote 1 )
 * pero nasa ibang java file ka eh so di mo access un
 * kaya kailangan mo pag-pasa pasahan
 * ( footnote 2 ) ginagawa neto is binibigay mo yung stage sa controller na un
 * ( footnote 1 ) para sa next setScene(), yung fxml & controller nya na yung lalabas
 * check Menu.java for example
 */

public class Main extends Application {
    public static Account account = new Account(null,null);
    public Account getAccount(){
        return account;
    }
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader loader = new FXMLLoader(Main.class.getResource("register.fxml"));
        Parent root = loader.load();

        Register register = loader.getController();
        register.setMainStage(stage); // 2

/*
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("people.fxml"));
        Parent root = loader.load();

        People register = loader.getController();
        register.setMainStage(stage); // 2 */

        Scene scene = new Scene(root);
        stage.setTitle("Money M8 (A Payroll Calculator)");
        stage.setScene(scene); // eto footnote 1
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
