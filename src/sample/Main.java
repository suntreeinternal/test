package sample;


import CurrentPatienInfo.Patient;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import login.sqlServerCom;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Main extends Application {
    public static Stage loginStage;
    public static Stage mainStage;
    public static Stage demoStage;
    public static sqlServerCom ServerInfo;
    public static Stage patientSearch;
    public static Patient currentPatientInfo;
    public static String currentEncounterID;
    public static LinkedList<encounterData> currentEncounterData;
    public static boolean isBilling = false;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = new Stage();
        this.loginStage = new Stage();
        this.patientSearch = new Stage();
        this.demoStage = new Stage();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        FXMLLoader MainLoader = new FXMLLoader();
        MainLoader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent MainStageRoot = MainLoader.load();
        Scene MainScene = new Scene(MainStageRoot);
        this.mainStage.setScene(MainScene);
        this.mainStage.setMaximized(true);
        this.mainStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.loginStage.initOwner(this.mainStage);
        this.loginStage.initModality(Modality.WINDOW_MODAL);
        this.loginStage.setScene(scene);
        this.loginStage.show();

        this.loginStage.setOnCloseRequest(we -> System.exit(0));

        FXMLLoader chartLoader = new FXMLLoader();
        chartLoader.setLocation(getClass().getResource("PatientList.fxml"));
        Parent chartRoot = chartLoader.load();
        Scene chartScene = new Scene(chartRoot);
        this.patientSearch.initOwner(this.mainStage);
        this.patientSearch.initModality(Modality.WINDOW_MODAL);
        this.patientSearch.setScene(chartScene);
        this.patientSearch.hide();
    }



    @Override
    public void stop(){
        System.out.println("Exiting");
    }
}
