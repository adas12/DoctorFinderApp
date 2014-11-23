<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="home.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
 <center> <img src="Logo.png"/> </center>
 <br/> <br/> 
<center>
<table style="width:650px;"> <div id="wrapper">
<tr> <td style="width:300px;"> 

<a href="SearchDoctorForm.jsp" onClick='showPopup(this.href);return(false);'><h1> Find Doctor here </h1> </a>

<div id="left"> </div>
</td> 

<td style="width:300px;">  
 <a href="SearchClinicForm.jsp" onClick='showPopup(this.href);return(false);'><h1> Find Clinic nearest to you </h1>
<div id="middle"> </div> 
</td> </tr> 
</div> </table> 

</center>
<script type="text/javascript">
function showPopup(url) {
newwindow=window.open(url,'name','height=190,width=520,top=200,left=300,resizable');
if (window.focus) {newwindow.focus()}
}
</script>
</body>
</html>