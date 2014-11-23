package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	//private final static String user="vacrnexb";
	// private final static String password="zfgapepprifi";
	 private static final String JDBC = "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver";
	// private static final String url = "jdbc:db2://75.126.155.143:50000/I_141263/IBMsql";
	 	
	
protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	
	{ loginRequest (request,response);}


protected void loginRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException

{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); Connection connection = null;
		Statement s=null;
		
		//String U_id= null;
	//	String P_id=null;
		String SN_USER="";
		
		try{
			
			String User_id= request.getParameter("User_Id");
			String P_id=request.getParameter("Pass_Id");
			String shiftId=(String) request.getParameter("shiftId");
			String datepicker= (String)request.getParameter("datepicker");
			Class.forName(JDBC);
			 try {
					Class. forName ( "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver"  ); 
					 DBconnection dbc=new  DBconnection();
					connection=(Connection)  dbc.newConnection();
				}
				catch (Exception excc)
				{
					excc.printStackTrace();
				}
			s= connection.createStatement();
			ResultSet results= s.executeQuery("select User_id, Pass from userdb where User_id='" +User_id+ "'");
			
			
			if(results!=null)
		{
			
		
			while((results.next()))
			{
				if (User_id.equals(results.getString(1)) && P_id.equals(results.getString(2)))
				{
					HttpSession session= request.getSession(true);
					request.removeAttribute("ErrorMssg");
					request.setAttribute("User_id", User_id);
					request.setAttribute("shiftId",shiftId);
					request.setAttribute("datepicker",datepicker);
					
						RequestDispatcher rd= request.getRequestDispatcher("appointment.jsp");
						rd.forward(request, response);
					}
					else  
					{
						request.setAttribute("ErrorMssg", "Invalid Credentials! Please  Try again.  ");
						RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
						rd.forward(request, response);
					}
			}} }	
	catch(Exception e)
					{ 
			e.printStackTrace();
					}
					
		
		finally{
			try{
				if (s!=null) s.close();
				
				connection.close();
			}catch(Exception e)
			{
				
			}
				}
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException

{
  		loginRequest(request,response);

}/*
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException

{
	  loginRequest(request,response);

}  */
	
}
	
