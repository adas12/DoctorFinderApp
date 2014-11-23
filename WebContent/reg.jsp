<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Registration page</title>
<script language="javascript" src="Validation.js"></script>
<link href="BackEndCss.css" rel="stylesheet" type="text/css"/>
</head>
<body>
      <center> <img src="Logo.png"/> </center>
    <% String shiftId=(String) request.getAttribute("shiftId");
	String datepicker= (String)request.getAttribute("datepicker"); %>
     
	<center>
		<h1>Welcome to Registration page</h1>
	</center> <center> 

	<form name="reg" action="#" onsubmit="return validateuser()" method="POST">
		<table>
			<tr>
				<td>USER ID: <input type="text" name="user_id" value="">
				</td> 
				
			<tr>
				<td>First Name :<input type="text" name="F_Name" value="">
				</td>
			
				<td>Middle Name: <input type="text" name="M_Name"></td>
			</tr>
			<tr>
				<td>Last Name:<input type="text" name="L_Name" value=""></td>
			</tr>
			<tr>
				<td>Type your Password <input type="password" name="Pass" value="">
				</td>
				<td>Confirm your Password<input type="password" name="Pass1" value=""></td>
			</tr>
			
			
		 </table> <br> <table> <tr> <td> 
				<input type="Reset" Value="Reset">
				<input type="Submit" Value="submit" name="submit">
			</td> 	</tr> </table>
	</form>
 </center> 

</body>
</html>