<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reset Password</title>
    <link rel="stylesheet" href="/css/style.css" >
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery.validate.min.js"></script>
</head>
<body>
<script> 
function validate()
{ 
var username = document.form.username.value; 
if (username==null || username=="")
{ 
alert("Username cannot be blank"); 
return false; 
}
}
</script> 
     
    <div align="center">
        <h2>Reset Your Password</h2>
        <p>
        Please enter your username:
        </p>
         
        <form action="ResetServlet" method="post" onsubmit="return validate()">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="userName" id="userName" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="submit">Submit</button>
                    </td>
                </tr>    
            </table>
        </form>
    </div>
</body>
</html>