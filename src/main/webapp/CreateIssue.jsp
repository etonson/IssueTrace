<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title>建立議題</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/CreateIssue" method="POST">

<table border="1" width="100%" bordercolor="#caeb46">

<tr>
<td width="25%" align="center">議題標題:</td>
<td width="25%"><input type="text" name="issueTitle" size="20"></td>
<td width="25%" align="center">指派於</td>
<td width="25%"><input type="text" name="recipient" size="20"></td>
</tr>

<tr>
<td width="25%" align="center">啟用日期:</td>
<td width="25%"><input type="date" name="startDate" size="20"></td>
<td width="25%" align="center">完成日期:</td>
<td width="25%"><input type="date" name="deadtDate">
</tr>

<tr>
<td width="25%" align="center">議題描述:</td>
<td width="75%" colspan="3"><textarea rows="3" name="issueDescribe" cols="54"></textarea></td>
</tr>

</table>
<p><input type="submit" value="送出" name="B1">
<input type="reset" value="重新輸入" name="B2"></p>
</form>
</body>
</html>