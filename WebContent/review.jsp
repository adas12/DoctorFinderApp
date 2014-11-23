<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.DetailsBean" %>
<%@page import="com.Details" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String docId=request.getParameter("docId");
String docn=request.getParameter("docn");
//String sp=request.getParameter("sp");
//String degr=request.getParameter("degr");
String sql= "Select cmmnt,review.User_Id,Name,Surname from userdb inner join review on  review.User_Id= userdb.User_Id where review.docId='"+docId+"'";
DetailsBean dbean=new DetailsBean();
Details dt=dbean.getUserReview(sql);
%> 
 <div id="mystyle" class="myform"> 
 <h1> Doctor Name <%=docn %> -  </h1> 
  <p> User Name : <%=dt.getUserName()%> <%=dt.getSurName() %> </p> 
  
  <table> 
   <tr>  <td style="border-Color:white;">  
          <label>User Review</label>
<textarea rows="50" cols="50" name="cmmnt" id="cmmnt" readonly style="resize: none;border-color:black;float:left;background-color:lightblue;color:black;" data-role="none"><%=dt.getCommnt() %></textarea>
                </td> 
               </tr> </table> </div>
</body>
</html>