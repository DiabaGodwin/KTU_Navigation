package com.network2c.ktunavigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;




public class AdminDashboard implements Initializable {
    @FXML
    private AnchorPane getCodinatePage;

    @FXML
    private AnchorPane addLocationPage;

    @FXML
    private AnchorPane studentTablePage;

    @FXML
    private Button getCordinate;

    @FXML
    private Button addLocation;

    @FXML
    private Button studentTable;

    @FXML
    private Button visitorsTable;


    @FXML
    private StackPane contentArea;




    private Stage stage;
    private Scene scene;
    private Parent root;




    public void backToLogin(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visitorLoginPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == addLocation){
            addLocationPage.toFront();
        }
        else
        if(event.getSource() == studentTable){
            studentTablePage.toFront();
        }
        else  if(event.getSource() == getCordinate){
            getCodinatePage.toFront();

        }
    }
}
