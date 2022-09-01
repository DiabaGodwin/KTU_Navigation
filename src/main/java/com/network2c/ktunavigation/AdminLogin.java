package com.network2c.ktunavigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class AdminLogin {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onClickBack(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtpass;


    public void onClickLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Connection connection;
        PreparedStatement pst;

        String name = txtName.getText();
        String password = txtpass.getText();
        String adminName = "";
        String adminPassword="";
        ResultSet resultSet = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/ktu_navigation", "root", "0558894119");
        pst = connection.prepareStatement("SELECT password from admin_details where name= ?");
        pst.setString(1,name);
        resultSet = pst.executeQuery();

        if(!resultSet.isBeforeFirst()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User not found");
            alert.show();
        }else {
            while (resultSet.next()){

                String dbPassword = resultSet.getString("password");
                if (dbPassword.equals(password)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Login Successful");
                    alert.show();

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminDashboard.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong credentials");
                    alert.show();
                }
            }
        }



    }
}
