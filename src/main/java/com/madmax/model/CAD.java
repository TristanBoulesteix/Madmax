package com.madmax.model;

import java.sql.*;

public class CAD {
    private static final CAD INSTANCE = new CAD();

    public static CAD getInstance() {
        return INSTANCE;
    }

    private CAD() {

    }

    String getRows(String rSQL, String ResultSetName) {
        String data = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/madmax?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(rSQL);
            while (rs.next()) {
                data = rs.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in CAD.java : " + e);
        } finally {
            if(con != null) try { con.close(); } catch (SQLException ignored) {}
        }
        return data;
    }

    public void actionRows(String rqSQL) {

    }
}
