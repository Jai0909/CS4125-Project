package com.kiss.carrentalsystem;
import java.sql.*;
import javafx.scene.control.Alert;
public class login {
    private Connection conn=null;
    private Statement stmt=null;

    public void initialize(){
        initializeDB();
    }

    private void initializeDB(){
        final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; //replace w our driver
        final String DB_URL="jdbc:mysql://localhost:3306";
        String EMAIL="";
        String PASSWORD="";

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, "email", "password"); //did you use email and password as table headers?
            stmt = conn.createStatement();

            String query = "SELECT * email, password FROM Account"; // add example@gmail.com to db to test
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                EMAIL = resultSet.getString("email");
                PASSWORD = resultSet.getString("password");
            }

            System.out.println("Successfully connected to the database!");
            System.out.println("Email: " + EMAIL);
            System.out.println("Password: " + PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}