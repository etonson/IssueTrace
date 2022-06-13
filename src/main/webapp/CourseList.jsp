<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.factory.DAOFactory"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import ="org.json.JSONArray"%>
<%@ page import ="org.json.JSONObject"%>
<%@ page import ="api.mutiltable.MutilTable"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回覆列表</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/ResponseCourse.jsp" method="POST">

<table border="1" width="100%" bordercolor="#caeb46">

<p>
<input type="text" value="輸入回覆編號" name="courseID" width="30%"><input type="submit" value="送出" name="B1" width="30%">
<input type="reset" value="重新輸入" name="B2" width="30%">
</p>

<tr>
<td width="7%" align="center">回覆編號</td>
<td width="7%" align="center">議題編號</td>
<td width="22%" align="center">議題名稱</td>
<td width="22%" align="center">指派者</td>
<td width="22%" align="center">回覆時間</td>
</tr>
			<%
			try {
				Cookie[] cookies = request.getCookies();
				String recipient = cookies[cookies.length - 1].getValue();
				MutilTable mt = new MutilTable();
				JSONArray ja = mt.findCourseListByRecipient(recipient);
				JSONObject obj=null; 
				for (int i = 0; i < ja.length(); i++) {
					obj = new JSONObject();
					obj = ja.getJSONObject(i);
					out.println("<tr>");
					out.println("<td width='7%' align='center'>");
					out.println(String.valueOf(obj.get("courseID")));
					out.println("</td>");
					
					out.println("<td width='7%' align='center'>");
					out.println(String.valueOf(obj.get("issueID")));
					out.println("</td>");
					
					out.println("<td width='22%' align='center'>");
					out.println(String.valueOf(obj.get("issueTitle")));
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(String.valueOf(obj.get("assigness")));
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(String.valueOf(obj.get("replyDate")));
					out.println("</td>");

					out.println("</td>");
					out.println("</tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			%>

</table>

</form>
</body>
</html>