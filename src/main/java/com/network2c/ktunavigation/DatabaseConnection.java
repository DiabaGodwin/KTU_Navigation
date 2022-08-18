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

//public class DatabaseConnection {
//    public  Connection databaseLink;
//    @FXML
//    private Label lblNotice;
//
//    @FXML
//    private TextField txtName;
//
//    @FXML
//    private Button btnContinue;
//
//    @FXML
//    private TextField txtIndex;
//
//    Connection connection;
//    PreparedStatement pst;
//
//    @FXML
//    void onClickContinue(ActionEvent event) throws ClassNotFoundException, SQLException {
//
//        String name = btnContinue.getText();
//        String index = txtIndex.getText();
//        Class.forName("com.mysql.jdbc.Driver");
//        connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "0558894119");
//        pst = connection.prepareStatement("INSERT INTO `student`.`studentinfo` (`studentID`, `name`, `program`) VALUES (?,?,?)");
//
//        pst.setString(1, name);
//        pst.setString(2, index);
//
//        int status = pst.executeUpdate();
//
//        if(status==1)
//        {
//            lblNotice.setText("Record Added");
//            txtIndex.setText("");
//            txtName.setText("");
//            txtIndex.requestFocus();
//        }
//        else {
//            lblNotice.setText("Failed");
//        }
//
//
//    }
//
//
//}