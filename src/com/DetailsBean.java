


	package com;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

	public class DetailsBean {

		 Connection connection=null; Statement st=null;ResultSet rs;
		// private final static String user="vacrnexb";
		// private final static String password="zfgapepprifi";
		 private static final String JDBC = "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver";
	//	 private static final String url = "jdbc:db2://75.126.155.143:50000/I_141263/IBMsql";
		 	
		    public Details getAppoinment(String id)
		    {
		    	 Details dt=null;
		    	 String check="Select bookedUser from checkapp where id='"+id+"' ; ";
String query="select doctorName,specialization,degree,CenterName,location,pin,Tfrom,Tto,doctordetails.docId,centredetails.centreId,shiftId,wkday  from doctordetails inner join shift on doctordetails.docId=shift.docId inner join centredetails on centredetails.centreId=shift.centreId where shift.shiftId='"+id+"' ";
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
		 			System.out.println(query);
		 			st= connection.createStatement();
		 			rs =st.executeQuery(query);
		 	while(rs.next())
		 				{ dt=new Details(); 
		 					 dt.setDoctorName(rs.getString(1));
		 					 dt.setSpecialization(rs.getString(2));
		 					 dt.setDegree(rs.getString(3));
		 					 dt.setCenterName(rs.getString(4));
		 					 dt.setLocation(rs.getString(5));
		 					 dt.setPin(rs.getString(6));
		 					 dt.setTfrom(rs.getString(7));
		 					 dt.setTto(rs.getString(8));
		 					 dt.setDocId(rs.getString(9));
		 					 dt.setCentreId(rs.getString(10));
		 					 dt.setId(rs.getString(11));
		 					 dt.setWkday(rs.getString(12));
		 				}
		    	 }
		    	 catch (Exception a)
		    	 {
		    		 a.printStackTrace();
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
				return dt;
		    	
		    }
		    
	public List<Details> getSearchResult(String SearchResult)
		{
			
		//System.out.println(SearchResult);
			//String Sql="select  b.doctorName, b.specialization, b.degree,a.CenterName, a.location  from doctordetails b , centredetails a  where  a.centreId in (select centreId from id_map where docId in (select docId  from doctordetails where doctorname like '%Mr. A%')) and b.docId in (select docId  from doctordetails where doctorname like '%Mr. A%');";
			List<Details> list = new ArrayList<Details>();
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
					
					Details dt=new Details(); 
					dt.setDoctorName(rs.getString(1));
					dt.setSpecialization(rs.getString(2));
					dt.setDegree(rs.getString(3));
				
				dt.setReview(rs.getString(4));
					dt.setDocId(rs.getString(5));
					list.add(dt);
				
		
		
	
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
	}

	public List<Details> getDoctorDetails(String SearchResult)
	{
		List<Details> list = new ArrayList<Details>();
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
				Details	dt=new Details();
			
				dt.setDoctorName(rs.getString(1));
				dt.setSpecialization(rs.getString(2));
				dt.setDegree(rs.getString(3));
				dt.setCenterName(rs.getString(4));
				dt.setLocation(rs.getString(5));
				dt.setWkday(rs.getString(6));
				dt.setTfrom(rs.getString(7));
				dt.setTto(rs.getString(8));
				//dt.setReview(rs.getString(9));
				dt.setId(rs.getString(9));
				list.add(dt);
	}
		}
				catch(Exception x)
				{
					x.printStackTrace();
				}
					finally {
						try{
							rs.close(); st.close();connection.close();
						}
						catch(Exception except)
						{
							except.printStackTrace();
						}
					}return list;
	}
	
	public Details getUserReview(String sql)
	{
		Details dt=null;
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
	 			System.out.println(sql);
	 			st= connection.createStatement();
	 			rs =st.executeQuery(sql);
	 	while(rs.next())
	 	{
	 		
	  dt=new Details(); 
	 				dt.setCommnt(rs.getString(1));
					dt.setUserId(rs.getString(2));
					dt.setUserName(rs.getString(3));
					dt.setSurName(rs.getString(4));
	 				}
	 				
	 				}catch(Exception es)
		 {
	 					es.printStackTrace();
		 }finally {
				try{
					rs.close(); st.close();connection.close();
				}
				catch(Exception except)
				{
					except.printStackTrace();
				}
			}
		 
		return dt;
		
	}
	}
	