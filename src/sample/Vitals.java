package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Vitals implements Initializable {
    @FXML
    TableView Table;

    private static LinkedList<VitalData> vd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Table.setEditable(true);

        TableColumn date = new TableColumn("thisDATE");
        date.setCellValueFactory(new PropertyValueFactory<VitalData,String>("bp"));
        Table.getColumns().addAll(date);
        getData();


    }

    public static void getData(){
        System.out.println("FASDFASDFSADFSDFAAFDSFSDFDSFASDFASDFASDFasdf");
        vd = new LinkedList<>();

        ResultSet rs = Main.ServerInfo.getVitals(Main.currentPatientInfo.getId());
        try {
            while (rs.next()) {
                String GroupID = rs.getString("Group_ID");
                String getVitalGroups = "SELECT * FROM dbo.Vital_Values WHERE Group_ID='" + GroupID + "'";
                ResultSet resultSet = Main.ServerInfo.sw_charts_query(getVitalGroups);
                VitalData vitalData = new VitalData();
                while (resultSet.next()){
                    String data1 = resultSet.getString("Reading_Data");
                    String data2 = resultSet.getString("Reading_Data2");

                    if (resultSet.getString("Reading_Type").equals("8")){
                        vitalData.setOralTemp(data1);
                    } else if (resultSet.getString("Reading_Type").equals("5")){
                        vitalData.setBp(data1 + "/" + data2);
                    } else if (resultSet.getString("Reading_Type").equals("4")){
                        vitalData.setBp(data1 + "lbs " + data2 + "oz");
                    }
                }
                vd.addFirst(vitalData);
            }
            System.out.println(rs.toString());
        } catch (Exception e){

        }


    }
}
