package com.example.group_project.Controllers;

import com.example.group_project.DB.DBConnection;
import com.example.group_project.Startapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;


public class Mainpage_Controller {

    @FXML
    private TextField Addess_uer;

    @FXML
    private TextField Copies_return;

    @FXML
    private TextField Daterelease_borr;

    @FXML
    private TextField Datereturn;

    @FXML
    private TextField Fname_user;

    @FXML
    private TextField Lname_user;

    @FXML
    private AnchorPane Main_pane;

    @FXML
    private TextField Nocopies_borr;

    @FXML
    private TextField ReleaseDate_return;

    @FXML
    private TextField Stffname_return;

    @FXML
    private TextField StudId_return;

    @FXML
    private TextField Txt_Bk_del;

    @FXML
    private TextField Txt_Delete_Borrow;

    @FXML
    private TextField Txt_del_user;

    @FXML
    private TextField Txt_delete_return;

    @FXML
    private TextField bkTitle_return;

    @FXML
    private TextField bk_author;

    @FXML
    private TextField bk_copies;

    @FXML
    private TextField bk_edition;

    @FXML
    private TextField bk_publisher;

    @FXML
    private TextField bk_source;

    @FXML
    private TextField bk_title;

    @FXML
    private TextField bkid_return;

    @FXML
    private TextField bookid_borr;

    @FXML
    private TextField booktitle_borr;

    @FXML
    private TextField duedate_borr;

    @FXML
    private TextField email_user;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane pane_book;

    @FXML
    private AnchorPane pane_borrower_record;

    @FXML
    private AnchorPane pane_returnbook;

    @FXML
    private AnchorPane pane_student;

    @FXML
    private AnchorPane pane_user;

    @FXML
    private PasswordField pass_user;

    @FXML
    private Button btn_student;

    @FXML
    private TextField staffid_borr;

    @FXML
    private TextField staffid_return;

    @FXML
    private TextField staffname_borr;

    @FXML
    private TextField studid_borr;

    @FXML
    private TextField studname_borr;

    @FXML
    private TextField studname_return;

    @FXML
    void Add_user(ActionEvent event) {
        pane_book.setVisible(false);
        pane_borrower_record.setVisible(false);
        pane_user.setVisible(true);
        pane_student.setVisible(false);
        pane_returnbook.setVisible(false);

    }

    @FXML
    void Addbook(ActionEvent event) {
        pane_book.setVisible(true);
        pane_borrower_record.setVisible(false);
        pane_user.setVisible(false);
        pane_student.setVisible(false);
        pane_returnbook.setVisible(false);

    }

    @FXML
    void Delete_Borrow(ActionEvent event) throws Exception {
        String Title=Txt_Delete_Borrow.getText();

        DBConnection Record_Delete=new DBConnection();
        if (Record_Delete.DeleteBorrower(Title)==1){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            Txt_Delete_Borrow.clear();
        }

    }

    @FXML
    void Delete_return(ActionEvent event) throws Exception {
        String FulllName=Txt_delete_return.getText();

        DBConnection ReturnBook_Delete=new DBConnection();

        if (ReturnBook_Delete.ReturnBook_del(FulllName)==1){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            Txt_delete_return.clear();
        }

    }

