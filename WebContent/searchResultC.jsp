<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.ClinicBean" %>
<%@page import="com.ClinicDetails" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="BackEndCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result </title>
</head>
<body style="background-color:silver;"> 
 <%@include file="header.jsp"%>
<center>
<% 
List<ClinicDetails> cbeanList =(ArrayList<ClinicDetails>)request.getAttribute("cbeanList");

if( cbeanList.isEmpty())
{
	%>
	<br/> <hr> 
	 <h2> Sorry No matching Result Found </h2>
	<br/> <hr/>
	<% 
}

else 
{
	%>
	 
<table> 
<tr style="background-color:coral;color:green;">
<td>  <p> Center Name </p> </td> <td> <p> Location </p> </td> <td> <p> PIN </p> </td> <td> <p> DAY Open  </p></td> <td> <p> Time Open  </p></td><td> <p> ID  </p></td></tr>
<% 
for (ClinicDetails clinic:cbeanList)
{
%>	
<tr> <td> <input type="text" id="name" value="<%=clinic.getCenterName() %>" readonly/> </td> 

<td> <input type="text" id="name" value="<%=clinic.getLocation() %>" readonly/> </td>
<td> <input type="text" id="name" value="<%=clinic.getPin()%>" readonly/> </td>
<td> <input type="text" id="name" value="<%=clinic.getDayOp()%>" readonly/> </td> 
<td> <input type="text" id="name" value="<%=clinic.getTimeOp()%>" readonly/> </td>
<td> <input type="text" id="name" value="<%=clinic.getCentreId()%>" readonly/> </td></tr> 

<%}
}
%>
</table> </center>
<%@include file="footer.jsp"%>
</body>
</html>