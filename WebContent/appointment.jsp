<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.DetailsBean" %>
<%@page import="com.Details" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">\
<link rel="stylesheet" type="text/css" href="BackEndCss.css" >
<title>Schedule an Appointment</title>
<script language="javascript" src="Validate.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <script>
function openWindow(address) {
    window.open("map.html?address=?"+address, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=200, left=500, width=400, height=400");
}

    </script>
</head>
<body> <center> <img src="Logo.png"/> </center>
<h2>  ${ErrorMssg } </h2> 

      <%  String shiftId=(String) request.getAttribute("shiftId");
		String datepicker= (String)request.getAttribute("datepicker");
		String User_id= (String)request.getAttribute("User_id");
		request.setAttribute(User_id, User_id);
		DetailsBean dbean= new DetailsBean(); 
     Details dt=dbean.getAppoinment(shiftId);
				 %>
     
	
	 

	<form name="reg" action="AppointmentServlet"  onsubmit="return validateuser()" method="POST">
	<center> 	
<table  style="width:400px;border-color:lightblue;"> 
<tr >
<td style="border-color:lightblue;"> <h1>  <%=dt.getDoctorName() %> </h1></td> 
      <td style="border-color:lightblue;"> <h3><%=dt.getSpecialization() %>, (<%=dt.getDegree() %>)  </h3> </td> </tr> 
      </table> 
      </center>
      <center> 
      
      <table style="width:700px;border-color:lightblue;"> 
        <tr> <td style="width:40%;"> <h3> Centre Name: <%=dt.getCenterName() %> </h3> </td> 
         <td> <h3> Address : <%=dt.getLocation()%>, <%=dt.getPin()%> </h3> </td>  
       <td> 
      <a onclick="openWindow('<%=dt.getPin()%>')" href="javascript:void(0);">Check Location</a> 
      </td></tr> </table> 
         
       <table style="width:700px;border-color:lightblue;"> 
         <tr> 
		<td> <h3> 	Day Selected :<input type="text"  name="wkday" id="wkday" value="<%=dt.getWkday() %>" />  </h3> </td> 
		<td> 	Date :<%=datepicker%> </td> 
		
		</tr>
	</table> 
	<h1 style="width:200px;"> Please insert Patient's Details </h1>
	<table style="width:700px;">
	<tr> 		<td> Name :<input type="text" name="PatientName" value=""></td>
	<td>Contact: <input type="text" name="Contact"></td>
			</tr>
			  <tr> <td> 
				<input type="Reset" Value="Reset"> </td> 
			<td> 	<input type="Submit" Value="submit" name="submit"  style="width:200px;" >
			</td> 	</tr> </table> 
			 <input type="hidden" name="shiftId" id="shiftId" value="<%=dt.getId() %>" /> 
		 <input type="hidden" id="command" value="fix" name="command" /> 
		<input type="hidden" name="doctorName" id="doctorName" value="<%=dt.getDoctorName() %>" /> 
		<input type="hidden" name="Tfrm" id="Tfrm" value="<%=dt.getTfrom()%>" /> 
		<input type="hidden" name="Tto" id="Tto" value="<%=dt.getTto() %>" /> 
		<input type="hidden" name="CenterName" id="CenterName" value="<%=dt.getCenterName() %>" /> 
		<input type="hidden" name="Centerlocation" id="Centerlocation" value="<%=dt.getLocation() %>" /> 
		<input type="hidden" name="pin" id="pin" value="<%=dt.getPin()%>" /> 
		<input type="hidden" name="sp" value="<%=dt.getSpecialization() %>" /> 
		<input type="hidden" name="wkday" value="<%=dt.getWkday() %>" /> 
		 <input type="hidden" id="userId" value="<%=request.getAttribute("User_id") %>" name="userId" /> 
		 <input type="hidden" id="docId" value="<%=dt.getDocId() %>" name="docId" /> 
		<input type="hidden" id="datepicker" value="<%=datepicker%>" name="datepicker" /> 
		 
	</form>
 </center> 

</body>
</html>