    @FXML
    void Delete_user(ActionEvent event) throws Exception {
        String Staff_LastName=Txt_del_user.getText();

        DBConnection delete=new DBConnection();
        if (delete.DeleteUser(Staff_LastName)==1){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            Txt_del_user.clear();
        }

    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        /* Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Do you when to logout");
        alert.setHeaderText(null);
        alert.showAndWait();*/

        Stage stage=(Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void Return_book(ActionEvent event) {
        pane_book.setVisible(false);
        pane_borrower_record.setVisible(false);
        pane_user.setVisible(false);
        pane_student.setVisible(false);
        pane_returnbook.setVisible(true);

    }

    @FXML
    void StudentShow(ActionEvent event) throws IOException {
        Stage stage=(Stage) btn_student.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Startapp.class.getResource("Student.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SubmitReturnbk(ActionEvent event) throws Exception {
        String Book_id= bkid_return.getText();
        String Book_Title=bkTitle_return.getText();
        String STUDENT_ID=StudId_return.getText();
        String Student_FullName=studname_return.getText();
        String Staff_FullName=Stffname_return.getText();
        String Staff_ID=staffid_return.getText();
        String NOcopies=Copies_return.getText();
        String Release_Date=ReleaseDate_return.getText();
        String Due_Date=Datereturn.getText();

        DBConnection BookReturn=new DBConnection();
        if(BookReturn.saveReturn(Book_id,Book_Title, STUDENT_ID,Student_FullName,Staff_FullName,Staff_ID,NOcopies, Release_Date, Due_Date)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Return book added successfully");
            alert.setHeaderText(null);
            alert.showAndWait();

            bkid_return.clear();
            bkTitle_return.clear();
            StudId_return.clear();
            studname_return.clear();
            staffid_return.clear();
            Stffname_return.clear();
            Copies_return.clear();
            ReleaseDate_return.clear();
            Datereturn.clear();



            Main_pane.setVisible(true);
            pane_returnbook.setVisible(false);
        }

    }

    @FXML
    void Submitt_user(ActionEvent event) throws Exception {
        String lastname=Lname_user.getText();
        String firstname=Fname_user.getText();
        String Email=email_user.getText();
        String Address=Addess_uer.getText();
        String password=pass_user.getText();
        DBConnection LinkUser=new DBConnection();
        if(LinkUser.save(lastname,firstname,Email,Address,password)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("User Added successfully");
            alert.setHeaderText(null);
            alert.showAndWait();

            Lname_user.clear();
            Fname_user.clear();
            email_user.clear();
            Addess_uer.clear();
            pass_user.clear();

            Main_pane.setVisible(true);
            pane_user.setVisible(false);
        }

    }

    @FXML
    void bk_delete(ActionEvent event) throws Exception {
        String Title=Txt_Bk_del.getText();

        DBConnection Book_Delete=new DBConnection();
        if (Book_Delete.bk_delete(Title)==1){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully Deleted");
            alert.showAndWait();

            Txt_Bk_del.clear();
        }

    }

    @FXML
    void bk_submit(ActionEvent event) throws Exception {
        String BookTitle=bk_title.getText();
        String BookEdition=bk_edition.getText();
        String BookAuthor=bk_author.getText();
        String BookPublisher=bk_publisher.getText();
        String BookCopies=bk_copies.getText();
        String BookSource=bk_source.getText();
        DBConnection LinkBook=new DBConnection();
        if(LinkBook.submitBook(BookTitle,BookEdition,BookAuthor,BookPublisher,BookCopies,BookSource)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Save successfully");
            alert.setHeaderText(null);
            alert.showAndWait();

            bk_title.clear();
            bk_edition.clear();
            bk_author.clear();
            bk_publisher.clear();
            bk_copies.clear();
            bk_source.clear();

            Main_pane.setVisible(true);
            pane_book.setVisible(false);
        }

    }

    @FXML
    void borrower_records(ActionEvent event) {
        pane_book.setVisible(false);
        pane_borrower_record.setVisible(true);
        pane_user.setVisible(false);
        pane_student.setVisible(false);
        pane_returnbook.setVisible(false);

    }

    @FXML
    void submit_borrower(ActionEvent event) throws Exception {
        String Book_id=bookid_borr.getText();
        String Book_Title=booktitle_borr.getText();
        String STUDENT_ID=studid_borr.getText();
        String Student_FullName=studname_borr.getText();
        String Staff_FullName=staffname_borr.getText();
        String Staff_ID=staffid_borr.getText();
        String NOcopies=Nocopies_borr.getText();
        String Release_Date=Daterelease_borr.getText();
        String Due_Date= duedate_borr.getText();
        DBConnection SubmitBorrower=new DBConnection();
        if(SubmitBorrower.submitBorrower( Book_id,Book_Title,STUDENT_ID, Student_FullName,Staff_FullName,Staff_ID, NOcopies,Release_Date,Due_Date)==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Submitted successfully");
            alert.setHeaderText(null);
            alert.showAndWait();

            bookid_borr.clear();
            booktitle_borr.clear();
            bookid_borr.clear();
            studname_borr.clear();
            studid_borr.clear();
            staffname_borr.clear();
            staffid_borr.clear();
            Nocopies_borr.clear();
            Daterelease_borr.clear();
            duedate_borr.clear();

            Main_pane.setVisible(true);
            pane_borrower_record.setVisible(false);

        }

    }

}
