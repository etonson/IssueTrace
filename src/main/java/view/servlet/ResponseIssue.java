package view.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.course.ApiCourse;

@WebServlet("/ResponseIssue")
public class ResponseIssue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResponseIssue() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String reply = request.getParameter("reply");
		int issueID = Integer.parseInt(request.getParameter("issueID"));

		ApiCourse ac1 = new ApiCourse();
		ac1.createCourseReply(reply, issueID);
		response.sendRedirect("SelectList.jsp");
	}
}
