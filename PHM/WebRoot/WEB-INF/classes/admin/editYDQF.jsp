<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
.div_ads {
	width: 75%;
	margin: 0 auto;
	margin-top: 50px;
	margin-left: 10%;
}
table {
	margin: 0 auto;
	width: 100%
}

table tr td {
	text-align: center;
	width:50%;
	height:50px;
}
</style>
</head>

<body>
	<form action="ServletEditYDQF" method="post">
	
		<div class="div_ads">
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>故障编号：</td>
					<td><input type="text" name="YDQFID" class="form-control" value="${list.getYDQFID() }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>设备名称：</td>
					<td><input type="text" name="YDQFName" class="form-control" value="${list.getYDQFName() }" /></td>
				</tr>
				<tr>
					<td>故障日期：</td>
					<td><input type="date"  name="YDQFDate" class="form-control" value="${list.getYDQFDate() }" /></td>
				</tr>
				<tr>
					<td>故障信息：</td>
					<td><input type="text" name="YDQFault" class="form-control" value="${list.getYDQFault() }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="修改" class="btn btn-primary" /></td>
					<td><input type="reset" value="清空" class="btn btn-danger" /></td>
				</tr>
			</table>
			</c:forEach>
		</div>
	</form>
</body>
</html>
