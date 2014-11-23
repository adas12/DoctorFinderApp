package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import com.ibm.db2.jcc.DB2SimpleDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;

public class DBconnection {
	private String databaseHost = "localhost";
	private int port = 50000;
	private String databaseName = "mydb";
	private String user = "myuser";
	private String password = "mypass";
	private String url = "myurl";

	
	public Connection newConnection()
	{
		if (processVCAP()) {
		Connection connection=null;
		try {
			
			DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
			dataSource.setServerName(databaseHost);
			dataSource.setPortNumber(port);
			dataSource.setDatabaseName(databaseName);
			dataSource.setUser(user);
			dataSource.setPassword (password);
			dataSource.setDriverType(4);
			connection=dataSource.getConnection();
			
			//connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return connection;
		}
		else return null;
		
	}
	private boolean processVCAP() {
		// VCAP_SERVICES is a system environment variable
		// Parse it to obtain the for DB2 connection info
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		
		if (VCAP_SERVICES != null) {
			// parse the VCAP JSON structure
			BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
			String thekey = null;
			Set<String> keys = obj.keySet();
			
			// Look for the VCAP key that holds the SQLDB information
			for (String eachkey : keys) {
				
				// Just in case the service name gets changed to lower case in the future, use toUpperCase
				if (eachkey.toUpperCase().contains("SQLDB")) {
					thekey = eachkey;
				}
			}
			if (thekey == null) {
				
				return false;
			}
			BasicDBList list = (BasicDBList) obj.get(thekey);
			obj = (BasicDBObject) list.get("0");
			
			// parse all the credentials from the vcap env variable
			obj = (BasicDBObject) obj.get("credentials");
			databaseHost = (String) obj.get("host");
			databaseName = (String) obj.get("db");
			port = (int)obj.get("port");
			user = (String) obj.get("username");
			password = (String) obj.get("password");
			url = (String) obj.get("jdbcurl");
		} else {
			
			return false;
		}
		return true;
}
}
