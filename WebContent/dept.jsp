 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				部门信息
			</h1>
		</div>
		<div class="col-md-4 column">
			<div class="btn-group btn-group-sm">
				 <a href="logoff"><button class="btn btn-default" type="button">注销</button> </a>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<table class="table">
		<tr class="error">
		<th>部门编号</th>
		<th>部门名称</th>
		<th>部门所在地</th> 
		<th>操作</th>
		</tr>
		<c:forEach items="${deptList }" var="dept">
			<tr id="tr${dept.no}" class="info">
				<td>${dept.no }</td>
				<td><a href="emp?method=deptEmpList&deptno=${dept.no}&deptName=${dept.name }&page=1">${dept.name }</a></td>
				<td>${dept.location}</td>
				<td>
			<%-- 	<a href="dept?method=delete&no=${dept.no }">删除</a> --%>
				<a href="javascript:deleteDept(${dept.no })">删除</a>
				<a href="dept?method=edit&no=${dept.no }">修改</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
		<a href="deptadd.jsp"> <button type="button" class="btn btn-default btn-block btn-primary">新增部门</button></a>
		</div>
	</div>
</div>
	
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>
	function deleteDept(no){
		if(confirm("确定删除部门吗？")){			
			$.ajax({
				url:'dept?method=delete&no='+no,
				success:function(data) {
					if(data.indexOf('success')>=0){
						$('#tr'+no).remove();
					}
				}
			});
		}
	}
	</script>
</body>
</html>
