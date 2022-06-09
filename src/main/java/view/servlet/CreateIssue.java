package view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import dao.vo.Issue;

@WebServlet("/CreateIssue")
public class CreateIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateIssue() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			Cookie[] cookies = request.getCookies();
			String issueTitle = request.getParameter("issueTitle");
			String recipient = request.getParameter("recipient");
			String startDate = request.getParameter("startDate");
			String deadtDate = request.getParameter("deadtDate");
			String issueDescribe = request.getParameter("issueDescribe");
			int status = 1;
			String assigness = cookies[cookies.length - 1].getValue();
			Issue issue = new Issue();
			
			issue.setAssigness(assigness);
			issue.setDeadDate(deadtDate);
			issue.setIssueDescribe(issueDescribe);
			issue.setIssueTitle(issueTitle);
			issue.setRecipient(recipient);
			issue.setStartDate(startDate);
			issue.setStatus(status);
			DAOFactory.getIssueInstance().doCreate(issue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
