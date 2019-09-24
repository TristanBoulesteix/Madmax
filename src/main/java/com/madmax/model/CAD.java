package com.madmax.model;
import java.sql.*;

public class CAD {

        public void connect() {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost/phpmyadmin/db_structure.php?server=1&db=madmax","root","");

                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from utilisateur");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2));
                con.close();
            }catch(Exception e){ System.out.println("ERROR"+ e);}
        }

/* http://localhost/phpmyadmin/db_structure.php?server=1&db=madmax
    public DataSet getRows(String rSQL, String ResultSetName){

        return Dataset data;
    }

    public void actionRows(String rqSQL){

    } */
}
