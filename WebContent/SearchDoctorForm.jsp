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
<form name="form1" method="post" action="SearchServlet" >
<table> 
<input type="hidden" id="command" value="Doctor" name="command" />
<h1> Enter Doctor's Name/Specialization </h1>
<tr> <td style="width:90%;"> 

<input type="text" id="search" name="search" placeHolder="Enter doctor's Name or Search by Specialization" style="width:90%;"/>
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