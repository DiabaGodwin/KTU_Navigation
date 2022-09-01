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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.FieldPosition;
import java.util.FormatterClosedException;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentDashboard implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnadministration;

    @FXML
    private Button btnClinic;

    @FXML
    private Button btnRadio;

    @FXML
    private Button btnCanteen;

    @FXML
    private Button btnBank;

    @FXML
    private Button btnCCB;

    @FXML
    private Button btnFBMS;

    @FXML
    private Button btnCompssa;

    @FXML
    private Button btnFOE;

    @FXML
    private AnchorPane administrationPnl;

    @FXML
    private AnchorPane clinicPnl;

    @FXML
    private AnchorPane canteenPnl;

    @FXML
    private AnchorPane bankPnl;

    @FXML
    private AnchorPane CCBPnl;

    @FXML
    private AnchorPane FOEPnl;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == btnadministration){
            administrationPnl.toFront();
        }
        else if(event.getSource() == btnClinic){
            clinicPnl.toFront();
        }
        else  if(event.getSource() == btnCanteen){
            canteenPnl.toFront();
        }
        else if(event.getSource()==btnCCB){
            CCBPnl.toFront();
        }else
            if(event.getSource() == btnBank){
                bankPnl.toFront();
            }else
                if(event.getSource() == btnFOE){
                    FOEPnl.toFront();
                }


    }




    public void onClickBack(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("studentLoginPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene =new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
