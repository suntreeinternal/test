package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MainPageConfig {
    @FXML
    Pane MainPane;
    @FXML
    MenuBar menuBar;
    @FXML
    private static TextArea billing;
    @FXML
    private static TitledPane Subjective;
    @FXML
    private static TitledPane Objective;
    @FXML
    private static TitledPane Assessment;
    @FXML
    private static TitledPane Plan;
    @FXML
    private static TitledPane Medication;
    @FXML
    private static TitledPane FollowUp;

    @FXML
    private static Accordion EncounterAccordion = new Accordion();
    @FXML
    private static TextArea subjective = new TextArea();
    @FXML
    private static TextArea objective = new TextArea();
    @FXML
    private static TextArea assessment = new TextArea();
    @FXML
    private static TextArea plan = new TextArea();
    @FXML
    private static TextArea medication = new TextArea();
    @FXML
    private static TextArea fu = new TextArea();

    @FXML
    private static AnchorPane BillingSubjective = new AnchorPane();

    @FXML
    private static VBox SubjectiveBox = new VBox();
    @FXML
    private static VBox ObjectiveBox = new VBox();
    @FXML
    private static VBox AssessmentBox = new VBox();
    @FXML
    private static VBox PlanBox = new VBox();
    @FXML
    private static VBox MedicationBox = new VBox();
    @FXML
    private static VBox FUBox = new VBox();
    @FXML
    private static Label Name = new Label();
    @FXML
    private static Label dob = new Label();
    @FXML
    private static ComboBox<String> encounters = new ComboBox<>();
    @FXML
    private static Button demo = new Button("Demographics");
    @FXML
    private static Button vitals = new Button("Vitals");
    @FXML
    private static Button newEncounter = new Button("New Encounter");



    @FXML
    private void initialize() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        menuBar.setPrefWidth(screen.getWidth());
        System.out.println(MainPane.getPrefHeight());
        Subjective = new TitledPane("Subjective", SubjectiveBox);
        Objective = new TitledPane("Objective", ObjectiveBox);
        Assessment = new TitledPane("Assessment", AssessmentBox);
        Plan = new TitledPane("Plan", PlanBox);
        Medication = new TitledPane("Medication", MedicationBox);
        FollowUp = new TitledPane("Follow Up", FUBox);
        billing = new TextArea();

        MainPane.getChildren().add(EncounterAccordion);

        EncounterAccordion.getPanes().add(Subjective);
        EncounterAccordion.getPanes().add(Objective);
        EncounterAccordion.getPanes().add(Assessment);
        EncounterAccordion.getPanes().add(Plan);
        EncounterAccordion.getPanes().add(Medication);
        EncounterAccordion.getPanes().add(FollowUp);

        EncounterAccordion.setPrefWidth(screen.getWidth() - 50);
        EncounterAccordion.setPrefHeight(700);
        EncounterAccordion.setLayoutX(25);
        EncounterAccordion.setLayoutY(85);
        EncounterAccordion.setVisible(true);

        SubjectiveBox.getChildren().add(subjective);
        ObjectiveBox.getChildren().add(objective);
        AssessmentBox.getChildren().add(assessment);
        PlanBox.getChildren().add(plan);
        MedicationBox.getChildren().add(medication);
        FUBox.getChildren().add(fu);


        SubjectiveBox.setPrefHeight(600);
        ObjectiveBox.setPrefHeight(600);
        AssessmentBox.setPrefHeight(600);
        PlanBox.setPrefHeight(600);
        MedicationBox.setPrefHeight(600);
        FUBox.setPrefHeight(600);


        subjective.setWrapText(true);
        objective.setWrapText(true);
        assessment.setWrapText(true);
        plan.setWrapText(true);
        medication.setWrapText(true);
        fu.setWrapText(true);

        subjective.setFont(Font.font("Courier New", 12));
        objective.setFont(Font.font("Courier New", 12));
        assessment.setFont(Font.font("Courier New", 12));
        plan.setFont(Font.font("Courier New", 12));
        medication.setFont(Font.font("Courier New", 12));
        fu.setFont(Font.font("Courier New", 12));


        MainPane.getChildren().add(Name);
        Name.setLayoutX(25);
        Name.setLayoutY(35);
        Name.setPrefHeight(40);
        Name.setFont(Font.font("Arial", 26));
        MainPane.getChildren().add(dob);
        dob.setPrefHeight(40);
        dob.setLayoutY(35);
        dob.setLayoutX(425);
        dob.setFont(Font.font("Arial", 26));
        MainPane.getChildren().add(encounters);
        encounters.setLayoutX(dob.getLayoutX() + 200);
        encounters.setLayoutY(35);
        encounters.setPrefHeight(40);
        encounters.setPrefWidth(130);

        MainPane.getChildren().add(demo);
        demo.setLayoutX(encounters.getLayoutX() + encounters.getPrefWidth() + 40);
        demo.setLayoutY(encounters.getLayoutY());
        demo.setPrefSize(100, 40);
        demo.setOnMouseClicked(this::onSelect);

        MainPane.getChildren().add(vitals);
        vitals.setLayoutX(demo.getLayoutX() + demo.getPrefWidth() + 40);
        vitals.setLayoutY(demo.getLayoutY());
        vitals.setPrefSize(100, 40);
        vitals.setOnMouseClicked(this::vitalSelect);

        MainPane.getChildren().add(newEncounter);
        newEncounter.setLayoutX(vitals.getLayoutX() + vitals.getPrefWidth() + 40);
        newEncounter.setLayoutY(vitals.getLayoutY());
        newEncounter.setPrefSize(100, 40);
        newEncounter.setOnMouseClicked(this::onNewEncounter);


        subjective.setOnKeyPressed(this::onSubjectiveSpace);
        objective.setOnKeyPressed(this::onSubjectiveSpace);
        assessment.setOnKeyPressed(this::onAssessmentSpace);
        fu.setOnKeyPressed(this::onFuSpace);
        medication.setOnKeyPressed(this::onMedicationSpace);
        plan.setOnKeyPressed(this::onPlanSpace);
        MainPane.setOnKeyPressed(this::onControl);

        subjective.setPrefHeight(600);
        objective.setPrefHeight(600);
        assessment.setPrefHeight(600);
        fu.setPrefHeight(600);
        medication.setPrefHeight(600);
        plan.setPrefHeight(600);

        encounters.setOnAction(this::onEncounterSelect);
        MainPane.getChildren().add(billing);
        billing.setVisible(false);


    }

    @FXML
    Menu patients;

    private void onVitals(MouseEvent actionEvent){

    }

    private void onNewEncounter(MouseEvent mouseEvent){

    }

    public static void onBilling(){
        EncounterAccordion.setVisible(false);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screen.toString());
        billing.setPrefSize(screen.width-50, screen.height-180);
        billing.setLayoutX(25);
        billing.setLayoutY(85);
        billing.setVisible(true);
        subjective.setWrapText(true);
        BillingSubjective.setVisible(true);

    }

    private void onSelect(MouseEvent actionEvent){
        try {
            Main.demoStage = new Stage();
            FXMLLoader Demo = new FXMLLoader();
            Demo.setLocation(getClass().getResource("Demographics.fxml"));
            Parent demoRoot = Demo.load();
            Scene demoScene = new Scene(demoRoot);
            Main.demoStage.initOwner(Main.mainStage);
            Main.demoStage.initModality(Modality.WINDOW_MODAL);
            Main.demoStage.setScene(demoScene);
            Main.demoStage.show();
        } catch (Exception e){

        }
        System.out.println(actionEvent.toString());
    }

    private void vitalSelect(MouseEvent actionEvent){
        try {
            Main.demoStage = new Stage();
            FXMLLoader Demo = new FXMLLoader();
            Demo.setLocation(getClass().getResource("vitals.fxml"));
            Parent demoRoot = Demo.load();
            Scene demoScene = new Scene(demoRoot);
            Main.demoStage.initOwner(Main.mainStage);
            Main.demoStage.initModality(Modality.WINDOW_MODAL);
            Main.demoStage.setScene(demoScene);
            Main.demoStage.show();
        } catch (Exception e){

        }
        System.out.println(actionEvent.toString());
    }

    @FXML
    private void onChartRack(ActionEvent actionEvent){
        Main.patientSearch.show();
    }

    @FXML
    private void onAddPatient(ActionEvent actionEvent){

    }

    @FXML
    private void onLeftClick(MouseEvent mouseEvent){
        System.out.println(mouseEvent);
    }


    private void onAssessmentSpace(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.SPACE){
            String wholeText = assessment.getText();
            wholeText =onSpace("Assessment", wholeText, assessment.getCaretPosition()-1);
            assessment.setText(wholeText);
        }
    }
    private void onFuSpace(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.SPACE){
            String wholeText = fu.getText();
            wholeText =onSpace("fu", wholeText, fu.getCaretPosition()-1);
            fu.setText(wholeText);
        }
    }
    private void onPlanSpace(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.SPACE){
            String wholeText = plan.getText();
            wholeText =onSpace("plan", wholeText, plan.getCaretPosition()-1);
            plan.setText(wholeText);
        }
    }
    private void onMedicationSpace(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.SPACE){
            String wholeText = medication.getText();
            wholeText =onSpace("medication", wholeText, medication.getCaretPosition()-1);
            medication.setText(wholeText);
        }
    }
    private void onSubjectiveSpace(KeyEvent keyEvent){

//        System.out.println(subjective.getCaretPosition());
        if (keyEvent.getCode() == KeyCode.SPACE){
            System.out.println(subjective.getText());

            String wholeText = subjective.getText();
            wholeText = onSpace("Subjective", wholeText, subjective.getCaretPosition()-1);
            subjective.setText(wholeText);

        }

    }
    private static String onSpace (String section, String content, int pos){

        char[] charArr = content.toCharArray();

        int index = pos;
        System.out.println(index);

        ArrayList<Character> string = new ArrayList<>();

        //getting sub string
        while (charArr[index] != ' '){
            if (index == 0){
                break;
            }
            System.out.println(content.charAt(index));
            string.add(0, content.charAt(index));

            index--;
        }

        System.out.println(string.toString());

        int start = index;
        System.out.println(content.charAt(index));

        String spaceString = "";

        while (!string.isEmpty()){
            spaceString = spaceString + string.remove(0);
        }

        String toBeInserted = "";

        if(section.equals("Subjective")) {
            toBeInserted = Main.ServerInfo.getMacroForSubjective(spaceString);
        } else if (section.equals("fu")){
            toBeInserted = Main.ServerInfo.getMacroForFu(spaceString);
        } else if (section.equals("Assessment")){
            toBeInserted = Main.ServerInfo.getMacroForAssessment(spaceString);
        } else if (section.equals("plan")){
            toBeInserted = Main.ServerInfo.getMacroForPlan(spaceString);
        } else if (section.equals("medication")){
            toBeInserted = Main.ServerInfo.getMacroForMedication(spaceString);
        }

        if (toBeInserted.equals("")){
            toBeInserted = spaceString;
        }

        String first = content.substring(0, start);
        System.out.println(first);
        System.out.println(" ");
        System.out.println(string.size());
        int val = index + string.size() +1;
        String last = content.substring(val);

        System.out.println(val + "         " + last);
        System.out.println(" ");

        String toBeUsed = first + " " + toBeInserted + last;
        System.out.println(toBeUsed);
        return toBeUsed;
    }

    @FXML
    private void onFkey(KeyEvent keyEvent){
        if (keyEvent.getCode().isFunctionKey()){
            System.out.println(keyEvent.toString());
        }
    }

    public static void patientInfo(){
        Name.setText(Main.currentPatientInfo.getFullName());
        dob.setText(Main.currentPatientInfo.getDob());
        Main.ServerInfo.getEncounters(Main.currentPatientInfo.getId());
        String[] encounterDates = new String[Main.currentEncounterData.size()];
        for (int i = 0; i <encounterDates.length; i++){
            String temp = Main.currentEncounterData.get(i).date;
            String toSave = temp.substring(5,7) + "/" + temp.substring(8, 10) + "/" + temp.substring(0, 4);
            System.out.println(temp);
            encounterDates[i] = toSave;
        }
        encounters.setItems(FXCollections.observableArrayList(encounterDates));
        SelectEncounter(0);
    }

    private void onControl(KeyEvent keyEvent){
        if(keyEvent.getCode() == KeyCode.S && keyEvent.isControlDown())
            Subjective.setExpanded(true);
        else if(keyEvent.getCode() == KeyCode.O && keyEvent.isControlDown())
            Objective.setExpanded(true);
        else if(keyEvent.getCode() == KeyCode.A && keyEvent.isControlDown())
            Assessment.setExpanded(true);
        else if(keyEvent.getCode() == KeyCode.P && keyEvent.isControlDown())
            Plan.setExpanded(true);
        else if(keyEvent.getCode() == KeyCode.M && keyEvent.isControlDown())
            Medication.setExpanded(true);
        else if(keyEvent.getCode() == KeyCode.F && keyEvent.isControlDown())
            FollowUp.setExpanded(true);

    }



    private void onEncounterSelect(ActionEvent mouseEvent){
        int index = encounters.getSelectionModel().getSelectedIndex();
        SelectEncounter(index);
    }

    private static void SelectEncounter(int index){
        if (index != -1) {
            if (!Main.isBilling) {
                subjective.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 100)));
                objective.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 101)));
                assessment.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 102)));
                plan.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 103)));
                medication.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 104)));
                fu.setText(EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 105)));
            } else {
                TextFlow flow = new TextFlow();

                String toSubjective = "<b>Subjective:</b> \n" + EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 100)) +
                        "\n\nObjective:\n"  + (EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 101)))
                        + "\n\nAssessment:\n" + (EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 102)))
                        + "\n\nPlan:\n" + (EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 103)))
                        + "\n\nMedication:\n" + (EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 104)))
                        + "\n\nFollow Up:\n" + (EditText.text(Main.ServerInfo.getEncounterParts(Main.currentEncounterData.get(index).id, 105))) ;

                billing.setText(toSubjective);
            }
        }
    }
}