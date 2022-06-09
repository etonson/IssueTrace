package api.course;

import java.sql.Date;

import dao.factory.DAOFactory;
import dao.vo.Course;

public class ApiCourse {
	public ApiCourse() {
	}

	public void createCourseReply(String reply, int issueID) {
		long miliseconds = System.currentTimeMillis();
		Date date = new Date(miliseconds);
		System.out.println(date);
		Course course = new Course();
		try {
			course.setIssueID(issueID);
			course.setReplyDate(date.toString());
			course.setReply(reply);
			DAOFactory.getCourseInstance().doCreate(course);
		} catch (Exception e) {
			e.printStackTrace();
		}}

}
