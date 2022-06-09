<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.vo.Issue"%>
<%@ page import="dao.factory.DAOFactory"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回覆列表</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/IssueList" method="POST">

<table border="1" width="100%" bordercolor="#caeb46">

<p>
<input type="text" value="輸入議題編號" name="issueID" width="30%"><input type="submit" value="送出" name="B1" width="30%">
<input type="reset" value="重新輸入" name="B2" width="30%">
</p>

<tr>
<td width="7%" align="center">議題編號</td>
<td width="22%" align="center">議題名稱</td>
<td width="22%" align="center">指派者</td>
<td width="22%" align="center">開始時間</td>
<td width="22%" align="center">結案時間</td>
<td width="5%" align="center">狀態</td>
</tr>
			<%
			try {
				Cookie[] cookies = request.getCookies();
				String recipient = cookies[cookies.length - 1].getValue();
				List<Issue> list = new ArrayList<Issue>();
				list = DAOFactory.getIssueInstance().findAllByRecipient(recipient);
				for (int i = 0; i < list.size(); i++) {
					out.println("<tr>");
					out.println("<td width='7%' align='center'>");
					out.println(String.valueOf(list.get(i).getIssueID()));
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(list.get(i).getiIssueTitle());
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(list.get(i).getAssigness());
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(list.get(i).getStartDate());
					out.println("</td>");

					out.println("<td width='22%' align='center'>");
					out.println(list.get(i).getDeadDate());
					out.println("</td>");

					out.println("<td width='5%' align='center'>");
					out.println(String.valueOf(list.get(i).getStatus()));
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