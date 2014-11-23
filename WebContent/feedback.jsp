<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css"/> 

</head>
 <body>
<center> <img src="Logo.png"/> </center>
<% String appId=request.getParameter("appId");String userId=request.getParameter("userId");
String docId=request.getParameter("docId");
String PatientName=request.getParameter("PatientName");
String datepicker= request.getParameter("datepicker");
String doctorName=request.getParameter("doctorName");
String CenterName=request.getParameter("center"); %>

  <div id="mystyle" class="myform"> <h1> Appointment Id:  <%=appId %>  </h1>
  <p> Doctor Name: <%=doctorName%> </p> 
  <form name="feed" action="AppointmentServlet"  method="POST"> 
  <input type="hidden" name="command" value="feedback" id="command"/>
  <table> 
   <tr>  <td style="border-Color:white;">  
                  <label>Name of the Patient </label>
                <input type="text" name="pat" id="pat" value="<%=PatientName%>" readonly /></td> 
               <td style="border-Color:white;"> 
                <label>User Id  </label>
                <input type="text" name="userId" id="userId" value="<%=userId%>" readonly /></td></tr> 
  	<tr> <td style="border-Color:white;"> 
  	  <label>Date of Appointment <span class="small">(DD/MM/YYYY) </span></label>
                <input type="text" name="datepicker" id="datepicker" value="<%=datepicker%>" readonly /></td> 
              <td style="border-Color:white;"> 
    <label>Name of the Clinic </label>
                <input type="text" name="center" id="center" value="<%=CenterName%>" readonly /></td> 
               </tr> 
               <tr> <td> 
         <label>Please leave your Comment here </label>
               <textarea rows="5" cols="36" name="cmmnt" id="cmmnt" style="resize: none;border-color:black;float:left;background-color:lightblue;color:black;" data-role="none"></textarea>
                </td>                
           <td> <label>Will you Recommend this Doctor to others? </label>
	<select  name="reco" id="reco"> 
            
              <% String[] reco={"Y", "N"} ;
             for(int i=0; i<reco.length;i++)    
             {
             %>
             <option><%=reco[i] %></option> 
             <%} %>
           </select>              
</td>  </tr> 
<tr> <td> <input type="submit" value="Post Feedback" name="feedback" id="feedback" />    </td> </tr>  
  </table>
 <input type="hidden"  name="docId" id="appId" value="<%=docId %>"/> 
 <input type="hidden"  name="docN" id="docN" value="<%=doctorName%>" /> 
  <input type="hidden"  name="appId" id="appId" value="<%=appId %>"/> 
 </Form> 
  </div> 
</body>
</html>