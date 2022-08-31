package com.network2c.ktunavigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

public class StudentLoginPage {
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


    public Connection databaseLink;
    @FXML
    private Label lblNotice;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnContinue;

    @FXML
    private TextField txtIndex;

    Connection connection;
    PreparedStatement pst;

    private boolean validation() {
        if(txtName.getText().isEmpty() | txtIndex.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("All field required");
            alert.showAndWait();

            return  false;
        }
        return true;
    }

    @FXML
    void onClickContinue(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        String name = txtName.getText();
        String index = txtIndex.getText();

        if(validation()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ktu_navigation", "root", "0558894119");
            pst = connection.prepareStatement("INSERT INTO `ktu_navigation`.`student` (`name`, `index`) VALUES (?, ?)");


            pst.setString(1, name);
            pst.setString(2, index);


            int status = pst.executeUpdate();

            if (status == 1) {
                lblNotice.setText("Record Added");
                txtIndex.setText("");
                txtName.setText("");
            } else {
                lblNotice.setText("Failed");
            }


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentDashboard.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
