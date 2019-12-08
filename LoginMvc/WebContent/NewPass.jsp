<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%

String currentuser=request.getParameter("user");
String Newpass=request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3306/customers";
Connection con=null;
String pass="";
int id=0;
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "root", "root123");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from users where userName='"+currentuser+"'");
out.println(currentuser);
while(rs.next()){
id=rs.getInt(1);
pass=rs.getString(3);}
Statement st1=con.createStatement();
int i=st1.executeUpdate("update users set password='"+Newpass+"' where S1No='"+id+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
catch(Exception e){
out.println(e);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
 <center><b>Please <a href="http://localhost:8080/LoginMvc/">log-in</a> to continue.</b></center>
  
</html>