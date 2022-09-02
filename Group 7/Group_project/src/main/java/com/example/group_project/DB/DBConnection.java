package com.example.group_project.DB;



import java.sql.*;

public class DBConnection {
    private final   String Driver="com.mysql.cj.jdbc.Driver";
    private final   String DatabaseName="library_management_system";
    private final String DatabaseUser="root";
    private final String DatabasePassword="";
    private final  String url="jdbc:mysql://"+DatabaseUser+":"+DatabasePassword+"@"+"localhost/"+DatabaseName;


    public DBConnection() throws Exception {
        Class.forName(Driver);
        connection = DriverManager.getConnection(url);
    }


    Connection connection =null;
    PreparedStatement prepStatement=null;
    ResultSet resultSet=null;

    public int save(String lastname, String firstname, String Email, String Address, String password) throws SQLException {
        String query = "INSERT INTO `usertable`( `Staff_LastName`, `Staff_FirstName`, `Staff_Email`, `Staff_Address`, `Staff_Password`) values(?, ?, ?, ?, ?)";
        prepStatement = connection.prepareStatement(query);
        prepStatement.setString(1, lastname);
        prepStatement.setString(2, firstname);
        prepStatement.setString(3, Email);
        prepStatement.setString(4, Address);
        prepStatement.setString(5, password);

        return prepStatement.executeUpdate();
    }


    public <User> void User(User user) {
    }

    public int login(String lastname,String password) throws SQLException {
        prepStatement = connection.prepareStatement("SELECT * FROM `usertable` WHERE Staff_LastName=? and Staff_Password=? ");
        prepStatement.setString(1,lastname);
        prepStatement.setString(2,password);
        resultSet = prepStatement.executeQuery();
        if(resultSet.next()){
            return 1;
        }else{
            return 0;
        }

    }
    public int submitBook(String Book_Title,String Book_Edition,String Book_Author,String Book_Publisher,String Book_Copies,String Book_Source) throws SQLException {
        String query="INSERT INTO `book_table`(`Book_Title`, `Book_Edition`, `Book_Author`, `Book_Publisher`, `Book_Copies`, `Book_Source`) values(?,?,?,?,?,?)";
        prepStatement=connection.prepareStatement(query);
        prepStatement.setString(1,Book_Title);
        prepStatement.setString(2,Book_Edition);
        prepStatement.setString(3,Book_Author);
        prepStatement.setString(4,Book_Publisher);
        prepStatement.setString(5,Book_Copies);
        prepStatement.setString(6,Book_Source);

        return prepStatement.executeUpdate();
    }
    public int submitBorrower(String Book_Id, String Book_Title, String STUDENT_ID, String Student_FullName, String Staff_FullName, String Staff_ID, String NOcopies, String Release_Date, String Due_Date) throws SQLException {
        String sql="INSERT INTO `borrowerrecords`(`Book_Id`, `Book_Title`, `STUDENT_ID`, `Student_Fullname`, `Staff_Fullname`, `Staff_ID`, `NOcopies`, `Release_Date`, `Due_Date`) values(?,?,?,?,?,?,?,?,?)";
        prepStatement=connection.prepareStatement(sql);
       prepStatement.setString(1,Book_Id);
       prepStatement.setString(2,Book_Title);
       prepStatement.setString(3,STUDENT_ID);
       prepStatement.setString(4,Student_FullName);
       prepStatement.setString(5,Staff_FullName);
       prepStatement.setString(6,Staff_ID);
       prepStatement.setString(7,NOcopies);
       prepStatement.setString(8,Release_Date);
       prepStatement.setString(9,Due_Date);

      return prepStatement.executeUpdate();
    }

    public  int saveReturn(String Book_id,String Book_Title, String STUDENT_ID, String Student_FullName,String Staff_FullName,String Staff_ID, String NOcopies, String Release_Date, String Due_Date) throws SQLException {
        String query="INSERT INTO `book_return_records`(`Book_id`, `Book_Title`, `STUDENT_ID`, `Student_Fullname`, `Staff_Fullname`, `Staff_ID`, `NOcopies`, `Release_Date`, `BookReturn_Date`) values(?,?,?,?,?,?,?,?,?)";
        prepStatement=connection.prepareStatement(query);
        prepStatement.setString(1,Book_id);
        prepStatement.setString(2,Book_Title);
        prepStatement.setString(3,STUDENT_ID);
        prepStatement.setString(4,Student_FullName);
        prepStatement.setString(5,Staff_FullName);
        prepStatement.setString(6,Staff_ID);
        prepStatement.setString(7,NOcopies);
        prepStatement.setString(8,Release_Date);
        prepStatement.setString(9,Due_Date);

        return prepStatement.executeUpdate();
    }

    public int SubmitStudent(String Firstname,String Lastname,String gender,String email,String program,String Year,String Phone_NO,String Address) throws SQLException {
        String sql="INSERT INTO `student`(`first_name`, `last_name`, `gender`, `email`, `Program`, `year`, `Phone_no`, `Address`) Values(?,?,?,?,?,?,?,?)";

        prepStatement= connection.prepareStatement(sql);


        prepStatement.setString(1,Firstname);
        prepStatement.setString(2,Lastname);
        prepStatement.setString(3,gender);
        prepStatement.setString(4,email);
        prepStatement.setString(5,program);
        prepStatement.setString(6,Year);
        prepStatement.setString(7,Phone_NO);
        prepStatement.setString(8,Address);

        return prepStatement.executeUpdate();

    }

   public  int Delete(String first_name) throws SQLException {
        String del_sql="DELETE FROM `student` WHERE first_name=?";
       prepStatement= connection.prepareStatement(del_sql);

        prepStatement.setString(1,first_name);

        return prepStatement.executeUpdate();
    }

    public  int DeleteUser(String last_name) throws SQLException {
        String query="DELETE FROM `usertable` WHERE Staff_LastName=?";

        prepStatement= connection.prepareStatement(query);
        prepStatement.setString(1,last_name);

        return prepStatement.executeUpdate();
    }

    public int bk_delete(String Title) throws SQLException {
        String query="DELETE FROM `books table` WHERE Book_Title=? ";

        prepStatement= connection.prepareStatement(query);
        prepStatement.setString(1,Title);

        return prepStatement.executeUpdate();
    }

    public int DeleteBorrower(String Title) throws SQLException {
        String query="DELETE FROM `borrower records` WHERE Book_Title=?";

        prepStatement= connection.prepareStatement(query);
        prepStatement.setString(1,Title);

        return prepStatement.executeUpdate();
    }

    public int ReturnBook_del(String FullName) throws SQLException {
        String query="DELETE FROM `book return records` WHERE Student_FullName=?";

        prepStatement= connection.prepareStatement(query);

        prepStatement.setString(1,FullName );
        return prepStatement.executeUpdate();
    }



}
