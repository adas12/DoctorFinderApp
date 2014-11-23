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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="BackEndCss.css" >

<script language="javascript" src="validate.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script>
$(function() {
$( "#datepicker" ).datepicker(
{ 
minDate: 0, 
maxDate: "+1M +10D"
}
);
});
</script>
<title>View result </title>

</head>
<body> <center> <img src="Logo.png"/> </center>
<br/> <br/> 

<div class="right"> <h3 style="color:white;">  <a href="Home.jsp">Home Page</a>|| <a href="Contact.jsp">Contact us</a>|| <a href="Login.jsp">Login</a> </h3> </div> 
  <br/> <br/>  


<% 
String docId=(String)request.getAttribute("docId");
String sql="select doctorName,specialization,degree,review,docId from doctordetails where docId='"+docId+"' ;";
String findDoc="select doctorName,specialization,degree,CenterName,location,wkday,Tfrom,Tto,shiftId from shift inner join doctordetails on doctordetails.docId=shift.docId inner join centreDetails on centreDetails.centreId=shift.centreId where doctordetails.docId='"+docId+"' ;";
DetailsBean db=new DetailsBean();
List<Details> dtlist= db.getDoctorDetails(findDoc);
//DoctorBean dbn=new DoctorBean();
List<Details> doctlist= db.getSearchResult(sql);
request.setAttribute("docId",docId);
//List<Details> dtlist =(ArrayList<Details>)request.getAttribute("dt");
//List<Details> doctlist =(ArrayList<Details>)request.getAttribute("doct");

%>
	<form id="f2" name="f2" action="AppointmentServlet" method="post" onsubmit="return checkForm(this);"> 
 <input type="hidden" id="command" value="check" name="command" /> 
<div > 

<%for (Details doct:doctlist)
{
 %>
 <input type="hidden" id="docId" name="docId" value="<%=doct.getDocId()%>"/>
 <center>
<table  style="width:400px;"> 
 
<tr style="color:Blue;">
<td style="width:60%;"><h2> <%=doct.getDoctorName()%></h2> </td>
  <td> <p> <%=doct.getSpecialization() %></p></td>
  <td><p>(<%=doct.getDegree()%>)</p></td>
</tr>

<%} %>
</table> 
</center>
<center> 
<h3>  ${ErrorMssg } </h3> 
<h1> Availability </h1>
<table style="background-color:white;"> 
<tr> <td><p>  Weekdays</p> </td> <td> <p> Name of the Clinic</p></td> 
<td> <p>Location  </p></td> <td> <p> From </p></td> <td> <p> To </p></td><td> <p> Select date </p> </td>  </tr> 
<% for (Details dt:dtlist){ %>
<tr> <td> <input type="hidden" id="shiftId" value="<%=dt.getId()%>" name="shiftId" /> </td>
 </tr> 
<tr > 
<td> <%=dt.getWkday() %> </td> 
<td> <%=dt.getCenterName() %> </td> 
<td><%=dt.getLocation()%></td>
<td><%=dt.getTfrom() %> </td> 
<td><%=dt.getTto() %></td> 
<td><input type="text" name="datepicker" id="datepicker"  style="width:200px;" /> </td>

<td> <input type="Submit" value="Check Availability" id="Check" name="Check" style="width:200px;"/> 
</tr>
<%
 
 }%>
 </table>
 </center>
 </div>
 </form>
 

<script language="javascript">
document.f2.datepicker.focus();

function checkForm(form)
{
	
	re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/; 
	 if((form.datepicker.value =='' ) || !(form.datepicker.value.match(re))) 
	{
	alert("Please Select a Date");
	return false;
	}
	else 
		return true; 
	}
	
</script>

</body>
</html>