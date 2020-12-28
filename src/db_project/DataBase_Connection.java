package db_project;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase_Connection {

     private Connection con;
   

    public DataBase_Connection()  {
        

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String Server = "localhost";
            int port = 1433;
            String user = "DESKTOP-5VI5EQ5\\SQLEXPRESS";
            String password = "";
            String database = "DB_PROJECT";

            con = DriverManager.getConnection("jdbc:sqlserver://" + Server + ":" + port
                    + ";user=" + user + ";databasename=" + database + ";integratedSecurity=true");

           

        } catch (Exception e) {
            System.out.println(e);
        }

    }

        public  java.sql.Statement getStatement() throws SQLException {

        return con.createStatement();
    }
    
}
