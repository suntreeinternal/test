package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import login.sqlServerCom;

import java.net.URL;
import java.util.ResourceBundle;


public class Login extends AnchorPane implements Initializable {

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private Label error;

    @FXML
    private RadioButton billing;

    @FXML
    private RadioButton transcription;
    final ToggleGroup tg = new ToggleGroup();


    @FXML
    public void exitAplication(ActionEvent event){
        Platform.exit();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        billing.setSelected(true);
        billing.setToggleGroup(tg);
        transcription.setToggleGroup(tg);
    }

    @FXML
    protected void logInUser(ActionEvent event) {
        String userName = user.getText();
        String password = pass.getText();
        System.out.println(password);
        Main.ServerInfo = new sqlServerCom(userName, password);
        if (Main.ServerInfo.isConnected()){
            Main.loginStage.hide();
        } else {
            pass.clear();
            error.setText("Username or password is incorrect.");
        }

        if (billing.isSelected()) {
            Main.isBilling = true;
            MainPageConfig.onBilling();
        } else {
            Main.isBilling = false;
        }
    }
}
