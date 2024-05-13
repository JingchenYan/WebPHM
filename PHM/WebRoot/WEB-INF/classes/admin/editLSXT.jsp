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
	<form action="ServletEditLSXT" method="post">
	
		<div class="div_ads">
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>设备编号：</td>
					<td><input type="text" name="LSXTID" class="form-control" value="${list.getLSXTID() }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>设备名称：</td>
					<td><input type="text" name="LSXTName" class="form-control" value="${list.getLSXTName() }" /></td>
				</tr>
				<tr>
					<td>出厂日期：</td>
					<td><input type="date"  name="LSXTMDate" class="form-control" value="${list.getLSXTMDate() }" /></td>
				</tr>
				<tr>
					<td>安装日期：</td>
					<td><input type="date" name="LSXTIDate" class="form-control" value="${list.getLSXTIDate() }" /></td>
				</tr>
				<tr>
					<td>健康状态：</td>
					<td>
						<select name="LSXTHealth" class="form-control" value="${list.getLSXTHealth() }">
							<option value="健康">健康</option>
							<option value="故障">故障</option>
						</select>
					</td>
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
