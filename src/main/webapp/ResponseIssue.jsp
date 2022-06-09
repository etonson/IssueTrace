<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dao.vo.Issue"%>
<%@ page import="dao.factory.DAOFactory"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>回覆議題</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/ResponseIssue" method="POST">


<table border="1" width="100%" bordercolor="#caeb46">
			<%
			int issueID = 0;
			Issue issue = null;
			try {
				issueID = Integer.parseInt(request.getParameter("issueID"));
				issue = new Issue();
				issue = DAOFactory.getIssueInstance().findById(issueID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			%>
<tr>
<td width="25%" align="center">議題標題:</td>
<td width="75%" align="center"><%=issue.getiIssueTitle()%></td>
</tr>
</table>

		<table border="1" width="100%" bordercolor="#caeb46">

			<tbody>
				<tr style="height: 22px;">
					<td style="width: 50%; height: 110px;" rowspan="4" align="center"><%=issue.getIssueDescribe()%><br></td>
					<td style="width: 50%; height: 110px;">開始時間<br></td>
				</tr>
				<tr style="height: 22px;">
					<td style="width: 50%; height: 110px;"><%=issue.getStartDate()%><br></td>
				</tr>
				<tr style="height: 22px;">
					<td style="width: 50%; height: 110px;">結束時間<br></td>
				</tr>
				<tr style="height: 22px;">
					<td style="width: 50%; height: 110px;"><%=issue.getDeadDate()%><br
						data-mce-bogus="1"></td>
				</tr>
			</tbody>
		</table>

		<table border="1" width="100%" bordercolor="#caeb46">
<tr>
<td width="25%" align="center">議題回覆:</td>
<td width="75%" colspan="3"><textarea rows="3" name="reply" cols="54">請填入回覆內容</textarea></td>
</tr>
</table>

<p><input type="submit" value="送出" name="B1">
<input type="reset" value="重新輸入" name="B2">
<input type="hidden" value=<%=request.getParameter("issueID") %> name="issueID"></p>
</form>
</body>
</html>