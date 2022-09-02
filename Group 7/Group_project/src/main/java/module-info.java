module com.example.group_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    exports com.example.group_project.Controllers;
    opens com.example.group_project.Controllers to javafx.fxml;
    exports com.example.group_project;
    opens com.example.group_project to javafx.fxml;
}