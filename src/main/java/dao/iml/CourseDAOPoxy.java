package dao.iml;

import java.util.List;

import dao.dao.CourseDAO;
import dao.vo.Course;
import db.conn.DatabaseConnection;

public class CourseDAOPoxy implements CourseDAO {
	private DatabaseConnection dbc;
	private CourseDAOlmp dao = null;

	public CourseDAOPoxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new CourseDAOlmp(dbc.getConnection());
	}

	public boolean doCreate(Course course) throws Exception {
		boolean flag = false;
			flag = dao.doCreate(course);
		dbc.close();
		return flag;
	}

	public List<Course> findAll() throws Exception {
		List<Course> list = dao.findAll();
		dbc.close();
		return list;
	}

	public Course findById(int courseID) throws Exception {
		Course course = dao.findById(courseID);
		dbc.close();
		return course;
	}
}
