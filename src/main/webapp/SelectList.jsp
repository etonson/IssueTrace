<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>選擇你要的功能</title>
</head>
<body>

<table border="1" width="100%" bordercolor="#ffea00">
<tr>
<caption  width="100%"><%=request.getAttribute("account")%> 歡迎回來</caption>


<td width="25%" align="center">建立議題0</td>
<td width="25%">
<form action="<%= request.getContextPath() %>/CreateIssue.jsp" method="POST">
<input type="submit" value="送出" size="2045"></form>
</td>

<td width="25%" align="center">回覆議題</td>
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

<td width="25%" align="center">未定義</td>
<td width="25%" align="center">未定義</td>


</tr>

</table>
</body>

</html>