module com.network2c.ktunavigation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.network2c.ktunavigation to javafx.fxml;
    exports com.network2c.ktunavigation;
}