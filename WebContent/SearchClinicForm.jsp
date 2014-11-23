<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="home.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchDoctorForm</title>
</head>
<body>
<center>
<form name="form2" method="post" action="SearchServlet" >
<table> 
<h1>Find Clinic Nearest to you</h1>
<input type="hidden" id="command" value="Location" name="command" /> 
<tr> <td style="width:90%;"> 

<input type="text" id="pin" name="pin" placeHolder="Enter PIN " style="width:90%;"/>
</td> <td> 
<textarea rows="1" cols="12" id="location" readonly>Kolkata,India</textarea>
</td></tr> <tr> <td> 
<center>
<input id="Submit" type="Submit" value="Click Here" name="Submit" /> </center> </td> </tr> 
</form>
</table>

</center>
</body>
</html>