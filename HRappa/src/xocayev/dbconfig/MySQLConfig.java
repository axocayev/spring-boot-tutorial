package xocayev.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    private Connection conn = null;

    public Connection getConnect() {

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected...");

        } catch (Exception e) {
            System.out.println("Error during connection...");
            System.out.println(e);
        }


        return conn;
    }

    public void close(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
