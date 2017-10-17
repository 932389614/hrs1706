<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
			<h1>
				${empty editdept?'添加':'修改'}部门
			</h1>
		</div>
		<div class="col-md-4 column">
			<div class="btn-group btn-group-sm">
				 <a href="dept?method=list"><button class="btn btn-default" type="button">部门</button> </a>
				 <a href="logoff"><button class="btn btn-default" type="button">注销</button> </a>
			</div>
		</div>
	</div>
</div>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-6 column">
			<form class="form-horizontal" role="form" action="dept" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">编号</label>
					<div class="col-sm-10">
						<input type="hidden" name="method" value="${empty editdept?'newdept':'update'}">
						<input type="text" class="form-control" id="inputEmail3" name="no" value="${editdept.no }" onfocus="${empty editdept?'':'this.blur()'}" placeholder="请输入部门编号" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" name="name" value="${editdept.name }" placeholder="请输入部门名称"/>
					</div>
				</div>
					<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">所在地</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" name="location" value="${editdept.location }" placeholder="请输入部门所在地"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" class="btn btn-default">

						 <input type="reset" class="btn btn-default">
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