<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/font-awesome.css">
  <link rel="stylesheet" href="css/nprogress.css">
  <link rel="stylesheet" href="css/admin.css">
  <script src="js/nprogress.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
body {
	overflow: hidden;
}
.navbar {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100px;
	margin: 0;
	background-image: linear-gradient(#82a2a8 20%, #727e8f 70%);
	position: relative;
}
.navbar ul{
	width: 100%;
	height: 100px;
	position: relative;

}
.title {
	font-size: 40px;
	color: aliceblue;
	margin-right: -150px;
}

.logout {
	position: absolute;
	right: 10px;
	top: 10px;
	font-size: 16px;
	color: aliceblue;
}

.logout a {
	color: aliceblue;
	text-decoration: none;
}
</style>

<script type="text/javaScript" src="js/jquery-1.8.1.js"></script>
<script>
window.onload = function(){
	var oUl = document.getElementsByClassName('nav')[0];
	var aLi = oUl.getElementsByTagName('li');
	for(var i=0;i<aLi.length;i++){
		aLi[i].onclick = function(){
			for(var j in aLi){
				aLi[j].className = '';
			}
			this.className='active';
		}
		
	}
}
</script>
</head>

<body>
	<div class="div_body">
		<nav class="navbar">
			<div class="title">轨道交通信号设备健康管理系统</div>
			<div class="logout"><a href="ServletLogout">退出</a></div>
		</nav>

		<div class="aside">
			<div class="profile">
				<img class="avatar" src="images/pic.jpg">
				<h3 class="name">${username}</h3>
			</div>
			<ul class="nav">
				<li>
      				<a href="ServletselectPwd" target="mainRight"><i class="fa fa-dashboard"></i>个人信息</a>
    			</li>

				<li>
					<a href="#menu-XHJ" data-toggle="collapse">
						<i class="fa fa-cogs"></i>信号机<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-XHJ" class="collapse">
						<li><a href="ServletFindAllXHJ" target="mainRight">设备信息</a></li>
						<li><a href="admin/addXHJ.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllXHJF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addXHJF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

				<li>
					<a href="#menu-DC" data-toggle="collapse">
						<i class="fa fa-cogs"></i>道岔<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-DC" class="collapse">
						<li><a href="ServletFindAllDC" target="mainRight">设备信息</a></li>
						<li><a href="admin/addDC.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllDCF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addDCF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

				<li>
					<a href="#menu-GDQD" data-toggle="collapse">
						<i class="fa fa-cogs"></i>股道区段<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-GDQD" class="collapse">
						<li><a href="ServletFindAllGDQD" target="mainRight">设备信息</a></li>
						<li><a href="admin/addGDQD.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllGDQDF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addGDQDF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

				<li>
					<a href="#menu-YDQ" data-toggle="collapse">
						<i class="fa fa-cogs"></i>应答器<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-YDQ" class="collapse">
						<li><a href="ServletFindAllYDQ" target="mainRight">设备信息</a></li>
						<li><a href="admin/addYDQ.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllYDQF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addYDQF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

				<li>
					<a href="#menu-LSXT" data-toggle="collapse">
						<i class="fa fa-cogs"></i>联锁系统<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-LSXT" class="collapse">
						<li><a href="ServletFindAllLSXT" target="mainRight">设备信息</a></li>
						<li><a href="admin/addLSXT.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllLSXTF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addLSXTF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

				<li>
					<a href="#menu-CTC" data-toggle="collapse">
						<i class="fa fa-cogs"></i>CTC系统<i class="fa fa-angle-right"></i>
					</a>
					<ul id="menu-CTC" class="collapse">
						<li><a href="ServletFindAllCTC" target="mainRight">设备信息</a></li>
						<li><a href="admin/addCTC.jsp" target="mainRight">添加设备</a></li>
						<li><a href="ServletFindAllCTCF" target="mainRight">故障信息</a></li>
						<li><a href="admin/addCTCF.jsp" target="mainRight">添加故障</a></li>
					</ul>
				</li>

                <li>
                    <a href="#menu-stu" data-toggle="collapse">
                        <i class="fa fa-bug"></i>学生管理<i class="fa fa-angle-right"></i>
                    </a>
                    <ul id="menu-stu" class="collapse">
                        <li><a href="ServletFindAllStu" target="mainRight">查询学生信息</a></li>
                        <li><a href="admin/addStudent.jsp" target="mainRight">添加学生信息</a></li>
                    </ul>                    
                </li>
                
                <li>
                	<a href="PageServlet" target="mainRight"><i class="fa fa-bank"></i>查询所有账号</a>
                </li>       
			</ul>
		</div>
		<div class="div_right">
			<iframe frameBorder="0" id="main" 
			name="mainRight" scrolling="yes" src="main.jsp"
			style="HEIGHT:130%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1"></iframe>
		</div>
	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>