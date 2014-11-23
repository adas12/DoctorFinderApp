package com;

import java.awt.Window;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class AppointmentServlet
 */

public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection=null; Statement st=null;ResultSet rs;
	//private final static String user="vacrnexb";
	// private final static String password="zfgapepprifi";
	 private static final String JDBC = "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver";
	// private static final String url = "jdbc:db2://75.126.155.143:50000/I_141263/IBMsql";
	
			
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command=request.getParameter("command");
		
		if(command.equals("fix"))
		{ String docId=request.getParameter("docId");
			String doctorName=request.getParameter("doctorName");
			String CenterName=request.getParameter("CenterName");
			String Centerlocation=request.getParameter("Centerlocation" );
			String  pin= request.getParameter("pin" );
			String shiftId=request.getParameter("shiftId");
			String datepicker=request.getParameter("datepicker");
			String userId=request.getParameter("userId");
			String PatientName=request.getParameter("PatientName");
			String Contact=request.getParameter("Contact");
			String sp= request.getParameter("sp");
			String wkday=request.getParameter("wkday");
			String Tfrm=request.getParameter("Tfrm");
			String Tto=request.getParameter("Tto");
			String sql="INSERT INTO appdetails (shiftId, Date, userId, PatientName,Contact) VALUES (?,?,?,?,?);" ;
		try{
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
 			java.sql.PreparedStatement ps=connection.prepareStatement(sql);
 			ps.setString(1, shiftId);
 			ps.setString(2, datepicker);
 			ps.setString(3, userId);
 			ps.setString(4, PatientName);
 			ps.setString(5, Contact);
 			
 			int i=ps.executeUpdate();
 			String appId=null;
 			if(i>0)
 			{
 				//PreparedStatement pst=(PreparedStatement)connection.prepareStatement("INSERT INTO appdetails (shiftId, Date, userId, PatientName,Contact) VALUES (?,?,?,?,?);"Statement.RETURN_GENERATED_KEYS);
 		Statement st=connection.createStatement();
 		ResultSet rst= st.executeQuery("SELECT LAST_Insert_Id() from appdetails;");
 		while(rst.next()){
 		appId=rst.getString(1);
 		}
 		request.setAttribute("Tfrm",Tfrm);request.setAttribute("Tto",Tto);
 		request.setAttribute("appId", appId); request.setAttribute("docId", docId);
 		request.setAttribute("shiftId",shiftId);
 		request.setAttribute("datepicker", datepicker);
 		request.setAttribute("PatientName", PatientName);
 		request.setAttribute("Contact", Contact);
 		request.setAttribute("doctorName", doctorName);
 		request.setAttribute("CenterName", CenterName);
 		request.setAttribute("Centerlocation", Centerlocation);
 		request.setAttribute("pin", pin);
 		request.setAttribute("sp", sp);
 		request.setAttribute("wkday", wkday);
 		request.setAttribute("userId", userId);
 				RequestDispatcher rd=request.getRequestDispatcher("status.jsp");
 			 	 rd.forward(request,response);
 				
 			}
 			
		connection.close(); ps.close();}
		catch(Exception ew)
		{
			ew.printStackTrace();
		}
			
		}
		if(command.equals("check"))
		{
		String docId= request.getParameter("docId");
	   String shiftId=request.getParameter("shiftId");
		String datepicker= request.getParameter("datepicker");
		
		int count=-1;
		String Sql="select count(*) from appdetails where Date='"+datepicker+"' and shiftId='"+shiftId+"' ;";
		System.out.println(Sql +" before Try block");
		
		try{
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
 			System.out.println("inside Try block");
 			st= connection.createStatement();
 			rs =st.executeQuery(Sql);
 	while(rs.next())
 	{
 	count=Integer.parseInt(rs.getString(1));
 		
 	}
 	if(count> 4)
 	{
 System.out.println("checking checkApp"+count);
 System.out.println("docid is "+docId+" ---- Shift id is "+shiftId+" date is "+datepicker);
 
 		request.setAttribute("ErrorMssg", "No Slot is available , try with different day/centre");
 		 request.setAttribute("docId",docId);

 		RequestDispatcher rd=request.getRequestDispatcher("ViewResultD.jsp");
 	 rd.forward(request,response);
 		//response.sendRedirect("ViewResultD.jsp");
 	}
 	
 	else{
 		request.setAttribute("Mssg", "Slot is available ,Please Login/ Signup ");
 		request.setAttribute("shiftId",shiftId);
 		request.setAttribute("datepicker",datepicker);
 		
 		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
 	 	rd.forward(request,response);
 		
 	}
 	
 	rs.close(); st.close(); connection.close();
	}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		}
		
		if(command.equals("feedback"))
		{
			Date today = new Date();
			String appId=request.getParameter("appId");String userId=request.getParameter("userId");
			String docId=request.getParameter("docId");
			String PatientName=request.getParameter("pat");
			String datepicker= request.getParameter("datepicker");
			String doctorName=request.getParameter("docN");
			String CenterName=request.getParameter("center");
			String reco=request.getParameter("reco");
			String cmmnt=request.getParameter("cmmnt");
			java.sql.PreparedStatement pst=null;
			String Message= "Doctor Name:"+doctorName+" -Patient: "+PatientName+"\n Center: "+CenterName+"\n Appoinment on :"+datepicker+"\n Registration id: "+appId+"\n "+cmmnt;
			String  newMessage=Message+" \n By "+userId+today;
			
			String query="insert into review (reco,docId,User_id,Cmmnt) values(?,?,?,?) ";
			try{
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
	 			 pst=(java.sql.PreparedStatement) connection.prepareStatement(query);
	 			pst.setString(1, reco);
	 			pst.setString(2, docId);
	 			pst.setString(3, userId);
	 			pst.setString(4, newMessage);
	 			
	 			int i=pst.executeUpdate();
	 			if(i>0)
	 			{
	 				System.out.println("fine");
	 			}
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally{
				try {
					pst.close();connection.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
}
}
