<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="BackEndCss.css" rel="stylesheet" type="text/css"/>
<title>Login Page</title>
</head>
<body>
<body> 
<center> <img src="Logo.png"/> </center>
    <% String shiftId=(String) request.getAttribute("shiftId");
	String datepicker= (String)request.getAttribute("datepicker"); %>
     
    
<center> 
  	<h1>  ${Mssg } </h1> 
	<Form name="login" method="post" action="LoginServlet" >
	<table style="width:280px;">
 
 <tr > <td > 
		<B>User Id : </B> </td> <td> <input name="User_Id" type="text" maxlength="25" size="15"> </td> </tr> 
		<br/> 
<tr > <td>		<B>Password :</B> </td> <td> <input name="Pass_Id" type="password" maxlength="25" size="15"> </td> </tr> 
 
		<tr> 
		<td> <input type="hidden" name="shiftId" id="shiftId" value="<%=request.getAttribute("shiftId") %>" /> </td> </tr> 
	<tr> 	<td> 	<input type="hidden" id="datepicker" name="datepicker" value="<%=request.getAttribute("datepicker")%>" > </td> </tr>
		 

		<tr> <td>  
	<input type="Reset" Value="Reset"> </td> <td> <input type="Submit" Value="Login" onclick="return validateUser()" style="width:200px;" > 
	 </table>
	</Form>
	<h2> Want to Sign up? <a href="reg.jsp"> Click here </a></h2>
</center>

	<script language="javascript">
document.f1.User_Id.focus();

function validateUser()
{
	var x=document.login.User_Id.value;
	var y=document.login.Pass_Id.value;
	
	
	if(x=="" || y=="") {
		alert("Please enter your User Id, Password  ")
		return false;
	}
	else {
		return true;
	}
	}
	
</script>

</body>
</html>
