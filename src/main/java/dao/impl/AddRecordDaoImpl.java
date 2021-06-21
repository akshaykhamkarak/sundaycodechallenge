package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AddRecordDao;
import exception.ConnectionUtilityException;
import exception.NoStudentFoundException;
import model.Course;
import model.Student;
import utility.DBConnection;

public class AddRecordDaoImpl implements AddRecordDao {

	public int addCourseAndStudent(Course c) {
		int result = 0;
		Connection con = null;

		PreparedStatement ps = null, ps2 = null, ps3 = null;
		try {
			con = DBConnection.getConnection();

			ps = con.prepareStatement("insert into course (cid,cname,totalmark) values(?,?,?)");
			ps.setInt(1, c.getCid());
			ps.setString(2, c.getCname());
			ps.setInt(3, c.getTotalmark());

			 result = ps.executeUpdate();

			ps2 = con.prepareStatement("insert into student (sid,name,gender) values(?,?,?)");
			ps3 = con.prepareStatement("insert into records (sid,cid) values(?,?)");

			for (Student student : c.getStudent()) {
				ps2.setInt(1, student.getId());
				ps2.setString(2, student.getName());
				ps2.setString(3, student.getGender());

				ps2.executeUpdate();
			}

			for (Student student : c.getStudent()) {
				ps3.setInt(1, student.getId());
				ps3.setInt(2, c.getCid());
				ps3.executeUpdate();

			}

		} catch (Exception e) {

		} finally {
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
			}

		}

		return result;
	}

	public List<Student> getStudentListByCourseName(String coursename, int totalmark)
			throws NoStudentFoundException, ConnectionUtilityException {
		List<Student> resultlist = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DBConnection.getConnection();

			ps = con.prepareStatement("select name from student join records on student.sid=records.sid\r\n"
					+ "JOIN course\r\n" + "  ON course.cid = records.cid where course.cname=? and course.totalmark>=?");
			ps.setString(1, coursename);
			ps.setInt(2, totalmark);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();

				student.setName(rs.getString(1));
				
				resultlist.add(student);
			}

			if (resultlist.size() == 0) {
				throw new NoStudentFoundException("No student found..");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		finally {
			try {
				con.close();
				ps.close();

			} catch (SQLException e) {
				
			}
		}

		return resultlist;
	}

}
