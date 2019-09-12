package login;

import java.sql.ResultSet;

public class test {
    public static void main(String args[]){
        sqlServerCom testv1 = new sqlServerCom("test", "123321123");
        String testString = "SELECT * FROM dbo.Gen_Demo WHERE last_name='smith'";
        ResultSet abc = testv1.sw_charts_query(testString);
        try {
            while (abc.next()) {
                System.out.println(abc.getString("first_name"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
