package login;
import sample.Main;
import sample.encounterData;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class sqlServerCom {
    private String userName = "";
    private String password = "";
    private Connection sw_charts;
    private Connection sw_codes;
    private Connection sw_exchange;
    private Connection sw_images;
    private Connection sw_trans;
    private Connection sw_users;
    private boolean isConnected;

    public sqlServerCom(String userName, String password){
        this.isConnected = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.isConnected = true;
            this.sw_charts = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_charts", userName, password);
            this.sw_codes = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_codes", userName, password);
            this.sw_exchange = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_exchange", userName, password);
            this.sw_images = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_images", userName, password);
            this.sw_trans = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_trans", userName, password);
            this.sw_users = DriverManager.getConnection("jdbc:sqlserver://sunserver2:59564;databaseName=sw_users", userName, password);
        } catch (Exception e) {
            this.isConnected = false;
            System.err.println(e);
        }

    }

    public boolean isConnected(){
        return this.isConnected;
    }

    public ResultSet sw_charts_query(String query){
        try {
            Statement st = sw_charts.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e){
            return null;
        }
    }

    public void getEncounters(String patientID){
       Main.currentEncounterData = new LinkedList<>();
        ResultSet rs = sw_charts_query("SELECT * FROM dbo.Encounters WHERE Patient_ID='" + patientID + "' ORDER BY visit_date ASC");
        try {
            while (rs.next()) {
                String[] array = new String[2];

                Main.currentEncounterData.addFirst(new encounterData(rs.getString("visit_date"), rs.getString("EncountID")));
            }
        } catch (Exception e){

        }
    }

    public String getEncounterParts(String encounterID, int objectType){
        String query = "SELECT * FROM dbo.Encounter_Data WHERE EncountID='" + encounterID + "' AND Object_Type='" + objectType + "'";
        System.out.println(query);
        String toReturn = "";
        try {
            ResultSet rs = sw_charts_query(query);
            rs.next();
            toReturn = rs.getString("Object_Data");
            System.out.println(toReturn);
        } catch (Exception e){

        }
        return toReturn;
    }

    public String[] getPatientDemo(String id){
        String query = "SELECT * FROM dbo.Gen_Demo WHERE Patient_ID='" + id +"'";
        ResultSet rs = sw_charts_query(query);
        String[] toReturn = new String[11];
        try {
            rs.next();

            toReturn[0] = rs.getString("title");
            toReturn[1] = rs.getString("first_name");
            toReturn[2] = rs.getString("mid_init");
            toReturn[3] = rs.getString("last_name");
            toReturn[4] = rs.getString("suffix");
            toReturn[5] = rs.getString("SocialSec");
            toReturn[6] = rs.getString("ChartNumber");
            toReturn[7] = rs.getString("birthdate");
            toReturn[8] = "0";
            toReturn[9] = rs.getString("pri_physician_name");
            toReturn[10] = rs.getString("sex");

        } catch (Exception e){

        }


        return toReturn;
    }

    public String getMacroForSubjective(String macro){
        String toReturn = "";
        System.out.println(macro);
        String query = "SELECT * FROM dbo.Various WHERE Code='" + macro + "'";
//        System.out.println(this.sw_codes.isClosed());
        return getString(toReturn, query);
    }

    public String getMacroForFu(String macro){
        String toReturn = "";
        System.out.println(macro);
        String query = "SELECT * FROM dbo.FU WHERE Code='" + macro + "'";
//        System.out.println(this.sw_codes.isClosed());
        return getString(toReturn, query);
    }

    private String getString(String toReturn, String query) {
        try{
            Statement st = sw_codes.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            System.out.println(rs.getRow());
            toReturn = rs.getString("Text");
            System.out.println(query);
        } catch (Exception e){
            System.out.println(e);
            System.out.println(query);

        }
        return toReturn;
    }
    public String getMacroForAssessment(String macro){
        String toReturn = "";
        System.out.println(macro);
        String query = "SELECT * FROM dbo.Dx WHERE Code='" + macro + "'";
//        System.out.println(this.sw_codes.isClosed());
        return getString(toReturn, query);
    }
    public String getMacroForPlan(String macro){
        String toReturn = "";
        System.out.println(macro);
        String query = "SELECT * FROM dbo.Plan_List WHERE Code='" + macro + "'";
//        System.out.println(this.sw_codes.isClosed());
        return getString(toReturn, query);
    }
    public String getMacroForMedication(String macro){
        String toReturn = "";
        System.out.println(macro);
        String query = "SELECT * FROM dbo.Rx WHERE Code='" + macro + "'";
//        System.out.println(this.sw_codes.isClosed());
        return getString(toReturn, query);
    }
//    public String getMacroForSubjective(String macro){
//        String toReturn = "";
//        System.out.println(macro);
//        String query = "SELECT * FROM dbo.Various WHERE Code='" + macro + "'";
////        System.out.println(this.sw_codes.isClosed());
//        return getString(toReturn, query);
//    }

    public ResultSet getVitals(String encounterId){
        String query = "SELECT * FROM dbo.Vital_Groups WHERE Patient_ID='" + encounterId + "'";

        ResultSet rs = sw_charts_query(query);

        System.out.println("ASDf");

        return rs;

    }


        // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        sqlServerCom test = new sqlServerCom("test", "123321123");
        String testString = "SELECT * FROM dbo.Gen_Demo WHERE lastName='smith'";

    }
}
