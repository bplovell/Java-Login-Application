 //resetDao.java
package com.mvc.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mvc.bean.ResetBean;
import com.mvc.util.DBConnection;
public class ResetDao {
public String authenticateUser(ResetBean resetBean)
{
String userName = resetBean.getUserName(); //Keeping user entered values in temporary variables.
Connection con = null;
Statement statement = null;
ResultSet resultSet = null;
String userNameDB = "";
String passwordDB = "";
try
{
con = DBConnection.createConnection(); //establishing connection
statement = con.createStatement(); //Statement is used to write queries. Read more about it.
resultSet = statement.executeQuery("select userName from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
while(resultSet.next()) // Until next row is present otherwise it return false
{
userNameDB = resultSet.getString("userName"); //fetch the values present in database
if(userName.equals(userNameDB))
{
return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
}
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Invalid user credentials"; // Just returning appropriate message otherwise
}
}