package com;

public class DoctorDetails {
	
	private String doctorName ;
	private String	specialization;
	private String degree;
	private String docId ;
	private String Review;
	
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public String getDegree() {
		return degree;
	}
	public String getDocId() {
		return docId;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	

}
