package com.network2c.ktunavigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class VisitorLoginPage {

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
        private Label lblNotice;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtPhoneNumber;

        Connection connection;
        PreparedStatement pst;



        public void onClickContinue(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

            String name = txtName.getText();
            String phone = txtPhoneNumber.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ktu_navigation", "root", "0558894119");
            pst = connection.prepareStatement("INSERT INTO `ktu_navigation`.`visitors` (`name`, `phone`) VALUES (?, ?)");

            pst.setString(1, name);
            pst.setString(2, phone);

            int status = pst.executeUpdate();

            if (status == 1) {
                lblNotice.setText("Record Added");
                txtName.setText("");
                txtPhoneNumber.setText("");

            } else {
                lblNotice.setText("Failed");
            }


            Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visitorsDashboard.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

}
