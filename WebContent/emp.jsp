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
				${dept.name }员工信息
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
		<div class="col-md-12 column">
	<table class="table">
		<tr class="info">
		<th>员工编号</th>
		<th>员工姓名</th>
		<th>员工性别</th> 
		<th>员工职位</th>
		<th>员工状态</th>
		<th>员工电话</th> 
		<th>操作</th>
		</tr>
		<tbody id="empInfo">
		</tbody>
		
		</table>
		<div align="center">
	      	<td><a href="" id="first"><button class="btn btn-default btn-info">首页</button></a>
	      		<a href="" id="prev"><button class="btn btn-default btn-info">上一页</button></a>
	      		<a href="" id="next"><button class="btn btn-default btn-info">下一页</button></a>
	      		<a href="" id="last"><button class="btn btn-default btn-info">末页</button></a>
	      	</td>
	     </div>

		<a href="empadd.jsp"><input type="button" value="新增员工" class="btn btn-default btn-block btn-primary"></a>
		
		</div>
	</div>
</div>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

	<script>
	function deleteEmp(no){
		if(confirm("确定开除员工吗？")){		
			$.ajax({
				url:'emp?method=delete&no='+no,
				success:function(data) {
					if(data.indexOf('success')>=0){		
						$("#status"+no).text("离职");
						$("#remove"+no).remove();
					}
				} 
			});
		}
	}	
	</script>
	<script>
	
	function loadDataModel(page){
		$.getJSON('emp',{page:page,method:'deptAjaxEmpList'},function(data){
			if(data.currentPage>1){
				$("#first").attr('href','javascript:loadDataModel(1)');
				$("#prev").attr('href','javascript:loadDataModel('+(data.currentPage-1)+')');
			}
			else{
				$("#first").removeAttr("href");
				$("#prev").removeAttr("href");
			}
			if(data.currentPage<data.totalPage){
				$("#next").attr('href','javascript:loadDataModel('+(data.currentPage+1)+')');
				$("#last").attr('href','javascript:loadDataModel('+(data.totalPage)+')');
			}else{
				$("#next").removeAttr("href");
				$("#last").removeAttr("href");
			}
			$("#empInfo tr").remove();
			var empList=data.dataModel;
			if(empList!=null)
			for(var i=0;i<empList.length;i++){
				var emp=empList[i];				
				var tr=$("<tr>")
					.attr("id","tr"+emp.no)
					.append($("<td>").text(emp.no))
					//.append($("<td>").text(emp.name))
					.append($("<td>").append($("<a>").text(emp.name).attr("href","emp?method=empInfo&no="+emp.no)))
					.append($("<td>").text(emp.sex))
					.append($("<td>").text(emp.job))
					.append($("<td>").text(emp.status).attr("id", "status"+emp.no))
					.append($("<td>").text(emp.tel));
					
				if(emp.status=="在职"){
					tr.append($("<td>")
							.append($("<a>").text("").attr("href","emp?method=edit&no="+emp.no)
									.append($("<button>").text("编辑").attr("class","btn btn-default btn-info")))
							.append($("<a>").text("").attr("href","javascript:deleteEmp("+emp.no+")").attr("id","remove"+emp. no)
									.append($("<button>").text("离职").attr("class","btn btn-default btn-danger")))
					);
				}else{
					tr.append($("<td>")
							.append($("<a>").text("").attr("href","emp?method=edit&no="+emp.no)
									.append($("<button>").text("编辑").attr("class","btn btn-default btn-info")))
					);
				}
				$("#empInfo").append(tr);					
			}
			
		});
	};
	
	</script>
	<script>
	$(function(){		
		loadDataModel(1);
	});
	</script>
	
</body>
</html>