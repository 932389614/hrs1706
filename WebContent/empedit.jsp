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
			<div class="col-md-8 column">
				<h1>
					修改员工信息
				</h1>
			</div>
			<div class="col-md-4 column">
				<div class="btn-group btn-group-sm">
					 <a href="dept?method=list"><button class="btn btn-default" type="button">部门</button> </a>
					 <a href="emp?method=deptEmpList&deptno=${dept.no }&page=1"><button class="btn btn-default" type="button">返回</button> </a>
					  <a href="logoff"><button class="btn btn-default" type="button">注销</button> </a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
				</div>
				<div class="col-md-6 column">
				${hint }
				<form role="form" action="emp" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<input type="hidden" name="deptno" value="${dept.no}" >
						<input type="hidden" name="method" value="updateemp">
						 <label for="exampleInputEmail1">编号</label>
						 <input type="text" class="form-control" id="exampleInputEmail1" name="no"  value="${emp.no }" required placeholder="请输入员工编号" onfocus="this.blur()"/>
					
						 <label for="exampleInputPassword1">姓名</label>
						 <input type="text" class="form-control" id="exampleInputPassword1"  name="name" value="${emp.name }" required placeholder="请输入员工姓名"/>
					
						<label for="exampleInputPassword1">性别</label>
						<input type="radio" name="sex" value="1" ${emp.sex?'checked':''}>男
						<input type="radio" name="sex" value="0" ${emp.sex?'':'checked'}>女
					
						 <label for="exampleInputPassword1">职位</label>
						 <input type="text" class="form-control" id="exampleInputPassword1" name="job" value="${emp.job }" required placeholder="请输入员工职位"/>
					
						 <label for="exampleInputPassword1">主管</label>
						 <input type="text" class="form-control" id="exampleInputPassword1" value="${emp.mgr.no }"/>
					
						 <label for="exampleInputPassword1">工资</label>
						 <input type="text" class="form-control" id="exampleInputPassword1" name="salary" value="${emp.salary }" required placeholder="请输入员工工资"/>
					
						 <label for="exampleInputPassword1">入职时间</label>
						 <input type="date" name="hirdate"  value="${emp.hirDate }"><br>
					
						 <label for="exampleInputPassword1">头像</label>
						 <image src="images/${emp.photo}" alt="" id="photoPreview"width="150">
						 <input type="file" id="exampleInputFile" name="photo"  id="photo" value="${emp.photo }" />
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">电话</label>
						 <input type="text" class="form-control" id="exampleInputPassword1"  value="${emp.hirDate }" name="tel" required placeholder="请输入员工电话"/>
					</div>
					<button type="submit" class="btn btn-sm">确定</button>
					<input type="reset" class="btn btn-sm">
				</form>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>