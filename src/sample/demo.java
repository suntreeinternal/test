package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import java.net.URL;
import java.util.ResourceBundle;

public class demo implements Initializable {

    private static TextField title = new TextField();
    private static TextField firstName = new TextField();
    private static TextField middleI = new TextField();
    private static TextField lastName = new TextField();
    private static TextField sufix = new TextField();
    private static DatePicker bDay = new DatePicker();
    private static TextField age = new TextField();
    private static RadioButton male = new RadioButton("Male");
    private static RadioButton female = new RadioButton("Female");

    @FXML
    private AnchorPane MainPane;
    @FXML
    private Button Ok;
    @FXML
    private Button Cancel;





    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        MainPane.getChildren().add(title);
        MainPane.getChildren().add(lastName);
        MainPane.getChildren().add(firstName);
        MainPane.getChildren().add(middleI);
        MainPane.getChildren().add(sufix);
        MainPane.getChildren().add(bDay);
        MainPane.getChildren().add(age);
        MainPane.getChildren().add(female);
        MainPane.getChildren().add(male);

        title.setPrefSize(67,25);
        title.setLayoutX(12);
        title.setLayoutY(30);

        lastName.setPrefSize(150,25);
        lastName.setLayoutX(292);
        lastName.setLayoutY(30);

        firstName.setPrefSize(151,25);
        firstName.setLayoutX(90);
        firstName.setLayoutY(30);

        middleI.setPrefSize(33,25);
        middleI.setLayoutX(250);
        middleI.setLayoutY(30);

        sufix.setPrefSize(135,25);
        sufix.setLayoutX(452);
        sufix.setLayoutY(30);


        bDay.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        bDay.setLayoutX(197);
        bDay.setLayoutY(94);

        age.setPrefSize(40,25);
        age.setLayoutX(381);
        age.setLayoutY(94);

        male.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        male.setLayoutX(14);
        male.setLayoutY(139);


        female.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        female.setLayoutX(73);
        female.setLayoutY(139);


        this.Cancel.setOnAction(this::onCancel);

        loadPatientData();

    }


    private static void loadPatientData(){
        String[] demographics = Main.ServerInfo.getPatientDemo(Main.currentPatientInfo.getId());
        title.setText(demographics[0]);
        firstName.setText(demographics[1]);
        middleI.setText(demographics[2]);
        lastName.setText(demographics[3]);
        sufix.setText(demographics[4]);
        age.setText(demographics[8]);
        if (demographics[10].equals("M")){
            male.setSelected(true);
            female.setSelected(false);
        } else {
            male.setSelected(false);
            female.setSelected(true);
        }

    }

    @FXML
    private void onCancel(ActionEvent eventHandler){
        Main.demoStage.close();
    }




}
