package dao.factory;

import dao.dao.CourseDAO;
import dao.dao.IssueDAO;
import dao.dao.TaskForceDAO;
import dao.dao.UserDAO;
import dao.iml.CourseDAOPoxy;
import dao.iml.IssueDAOPoxy;
import dao.iml.TaskForceDAOPoxy;
import dao.iml.UserDAOProxy;

public class DAOFactory {
	public static UserDAO getInstance() {
		UserDAO dao = null;
		try {
			dao = new UserDAOProxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static IssueDAO getIssueInstance() {
		IssueDAO dao = null;
		try {
			dao = new IssueDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static TaskForceDAO getTaskForceInstance() {
		TaskForceDAO dao = null;
		try {
			dao = new TaskForceDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	public static CourseDAO getCourseInstance() {
		CourseDAO dao = null;
		try {
			dao = new CourseDAOPoxy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
}