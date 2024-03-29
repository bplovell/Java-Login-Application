package com.mvc.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
 
public class RegisterDao {
 
 public String registerUser(RegisterBean registerBean)
 {
 String fullName = registerBean.getFullName();
 String email = registerBean.getEmail();
 String userName = registerBean.getUserName();
 String password = registerBean.getPassword();
 String question = registerBean.getquestion();
 String answer = registerBean.getanswer();
 
 Connection con = null;
 PreparedStatement preparedStatement = null;
 
 try
 {
 con = DBConnection.createConnection();
 String query = "insert into users(S1No,fullName,Email,userName,password,question,answer) values (NULL,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
 preparedStatement.setString(1, fullName);
 preparedStatement.setString(2, email);
 preparedStatement.setString(3, userName);
 preparedStatement.setString(4, password);
 preparedStatement.setString(5, question);
 preparedStatement.setString(6, answer);
 
 int i= preparedStatement.executeUpdate();
 
 if (i!=0)  //Just to ensure data has been inserted into the database
 return "SUCCESS"; 
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 
 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
 }
}