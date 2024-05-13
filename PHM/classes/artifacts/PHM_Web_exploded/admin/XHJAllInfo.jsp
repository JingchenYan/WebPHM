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
	var frm1=document.getElementById("frm1");
	var pageNo=document.getElementById("pageNo");
	pageNo.value=s;
	frm.submit();
	frm1.submit();
}
</script>
  </head>
  
  <body>
  <form action="ServletSearchXHJ" method="post" id="frm">
	  <div class="div_list">
		  设备名称：<input type="text" class="form-control form1"   name="XHJName" value="${xhj.getXHJName()}" />&nbsp;&nbsp;&nbsp;&nbsp;
		  <input type="submit" class="btn btn-primary" value="查询" />
	  </div>
  </form>
    <form action="ServletFindAllXHJ" method="post" id="frm1">
    <div class="div_list1 panel panel-default">
				<div class="panel-heading">设备信息</div>
		<table class="table panel-body" id="tableClass">
			<tr>
				<td>设备名称</td>
				<td>出厂日期</td>
				<td>安装日期</td>
				<td>健康状态</td>
				<td>预测故障信息</td>
				<td>操作</td>
			</tr>
			<c:forEach var="list" items="${list.pbjs }">
			<tr>
				<td>${list.getXHJName() }</td>
				<td>${list.getXHJMDate() }</td>
				<td>${list.getXHJIDate() }</td>
				<td>${list.getXHJHealth() }</td>
				<td><a href="ServletSearchXHJP?XHJPName=${list.getXHJName() }">查看</a>
					<button type="button" id="predictButton">预测</button>
					<span id="loadingIndicator" style="display:none;">正在预测...</span>
				</td>
				<td><a href="ServletSelectXHJ?XHJID=${list.getXHJID() }">修改</a>&nbsp;&nbsp;&nbsp;<a href="ServletDeleteXHJ?XHJID=${list.getXHJID() }" onclick="return confirm('是否确认删除？')">删除</a></td>

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
		<script>
			document.getElementById('predictButton').addEventListener('click', function() {
				var button = this;
				button.disabled = true;  // 禁用按钮，防止重复点击

				fetch('/PHM/XHJPHMServlet', {
					method: 'GET'
				})
						.then(response => {
							if (!response.ok) {
								throw new Error('Failed to fetch: ' + response.statusText);
							}
							return response.text();  // 获取响应文本
						})
						.then(data => {
							alert('脚本运行完成: ' + data);  // 显示脚本运行结果
							button.disabled = false;  // 重新启用按钮
						})
						.catch(error => {
							console.error('Error:', error);
							alert('Failed to predict: ' + error.message);
							button.disabled = false;  // 出错时重新启用按钮
						});
			});
		</script>

	</form>
  </body>
</html>
