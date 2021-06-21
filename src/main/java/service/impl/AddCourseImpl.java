package service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.AddRecordDao;
import dao.impl.AddRecordDaoImpl;
import exception.ConnectionUtilityException;
import exception.NoStudentFoundException;
import model.Course;
import model.Student;
import service.AddCourse;

public class AddCourseImpl implements AddCourse {

	AddRecordDao addrecdao;

	public AddCourseImpl() {
		super();
		addrecdao = new AddRecordDaoImpl();

	}

	static Scanner sc = new Scanner(System.in);

	public void getCourseAndStudent() {
		int cid, totalmark, id;
		String cname, name, gender;
		List<Student> students = new ArrayList<Student>();

		System.out.println("Enter the course id:");
		cid = sc.nextInt();
		System.out.println("Enter the course name");
		cname = sc.next();
		System.out.println("Enter the totalmark:");
		totalmark = sc.nextInt();
		System.out.println("Enter the how many student you want to join with " + cname + " course");
		int studentcount = sc.nextInt();
		for (int i = 0; i < studentcount; i++) {
			Student s = new Student();
			System.out.println("Enter the student id.");
			s.setId(id = sc.nextInt());
			System.out.println("Enter the student name");
			s.setName(name = sc.next());
			System.out.println("Enter the student gender");
			s.setGender(gender = sc.next());
			students.add(s);
		}
		System.out.println(students.size());

		Course c = new Course(cid, cname, totalmark, students);
		try {
			int result = addrecdao.addCourseAndStudent(c);
			if (result == 1) {
				System.out.println("Record inserted successful");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void searchStudentByCourseName() throws NoStudentFoundException, ConnectionUtilityException {
		String coursename = "";
		int totalmark = 0;
		System.out.println("Enter the course name to get all student with that course");
		coursename = sc.next();
		System.out.println("Mark");
		totalmark = sc.nextInt();

		try {
			List<Student> studentlist = addrecdao.getStudentListByCourseName(coursename, totalmark);
			for (Student s : studentlist) {
				System.out.println("Student name: " + s.getName());
				
			}

		} catch (NoStudentFoundException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
