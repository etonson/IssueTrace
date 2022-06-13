<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<%
Cookie[] cookies = request.getCookies();
String user = cookies[cookies.length - 1].getValue();
%>
<meta charset="UTF-8">
<title>選擇你要的功能</title>
</head>
<body>

<table border="1" width="100%" bordercolor="#ffea00">
<tr>
<caption  width="100%"><%=user%> 歡迎回來</caption>
<td width="25%" align="center">建立議題</td>
<td width="25%">
<form action="<%= request.getContextPath() %>/CreateIssue.jsp" method="POST">
<input type="submit" value="送出" size="2045"></form>
</td>

<td width="25%" align="center">代辦事項</td>
<td width="25%">
<form action="<%= request.getContextPath() %>/IssueList.jsp" method="POST">
<input type="submit" value="送出" size="2045"></form>
</td>

</tr>
<tr>
<td width="25%" align="center">回覆清單</td>
<td width="25%">
<form action="<%= request.getContextPath() %>/CourseList.jsp" method="POST">
<input type="submit" value="送出" size="2045"></form>
</td>

<td width="25%" align="center">追蹤事項</td>
<td width="25%">
<form action="<%= request.getContextPath() %>/TraceList.jsp" method="POST">
<input type="submit" value="送出" size="2045"></form>
</td>


</tr>

</table>
</body>

</html>