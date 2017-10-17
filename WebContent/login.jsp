<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h1 class="text-info">
						登陆
					</h1>
				</div>
			</div>
		</div>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-6 column">
			<form class="form-horizontal" role="form" action="login" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" name="username" placeholder="请输入用户名"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码"/>
					</div>
				</div>
				<font size="3" color="red">${hint }</font>	
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">登陆</button>
						 <a href="regist.jsp"><input type="button" value="注册" class="btn btn-default"></a>
					</div>
				</div>
			</form>
			
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>
