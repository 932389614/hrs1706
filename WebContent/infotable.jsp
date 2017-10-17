<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Form Pack </title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<h1>Form Pack</h1>
    <h2></h2>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">		
		<table class="table table-striped table-hover">
	      <thead>
	        <tr>
	          <th class="text-center">#</th>
	          <th class="text-center">Form Name</th>
	          <th class="text-center">View</th>
	          <th class="text-center">#</th>
	          <th class="text-center">View</th>
	        </tr>
	      </thead>
	      <tbody id="infoTable">
	        <tr>
	        
	        </tr>	       
	      </tbody>
	    </table>
	     <div align="center">
	      	<td><a href="" id="first"><button class="btn btn-default btn-info">首页</button></a>
	      		<a href="" id="prev"><button class="btn btn-default btn-info">上一页</button></a>
	      		<a href="" id="next"><button class="btn btn-default btn-info">下一页</button></a>
	      		<a href="" id="last"><button class="btn btn-default btn-info">末页</button></a>
	      	</td>
	     </div>
		</div>
	</div>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

	<script>
	function deleteEmp(no){
		if(confirm("ç¡®å®å¼é¤åå·¥åï¼")){		
			$.ajax({
				url:'emp?method=delete&no='+no,
				success:function(data) {
					if(data.indexOf('success')>=0){		
						$("#status"+no).text("ç¦»è");
					}
				} 
			});
		}
	}	
	</script>
	<script>
	
	function loadDataModel(page){
		$.getJSON('emp',{page:page,method:'deptAjaxEmpList'},function(data){
			loadPgeInfo(data);
		});
	};
	
	</script>
	<script>
	$(function(){		
		$.getJSON('emp',{page:1,method:'deptAjaxEmpList'},function(data){
			loadPgeInfo(data);					
		});
	});
	function loadPgeInfo(data){
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
		$("#infoTable tr").remove();
		var empList=data.dataModel;
		if(empList!=null)
		for(var i=0;i<empList.length;i++){
			var emp=empList[i];				
			var tr=$("<tr>")
				.append($("<td>").text(emp.no))
				.append($("<td>").append($("<a>").text(emp.name).attr("href","")))
				.append($("<td>").text(emp.sex))
				.append($("<td>").text(emp.job))
				.append($("<td>").text(emp.status).attr("id", ""))
				.append($("<td>").text(emp.tel))
				.append($("<td>")
						.append($("<a>").attr("href","")
								.append($("<button>").text("修改").attr("class","btn btn-default btn-info")))
						.append($("<a>").attr("href","")
								.append($("<button>").text("删除").attr("class","btn btn-default btn-danger")))
				);
			$("#infoTable").append(tr);					
		}
	}
	</script>
</body>
</html>