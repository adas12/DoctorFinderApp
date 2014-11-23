package com;



import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		dbSearchResult(request,response);
	}

protected void dbSearchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String command=request.getParameter("command");
	if(command.equals("Location"))
	{
		try{
			String pin=request.getParameter("pin");
		
		String locationSql="select * from centreDetails where pin like '%"+pin+"%' ;";
		System.out.println(locationSql);
		ClinicBean cbean=new ClinicBean();
		List<ClinicDetails> CenList=cbean.getSearchResult(locationSql);
	request.setAttribute("cbeanList",CenList);
	RequestDispatcher rd=request.getRequestDispatcher("searchResultC.jsp");
	rd.forward(request,response);
	}
	catch(Exception xception)	
		{
		xception.printStackTrace();
		}
	}
	
	else if(command.equals("doc_detail"))
	{
		String docId=request.getParameter("docId");
		/**String sql="select doctorName,specialization,degree,review,docId from doctordetails where docId='"+docId+"' ;";
		String findDoc="select doctorName,specialization,degree,CenterName,location,wkday,Tfrom,Tto,review,shiftId from shift inner join doctordetails on doctordetails.docId=shift.docId inner join centreDetails on centreDetails.centreId=shift.centreId where doctordetails.docId='"+docId+"' ;";
		DetailsBean db=new DetailsBean();
		List<Details> dt= db.getDoctorDetails(findDoc);
		//DoctorBean dbn=new DoctorBean();
		List<Details> doct= db.getSearchResult(sql);
		request.setAttribute("doct", doct);
		request.setAttribute("dt", dt);**/
		
		request.setAttribute("docId",docId);
		RequestDispatcher rd=request.getRequestDispatcher("ViewResultD.jsp");
		rd.forward(request, response);
		
		
	}
	else 
	{
String search=request.getParameter("search");
try{
	String SearchResult="select doctorName,specialization,degree,count(*) review,doctordetails.docId from BAJAJ_KARABI_IN_IBM_COM.doctordetails inner join BAJAJ_KARABI_IN_IBM_COM.review on doctordetails.docId=review.docId where doctorName like '%"+search+"%' or specialization like '%"+search+"%' group by doctordetails.docId,doctorName,specialization,degree";

	DetailsBean db=new DetailsBean();
	List<Details> dtlist= db.getSearchResult(SearchResult);
	request.setAttribute("dtList",dtlist);
	RequestDispatcher rd=request.getRequestDispatcher("SearchResult.jsp");
	rd.forward(request, response);
}
 catch(Exception exc)
 {
exc.getMessage();exc.printStackTrace();
 } 
	}
}
}
