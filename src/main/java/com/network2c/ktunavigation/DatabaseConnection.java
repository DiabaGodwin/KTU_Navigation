package com.network2c.ktunavigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {


    Connection connection;
    PreparedStatement pst;

     public  void getConnection( String query) throws ClassNotFoundException, SQLException {


         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "0558894119");
         pst = connection.prepareStatement(query);

//         return pst.executeUpdate();


     }




}