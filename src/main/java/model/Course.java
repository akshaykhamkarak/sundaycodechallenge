package model;

import java.util.List;

public class Course {

	private int cid;
	private String cname;
	private int totalmark;
	private List<Student>student;
	
	
	public Course() {
		
	}


	public Course(int cid, String cname, int totalmark, List<Student> student) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.totalmark = totalmark;
		this.student = student;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getTotalmark() {
		return totalmark;
	}


	public void setTotalmark(int totalmark) {
		this.totalmark = totalmark;
	}


	public List<Student> getStudent() {
		return student;
	}


	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
	
}
