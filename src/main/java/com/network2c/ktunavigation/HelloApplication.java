package com.network2c.ktunavigation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader landingPage = new FXMLLoader(HelloApplication.class.getResource("landingPage.fxml"));
        Scene page1 = new Scene(landingPage.load(), 600, 800);
        stage.setScene(page1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}