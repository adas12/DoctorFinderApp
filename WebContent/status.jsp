<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css"/> 

</head>
 <body>
<center> <img src="Logo.png"/> </center>
    <% String docId=(String)request.getAttribute("docId");
    String appId=(String) request.getAttribute("appId");
	String PatientName=(String) request.getAttribute("PatientName");
	String datepicker= (String)request.getAttribute("datepicker");
    String doctorName=(String) request.getAttribute("doctorName");
    String CenterName=(String) request.getAttribute("CenterName");
    String Centerlocation= (String)	request.getAttribute("Centerlocation");
    String pin= (String)	request.getAttribute("pin");
    String userId=	(String)request.getAttribute("userId");
    String sp=	(String)request.getAttribute("sp");
    String wkday=(String)request.getAttribute("wkday");
    String shiftId=(String) request.getAttribute("shiftId");
    String Contact=(String) request.getAttribute("Contact");
    String Tfrm=(String) request.getAttribute("Tfrm");
	String Tto=(String) request.getAttribute("Tto");
	 %>
<center>
<h3> Patient Registration Successful </h3> </center>
      <input type="hidden" name="appid" id="appid" value="<%=appId %>" />  
       <div id="mystyle" class="myform"> <h1> Appointment Id:  <%=appId %>  </h1>
      <p>Doctor :   <%=doctorName %> (<%=sp%>)</p> 
    
       <input type="hidden" name="uid" id="uid" value="<%=userId %>" readonly />
    <table>
     <tr> <td style="border-Color:white;"> 
                   <label>Center </label>
                   <input type="text" name="Cname" id="Cname" value="<%=CenterName %>" readonly />
                  </td> <td style="border-Color:white;">  
                  <label>Address and Locality  </label>
                <input type="text" name="add" id="add" value="<%=Centerlocation %>, <%=pin %> " readonly />
                  </td> </tr>
          <tr> <td style="border-Color:white;">  
            <label> Name of the Patient: </label>
                <input type="text" name="pat" id="pat" value="<%=PatientName %>"  readonly >
                  </td>  <td style="border-Color:white;">  
                  <label>Contact Number: </label>
                <input type="text" name="contact" id="contact" value=" <%=Contact %>" readonly />
                  </td></tr> 
                   <tr>  <td style="border-Color:white;">  
                  <label>Date of Appointment(Day)<span class="small">(DD/MM/YYYY) </span></label>
                <input type="text" name="Date" id="Date" value="<%=datepicker %>(<%=wkday %>)" readonly />
                  </td> <td style="border-Color:white;">  
                <label>Time of Visit </label>
                <input type="Time" name="Day" id="Day" value="<%=Tfrm %> to <%=Tto %>" readonly />
                  </td></tr> 
                  </table> 
          <a href="feedback.jsp?userId=<%=userId%>&appId=<%=appId %>&PatientName=<%=PatientName%>&datepicker=<%=datepicker%>&docId=<%=docId%>&doctorName=<%=doctorName %>&center=<%=CenterName%>" >Feedback</a>       
                  </div> 
		
<center>		<h3> Must Bring a Print-out of this file </h3> 
<form name="dw" action="PDFdownloadServlet" id="dw" method="post" > 
<input type="hidden" name="doctorName" id="doctorName" value="<%=doctorName %>" />
 
		<input type="hidden" name="Tfrm" id="Tfrm" value="<%=Tfrm%>" /> 
		<input type="hidden" name="Tto" id="Tto" value="<%=Tto %>" /> 
<input type="hidden" name="CenterName" id="CenterName" value="<%=CenterName%>" /> 
<input type="hidden" name="Centerlocation" id="Centerlocation" value="<%=Centerlocation%>" /> 
		<input type="hidden" name="pin" id="pin" value="<%=pin%>" /> 
		<input type="hidden" name="sp" value="<%=sp %>" /> 
		<input type="hidden" name="wkday" value="<%=wkday %>" /> 
		 <input type="hidden" id="userId" value="<%=userId %>" name="userId" /> 
		 <input type="hidden" id="docId" value="<%=docId%>" name="docId" /> 
	<input type="hidden" id="datepicker" value="<%=datepicker%>" name="datepicker" /> 

<input type="hidden" id="Contact" value="<%=Contact%>" name="Contact" /> 

<input type="hidden" id="PatientName" value="<%=PatientName%>" name="PatientName" /> 

<input type="hidden" id="appId" value="<%=appId%>" name="appId" /> 
<input type="submit" value="Download" name="submit" /> 
</form> 
 </center> 
		

</body>
</html>