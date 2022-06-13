package view.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.email.SpendEmail;
import api.login.UserInfo;
import dao.factory.DAOFactory;
import dao.vo.Issue;
import email.obj.EmailSessionObj;
import email.obj.MsgObj;

@WebServlet("/CreateIssue")
public class CreateIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String issueTitle;
	private String recipient;
	private String startDate;
	private String deadtDate;
	private String issueDescribe;
	private String assigness;

	public CreateIssue() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			Cookie[] cookies = request.getCookies();
			issueTitle = request.getParameter("issueTitle");
			recipient = request.getParameter("recipient");
			startDate = request.getParameter("startDate");
			deadtDate = request.getParameter("deadtDate");
			issueDescribe = request.getParameter("issueDescribe");
			assigness = cookies[cookies.length - 1].getValue();
			int status = 1;

			Issue issue = new Issue();
			issue.setAssigness(assigness);
			issue.setDeadDate(deadtDate);
			issue.setIssueDescribe(issueDescribe);
			issue.setIssueTitle(issueTitle);
			issue.setRecipient(recipient);
			issue.setStartDate(startDate);
			issue.setStatus(status);
			DAOFactory.getIssueInstance().doCreate(issue);

			ToEmail();
			response.sendRedirect("SelectList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("FailurePage.jsp");
			
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("CreateIssue destroy()");
	}

	private void ToEmail() {

		String emailText = assigness + "指派一份任務於" 
						+ recipient + "任務名稱為<" + issueTitle 
						+ ">，內容如下。 \n" + issueDescribe
						+ "\n" + "開始時間:" + startDate + "\n" 
						+ "結束時間:" + deadtDate + "\n" + "若有疑問煩請提出。";
		UserInfo userInfo = new UserInfo();
		String toEmail = userInfo.findEmailByUserId(recipient);
		String fromEmail = userInfo.findEmailByUserId(assigness);
		String assignessPwd = userInfo.findPwdByUserId(assigness);
		EmailSessionObj sessionObj = new EmailSessionObj(fromEmail, assignessPwd);
		MsgObj msgObj = new MsgObj(toEmail, "有一份任務指派", emailText);
		SpendEmail spendDriver = new SpendEmail();
		spendDriver.spendEmail(msgObj, sessionObj);
	}
}
