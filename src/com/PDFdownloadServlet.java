package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

 

/**
 * Servlet implementation class PDFdownloadServlet
 */

public class PDFdownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFdownloadServlet() {
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
		
		String docId=request.getParameter("docId");
	    String appId=request.getParameter("appId");
		String PatientName=request.getParameter("PatientName");
		String datepicker= request.getParameter("datepicker");
	    String doctorName=request.getParameter("doctorName");
	    String CenterName=request.getParameter("CenterName");
	    String Centerlocation= request.getParameter("Centerlocation");
	    String pin=request.getParameter("pin");
	    String userId=request.getParameter("userId");
	    String sp=request.getParameter("sp");
	    String wkday=request.getParameter("wkday");
	    String shiftId=request.getParameter("shiftId");
	    String contact=request.getParameter("Contact");
	    String Tfrm=request.getParameter("Tfrm");
		String Tto=request.getParameter("Tto");
		
		ServletOutputStream os = response.getOutputStream();
		  //set the response content type to PDF
		  response.setContentType("application/pdf");
		  //create a new document
		  Document doc = new Document();
		
		
		   try {
			PdfWriter.getInstance(doc, response.getOutputStream());
			 doc.addAuthor(userId);
			   doc.addCreationDate();
			   doc.addProducer();
			   doc.addCreator("DoctorFinder");
			   doc.addTitle("RegistrationPDF");
			   doc.setPageSize(PageSize.LETTER);
			   doc.open();
			   
			   //add a new paragraph
			   doc.add( new Paragraph("Application Slot No: "+appId));
			   doc.add( new Paragraph("Doctor: "+doctorName+"  -"+sp+"("+docId+")"));
			   doc.add(new Paragraph("Patient's Details : "+PatientName+"     "+contact));
			 //  doc.add(new Paragraph("Contact Details: "+));
			   doc.add( new Paragraph("Clinic Name: "+CenterName));
				doc.add( new Paragraph("Address: "+Centerlocation+","+pin));
				doc.add( new Paragraph("Slot Booked: "+datepicker+"    "+wkday));
				doc.add( new Paragraph("Timing : "+Tfrm+"   to    "+Tto));
				
				doc.add( new Paragraph("------- Booked by "+userId));
				doc.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  
	}
}
