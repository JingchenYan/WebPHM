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

	<title></title>

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
		.div_list {
			width: 75%;
			margin: 0 auto;
			margin-top: 50px;
			margin-left: 20%;

		}
		.div_list1 {
			width: 75%;
			margin: 0 auto;
			margin-top: 20px;
			margin-left: 20%;
		}

		font {
			color: red;
			font-weight: bold;
			text-align: center;
		}
		#tableClass{
			margin:0 auto;
			width: 100%

		}
		table tr td{
			text-align: center;
			width:150px;
			height:40px;
		}
		a{
			text-decoration: none;
			cursor:pointer;
		}
		.form1{
			width: 200px;
			display: inline-block
		}
	</style>
	<script type="text/javascript">

		function page(s){
			var frm=document.getElementById("frm");
			var pageNo=document.getElementById("pageNo");
			pageNo.value=s;
			frm.submit();
		}
	</script>
</head>

<body>
<form action="stu.ServletSearchCTCF" method="post" id="frm">
	<div class="div_list">
		设备名称：<input type="text" class="form-control form1"   name="CTCFName" value="${ctcf.getCTCFName()}" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" class="btn btn-primary" value="查询" />
	</div>
</form>
<form action="stu.ServletFindAllCTCF" method="post" id="frm1">
	<div class="div_list1 panel panel-default">
			<div class="panel-heading">故障信息</div>
		<table class="table panel-body" id="tableClass">
			<tr>
				<td>设备名称</td>
				<td>故障日期</td>
				<td style="width: 500px;">故障类型</td>
			</tr>
			<c:forEach var="list" items="${list.pbjs }">
				<tr>
					<td>${list.getCTCFName() }</td>
					<td>${list.getCTCFDate() }</td>
					<td style="width: 500px;">${list.getCTCFault() }</td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a onclick="page(1);">首页</a>
					<c:if test="${list.isPrevious() }">
						<a onclick="page(${list.pageNo-1});">上一页</a>
					</c:if>
					<c:if test="${(list.pageNo+1)<list.totalPage }">
						<a onclick="page(${list.pageNo+1 });">${list.pageNo+1 }</a>
					</c:if>
					<c:if test="${(list.pageNo+2)<list.totalPage }">
						<a onclick="page(${list.pageNo+2 });">${list.pageNo+2 }</a>
					</c:if>
					<c:if test="${list.isNext() }">
						<a onclick="page(${list.pageNo+1});">下一页</a>
					</c:if>
					<a onclick="page(${list.totalPage });">最后一页</a> <br />
					跳转到：<input class="form-control form1" id="pageNo" type="text" name="pageNo" value="${list.pageNo}" />
					<input class="btn btn-primary" type="submit" value="跳转" />

					每页记录数：<input type="text" name="pageCount" class="form-control form1" value="${list.pageCount}" />
					<input class="btn btn-primary" type="submit" value="修改记录数" />

					共有${list.totalPage}页</td>
			</tr>
		</table>
	</div>
	</div>
</form>
</body>
</html>
