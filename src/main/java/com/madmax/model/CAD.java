package com.madmax.model;
//import org.apache.spark.sql.Dataset;
import java.sql.*;
import java.util.ArrayList;

public class CAD {

    public String getRows(String rSQL, String ResultSetName) {
         String data = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/madmax?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(rSQL);
            rs.next();
            data = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
        return data ;
    }

    public void actionRows(String rqSQL){

    }
}
