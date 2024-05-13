<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
.div_ads {
	width: 75%;
	margin: 0 auto;
	margin-top: 50px;
	margin-left: 10%;
}

table {
	margin: 0 auto;
	width:100%;
	border-collapse:separate; 
	border-spacing:0px 10px;
}
table tr td {
	text-align: center;
	width:30%;
	height:44px;
	color:rgba(0,0,0,.6)
}
._td{
	width:30%
}
font{
	color:red;
	font-weight: bold;
}
</style>

<script type="text/javascript">
    function check()
   {   
        var date = document.getElementById("tim").value;
        var result = date.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result==null)
        {
            alert("请输入正确的日期格式");
            doucument.getElementById("tim").focus();
            return false;
        }
        
}
    </script>

</head>

<body>
	<form action="ServletaddLSXT" method="post">
	
		<div class="div_ads">
			<table>
				<tr>
					<td>设备名称：</td>
					<td class="_td"><input type="text" name="LSXTName" class="form-control" placeholder="请输入设备名称"/></td>
				</tr>
				<tr>
					<td>出厂日期：</td>
					<td class="_td"><input type="date" name="LSXTMDate" class="form-control" /></td>
				</tr>
				<tr>
					<td>安装日期：</td>
					<td class="_td"><input type="date" name="LSXTIDate" class="form-control" /></td>
				</tr>
				<tr>
					<td>健康状态：</td>
					<td class="_td">
						<select name="LSXTHealth" class="form-control">
							<option value="健康">健康</option>
							<option value="故障">故障</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="添加" class="btn btn-primary" /></td>
					<td><input type="reset" value="清空" class="btn btn-danger" /></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
