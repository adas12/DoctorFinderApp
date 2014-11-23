package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClinicBean {
	 Statement st=null;ResultSet rs;
   // private static final String url="jdbc:mysql://localhost:3306/doctorfinder";
  //  private static final String user="xyz";
  //  private static final String password= "1234";
    Connection connection=null;
	public List<ClinicDetails> getSearchResult(String locationSql){
		
		List<ClinicDetails> list=new ArrayList<ClinicDetails>();
	try {
		try {
			Class. forName ( "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver"  ); 
			 DBconnection dbc=new  DBconnection();
			connection=(Connection)  dbc.newConnection();
		}
		catch (Exception excc)
		{
			excc.printStackTrace();
		}
		st=connection.createStatement();
		rs=st.executeQuery(locationSql);
		
		while(rs.next())
		{
			ClinicDetails clinic=new ClinicDetails();
			clinic.setCenterName(rs.getString(1));
			clinic.setLocation(rs.getString(2));
			clinic.setPin(rs.getString(3));
			clinic.setDayOp(rs.getString(4));
			clinic.setTimeOp(rs.getString(5));
			clinic.setCentreId(rs.getString(6));
		
			list.add(clinic);
			
		}
	} catch ( Exception e) {
		
		e.printStackTrace();
	}
	finally{
		try{
			rs.close();
			st.close();
			connection.close();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
		
		return list;
		
	}

}
