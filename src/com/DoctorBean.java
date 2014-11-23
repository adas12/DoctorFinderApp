package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorBean {
	 Connection connection=null; Statement st=null;ResultSet rs;
	// private final static String user="vacrnexb";
	// private final static String password="zfgapepprifi";
 private static final String JDBC = "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver";
	// private static final String url = "jdbc:db2://75.126.155.143:50000/I_141263/IBMsql";
	 	

	    
public List<DoctorDetails> getSearchResult(String SearchResult)
	{
		
		
		List<DoctorDetails> list = new ArrayList<DoctorDetails>();
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
		System.out.println(SearchResult);
		st= connection.createStatement();
		rs =st.executeQuery(SearchResult);
		
		
		
			while(rs.next())
			{
				
				DoctorDetails doctor=new DoctorDetails(); 
				doctor.setDoctorName(rs.getString(1));
				doctor.setSpecialization(rs.getString(2));
				doctor.setDegree(rs.getString(3));
				doctor.setReview(rs.getString(4));
				doctor.setDocId(rs.getString(5));
				list.add(doctor);
			
	
} 	
		
		}
		catch(Exception excep)
		{
			excep.printStackTrace();
		}
		finally {
			try{
				rs.close(); st.close();connection.close();
			}
			catch(Exception except)
			{
				except.printStackTrace();
			}
		}
		return list;
}}
