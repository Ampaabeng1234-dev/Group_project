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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

        @FXML
        private PasswordField Password;

        @FXML
        private AnchorPane Signup_pane;

        @FXML
        private TextField Txt_email;

        @FXML
        private TextField Txt_fname;


        @FXML
        private TextField Txt_lname;

        @FXML
        private TextField Txt_location;

        @FXML
        private Button btn_cancel_password;

        @FXML
        private PasswordField Txt_password;


        @FXML
        private TextField Txt_username;

        @FXML
        private TextField Txt_forget;

        @FXML
        private Button btn_cancel;

        @FXML
        private Button btn_login;

    @FXML
    private AnchorPane pane_Forget;

        @FXML
        private AnchorPane login_pane;



        @FXML
        void Signup(ActionEvent event) {
           login_pane.setVisible(false);
           Signup_pane.setVisible(true);
           pane_Forget.setVisible(false);
        }

        @FXML
        void account(ActionEvent event) {
           login_pane.setVisible(true);
           Signup_pane.setVisible(false);
           pane_Forget.setVisible(false);
        }



        @FXML
        void btn_cancelShow(ActionEvent event) {
             Stage stage=(Stage) btn_cancel.getScene().getWindow();
             stage.close();
        }
        @FXML
        void Forget_password(ActionEvent event) {
                login_pane.setVisible(false);
                Signup_pane.setVisible(false);


        }



        @FXML
        void btn_login(MouseEvent event) throws Exception {
                String userName=Txt_username.getText();
                String password=Password.getText();
                if (new DBConnection().login(userName, password) == 1){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Login successful");
                        alert.setHeaderText(null);
                        alert.showAndWait();

                    Txt_username.clear();
                    Password.clear();

                       Stage stage=(Stage) btn_login.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Mainpage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setTitle("Library Management System");
                    stage.setScene(scene);
                    stage.show();

                }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Login Error!!!");
                        alert.setHeaderText(null);
                        alert.showAndWait();

                }


        }




        @FXML
        void btn_submit(ActionEvent event) throws Exception {
                String firstname=Txt_fname.getText();
                String lastname=Txt_lname.getText();
                String Email=Txt_email.getText();
                String Address=Txt_location.getText();
                String password=Txt_password.getText();
                DBConnection link= new DBConnection();

                if (link.save(firstname,lastname,Email,Address,password) == 1){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("SignUp successful");
                        alert.setHeaderText(null);
                        alert.showAndWait();

                         Txt_fname.clear();
                         Txt_lname.clear();
                         Txt_email.clear();
                         Txt_location.clear();
                         Txt_password.clear();
                        login_pane.setVisible(true);
                        Signup_pane.setVisible(false);
                }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("SignUp Error!!!");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                }


        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
    }


