//LoginServlet.java
package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.ResetBean;
import com.mvc.dao.ResetDao;
public class ResetServlet extends HttpServlet {
public ResetServlet() {
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.
String userName = request.getParameter("userName");
ResetBean resetBean = new ResetBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
resetBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
ResetDao resetDao = new ResetDao(); //creating object for LoginDao. This class contains main logic of the application.
String userValidate = resetDao.authenticateUser(resetBean); //Calling authenticateUser function
if(userValidate.equals("SUCCESS")) //If function returns success string then user will be rooted to Home page
{
request.setAttribute("userName", userName);
request.getRequestDispatcher("/GetNewPass.html").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
}
else
{
request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
request.getRequestDispatcher("/ResetForm.jsp").forward(request, response);//forwarding the request
}
}
}