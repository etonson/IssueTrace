package view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import api.login.ApiLogin;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		JSONObject requestData = new JSONObject();
		requestData.put("account", account);
		requestData.put("pwd", pwd);
		ApiLogin apiLogin = new ApiLogin(requestData);

		if(apiLogin.checkExit()==1) 
		{
	        Cookie c=new Cookie("account",account);  
	        c.setMaxAge(60*60); 
	        response.addCookie(c);
			request.setAttribute("account", account);
			request.getRequestDispatcher("/SelectList.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/Login.jsp").forward(request,response);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
