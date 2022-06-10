package view.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import dao.vo.Issue;
import dao.vo.User;

@WebServlet("/ResponseCourse")
public class ResponseCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		String issueID = request.getParameter("issueID");
		getAssignEmailByIssueID(issueID);

	}

	private String getAssignEmailByIssueID(String issueID) {
		DAOFactory da = null;
		String assignEmail;
		try {
			Issue issue = new Issue();
			issue = da.getIssueInstance().findById(Integer.parseInt(issueID));
			User user = new User();
			user = da.getInstance().findById(issue.getAssigness());
			assignEmail = user.getEmail();
			System.out.println(assignEmail);
			return assignEmail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "no result";
	}
}
