<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.DoctorBean" %>
<%@page import="com.DoctorDetails" %> 
<%@page import="com.DetailsBean" %>
<%@page import="com.Details" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="BackEndCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result </title>
</head>
<body> 
 <center> <img src="Logo.png"/> </center>
 <br/> <br/> 

<div class="right"> <h3 style="color:white;">  <a href="Home.jsp">Home Page</a>|| <a href="Contact.jsp">Contact us</a>|| <a href="Login.jsp">Login</a> </h3> </div> 
  <br/> <br/> 

<% 

List<Details> dtlist =(ArrayList<Details>)request.getAttribute("dtList");
if( dtlist.isEmpty())
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
	<center>  
<table> 
<tr style="background-color:coral;color:green;">
<td>  <p> Name </p> </td> <td> <p> Specialization </p> </td> <td> <p> Degree </p> </td> <td> <p> Recommended by No. of User </p></td>
</tr>
<% 
for (Details dt:dtlist)
{
%>	
<tr> <td> <%=dt.getDoctorName() %> </td> 
<% String DocId=dt.getDocId(); String docn=dt.getDoctorName();
String sp=dt.getSpecialization(); String degr=dt.getDegree();  %>
<td> <%=dt.getSpecialization() %>  </td>
<td> <%=dt.getDegree()%> </td>
<td> <a href="review.jsp?docId=<%=DocId%>&docn=<%=docn%>"> <%=dt.getReview()%> </a>  </td> 
<td> 
<form name="f1" id="f1" action="SearchServlet" method="post">
<input type="hidden" id="command" value="doc_detail" name="command" /> 
<input type="hidden" value="<%=dt.getDocId()%>" name="docId" id="docId" /> 
<input Type="Submit" value="View Details" id="submit" style="width:200px;"/>
</form>
</td>
</tr>
<%}
}
%>
</table> </center>

</body>
</html>