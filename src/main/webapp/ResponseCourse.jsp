<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONObject"%>
<%@ page import="api.mutiltable.MutilTable"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回覆閱覽</title>
</head>
<%
int courseID = Integer.parseInt(request.getParameter("courseID"));
MutilTable mt = new MutilTable();
JSONObject obj = mt.findCourseListByCourseID(courseID);
%>

<body>
<body>

<table border="1" border="1" width="100%" bordercolor="#caeb46">
	<tbody>
		<tr style="height: 70px;">
			<td colspan="1" rowspan="2" ><%=obj.get("issueTitle") %></td>
			<td width="50%" align="center"><%=obj.get("startDate") %></td>
		</tr>
		<tr style="height: 70px;">
			<td width="50%" align="center"><%=obj.get("replyDate") %></td>
		</tr>
		<tr style="height: 500px;">
			<td width="50%" colspan="1" rowspan="2"><%=obj.get("reply") %></td>
			<td width="50%" colspan="1" rowspan="2"><%=obj.get("issueDescribe") %></td>
		</tr>
	</tbody>

</table>
<form action="<%= request.getContextPath() %>/ResponseCourse" method="POST">
<input type="hidden" value=<%=obj.get("issueID") %> name="issueID" width="30%"><input type="hidden" value=<%=request.getParameter("courseID") %> name="courseID" width="30%">	<input type="submit" value="提交" name="B1">
</form>
<p>&nbsp;</p>
</body>
</html>