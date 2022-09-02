package com.network2c.ktunavigation;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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
    private AnchorPane visitorsTablePage;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField txtLocName;

    @FXML
    private TextField txtLat;

    @FXML
    private Button save;

    @FXML
    private TextField txtLong;



    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminLogin.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onClickSave(ActionEvent event) throws ClassNotFoundException, SQLException {

        Connection connection;
        PreparedStatement pst;

        String Locname = txtLocName.getText();
        String lat = txtLat.getText();
        String longitude = txtLong.getText();

        if (txtLocName.getText().isEmpty() | txtLat.getText().isEmpty() | txtLong.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("All field required");
            alert.setTitle("Information Dialog");
            alert.showAndWait();

        } else {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ktu_navigation", "root", "0558894119");
            pst = connection.prepareStatement("INSERT INTO `ktu_navigation`.`locations` (`Name`, `Lat`, `Long`) VALUES (?, ?, ?)");

            pst.setString(1, Locname);
            pst.setString(2, lat);
            pst.setString(3, longitude);

            int status = pst.executeUpdate();
            txtLocName.setText("");
            txtLong.setText("");
            txtLat.setText("");
        }

    }






























    //this section belongs to the tableview for visitors



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));
    }

    @FXML
    void handleClick(ActionEvent event) {
        if (event.getSource() == addLocation) {
            addLocationPage.toFront();
        } else if (event.getSource() == studentTable) {
            studentTablePage.toFront();
        } else if (event.getSource() == getCordinate) {
            getCodinatePage.toFront();

        } else if (event.getSource() == visitorsTable) {
            visitorsTablePage.toFront();
        }
    }


    @FXML
    private TableView<StudentTable> tblViewStudent;

    @FXML
    private TableColumn<StudentTable, String> idCol;

    @FXML
    private TableColumn<StudentTable, String> nameCol;

    @FXML
    private TableColumn<StudentTable, String> indexCol;


    ObservableList<StudentTable> studentList = FXCollections.observableArrayList();
    private ResultSet resultSet;


    public void loadStudentTable(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection connection;
        PreparedStatement pst;

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/ktu_navigation", "root", "0558894119");
        resultSet = (ResultSet) connection.createStatement().executeQuery("SELECT * FROM ktu_navigation.student");
        while (resultSet.next()){

        }



    }






















    public void loadVisitorsTable(ActionEvent event) {
        DatabaseConnection con = new DatabaseConnection();


    }

}