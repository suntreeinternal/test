package sample;

import CurrentPatienInfo.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;

public class PatientConfig {


    @FXML
    TextField lastName;

    @FXML
    TextField firstName;


    @FXML
    TableView<patientList> PatientTable;


    @FXML
    TableColumn<patientList, String> first;
    @FXML
    TableColumn<patientList, String> last;
    @FXML
    TableColumn<patientList, String> dob;

    ObservableList<patientList> testList;

    @FXML
    private void initialize(){
        first.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        last.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        dob.setCellValueFactory(new PropertyValueFactory<>("patientDob"));

    }

    private ObservableList<patientList> getList(String first, String last, String dob, String id) {

        patientList user1 = new patientList(first, last, dob, id);

        ObservableList<patientList> list = FXCollections.observableArrayList(user1);
        return list;
    }

    @FXML
    private void onTyping(KeyEvent actionEvent){
        System.out.println(lastName.getText());
        if (lastName.getText().length() > 1){
            String query = "SELECT * FROM dbo.Gen_Demo WHERE last_name LIKE '%" + lastName.getText() + "%' AND first_name LIKE '%" + firstName.getText() + "%'";
            System.out.println(query);
            ResultSet rs = Main.ServerInfo.sw_charts_query(query);
            try {
                testList = FXCollections.observableArrayList();
                while (rs.next()) {
                    testList.addAll(new patientList(rs.getString("first_name"), rs.getString("last_name"), dateChange(rs.getString("birthdate")), rs.getString("Patient_ID")));
                    System.out.println(rs.getString("first_name"));
                }
                PatientTable.setItems(testList);
            } catch (Exception e){
                System.err.println(e);
            }
        }


    }

    private static String dateChange(String date){
       String toReturn = "" + date.charAt(4) + date.charAt(5) + "-" + date.charAt(6) + date.charAt(7) + "-" + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
        return toReturn;

    }

    @FXML
    private void onSelect(MouseEvent e){
        System.out.println(e);
        int selectedIndex = PatientTable.getSelectionModel().getSelectedIndex();

        Main.currentPatientInfo = new Patient(testList.get(selectedIndex).getFirstName(), testList.get(selectedIndex).getLastName(), testList.get(selectedIndex).getPatientDob(), testList.get(selectedIndex).getId());
        System.out.println(testList.get(0).getId());

        MainPageConfig.patientInfo();
        Main.patientSearch.hide();
    }
}
