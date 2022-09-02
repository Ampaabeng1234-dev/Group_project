package com.example.group_project.Controllers;

import com.example.group_project.DB.DBConnection;
import com.example.group_project.Startapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController  implements Initializable {

    @FXML
    private TextField Email;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_submit;

    @FXML
    private ComboBox<String> Gender;

    @FXML
    private TextField Program;

    @FXML
    private TextField address;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField lastname_del;

    @FXML
    private TextField phone_no;

    @FXML
    private TextField year;

    @FXML
    void Delet(ActionEvent event) throws Exception {
        String first_name= lastname_del.getText();

        DBConnection del=new DBConnection();
        if(del.Delete(first_name)==1){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            lastname_del.clear();
        }

    }

    @FXML
    void Submit(ActionEvent event) throws Exception {
        String Firstname=firstname.getText();
        String Lastname=lastname.getText();
        String gender=Gender.getValue();
        String email=Email.getText();
        String program=Program.getText();
        String Year=year.getText();
        String Phone_NO=phone_no.getText();
        String Address=address.getText();

        DBConnection submitStudent=new DBConnection();
        if(submitStudent.SubmitStudent(Firstname,Lastname, gender, email, program,Year,Phone_NO,Address)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submitted successfully");
            alert.setHeaderText(null);
            alert.showAndWait();

            firstname.clear();
            lastname.clear();
            Gender.cancelEdit();
            Email.clear();
            year.clear();
            phone_no.clear();
            Program.clear();
            address.clear();

            Stage stage=(Stage) btn_submit.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Mainpage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Library Management System");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void btn_backshow(ActionEvent event) throws IOException {
        Stage stage=(Stage) btn_back.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Mainpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Gender.getItems().addAll("Male","Female");
    }

}

