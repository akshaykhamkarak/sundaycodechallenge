package service;

import exception.ConnectionUtilityException;
import exception.NoStudentFoundException;

public interface AddCourse {

	void getCourseAndStudent();

	void searchStudentByCourseName() throws NoStudentFoundException,ConnectionUtilityException;

	
	
}
