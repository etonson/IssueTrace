package view.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.email.SpendEmail;
import api.login.UserInfo;
import dao.factory.DAOFactory;
import dao.vo.Course;
import dao.vo.Issue;
import dao.vo.User;
import email.obj.EmailSessionObj;
import email.obj.MsgObj;

@WebServlet("/ResponseCourse")
public class ResponseCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User assignedUser;
	private User recipientedUser;
	private String issueID;
	private String courseID;
	public ResponseCourse() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		issueID = request.getParameter("issueID");
		courseID=request.getParameter("courseID");
		if(ToEmail()) 
		{
			response.sendRedirect("SelectList.jsp");
		}else 
		{
			response.sendRedirect("FailurePage.jsp");
		}
	}

	private boolean ToEmail() {
		try {
			UserInfo userInfo = new UserInfo();
			Course course = DAOFactory.getCourseInstance().findById(Integer.parseInt(courseID));
			assignedUser = userInfo.getAssignedUserByIssueID(issueID);
			recipientedUser = userInfo.getRecipientedUserByIssueID(issueID);
			Issue issue = DAOFactory.getIssueInstance().findById(Integer.parseInt(issueID));	
			String emailText = "任務名稱為<" + issue.getiIssueTitle() 
								+ ">回復內容如下。 \n" 
								+ course.getReply() 
								+ "\n 若有疑問煩請提出。";
			String toEmail = assignedUser.getEmail();
			String fromEmail = recipientedUser.getEmail();
			String Pwd = recipientedUser.getPwd();
			EmailSessionObj sessionObj = new EmailSessionObj(fromEmail, Pwd);
			MsgObj msgObj = new MsgObj(toEmail, "任務提交", emailText);
			SpendEmail spendDriver = new SpendEmail();
			spendDriver.spendEmail(msgObj, sessionObj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
