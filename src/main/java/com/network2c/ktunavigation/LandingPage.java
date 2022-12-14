package com.network2c.ktunavigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LandingPage {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToStudentLogin(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentLoginPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToVisitorLogin(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("visitorLoginPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void onClickAdmin(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminLogin.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
