<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入系統</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Login" method="POST">

<table border="1" width="100%" bordercolor="#00FF00">

<tr>

<td width="25%" align="center">輸入帳號:</td>

<td width="25%"><input type="text" name="account" size="20"></td>

<td width="25%" align="center">輸入密碼:</td>

<td width="25%"><input type="password" name="pwd" size="20"></td>

</tr>

</table>

<p><input type="submit" value="送出" name="B1">

<input type="reset" value="重新輸入" name="B2"></p>

</form>

</body>
</html>