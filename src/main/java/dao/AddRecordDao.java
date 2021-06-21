package dao;

import java.util.List;

import exception.ConnectionUtilityException;
import exception.NoStudentFoundException;
import model.Course;
import model.Student;

public interface AddRecordDao {

	int addCourseAndStudent(Course c);

	List<Student> getStudentListByCourseName(String coursenam,int totalmark) throws NoStudentFoundException, ConnectionUtilityException;

}
