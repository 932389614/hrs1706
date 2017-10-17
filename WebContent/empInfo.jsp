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
				${emp.name }员工的详细信息
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

	<font size="5">
	<div class="row clearfix">
		<div class="col-md-4 column">	
			<img src="images/${emp.photo }" />
			<dl>
				<dt>
					编号
				</dt>
				<dd>
					${emp.no }
				</dd>
				<dt>
					姓名
				</dt>
				<dd>
					${emp.name }
				</dd>
				<dt>
					性别
				</dt>
				<dd>
					${emp.sex }
				</dd>
				<dt>
					电话
				</dt>
				<dd>
					${emp.tel }
				</dd>
			</dl>
		</div>
		<div class="col-md-8 column">
			<dl>
				<dt>
					所属部门
				</dt>
				<dd>
					${dept.name}
				</dd>
				<br/>
				<dt>
					职位
				</dt>
				
				<dd>
					${emp.job }
				</dd>
				<br/>
				<dt>
					入职时间
				</dt>
				<dd>
					${emp.hirDate }
				</dd>
				<br/>
				<dt>
					状态
				</dt>
				<dd>
					${emp.status?"在职":"离职" }
				</dd>
				<br/>
				<dt>
					工资
				</dt>
				<dd>
					${emp.salary }
				</dd>
				
			</dl>
		</div>
		</font>
	</div>
</div>
</body>
</html>