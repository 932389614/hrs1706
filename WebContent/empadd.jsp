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
					添加员工
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
							<input type="hidden" name="deptno" value="${dept.no}">
							<input type="hidden" name="method" value="newemp">
							 <label for="exampleInputEmail1">编号</label>
							 <input type="number" class="form-control" id="exampleInputEmail1" name="no" required placeholder="请输入员工编号" />
						
							 <label for="exampleInputPassword1">姓名</label>
							 <input type="text" class="form-control" id="exampleInputPassword1"  name="name" required placeholder="请输入员工姓名"/>
						
							<label for="exampleInputPassword1">性别</label><br>
							<input type="radio" name="sex" value="1" checked>男
							<input type="radio" name="sex" value="0">女
						<br>
							 <label for="exampleInputPassword1">职位</label>
							 <input type="text" class="form-control" id="exampleInputPassword1" name="job" required placeholder="请输入员工职位"/>
						
							 <label for="exampleInputPassword1">主管</label>
							 <input type="number" class="form-control" id="exampleInputPassword1" />
						
							 <label for="exampleInputPassword1">工资</label>
							 <input type="text" class="form-control" id="exampleInputPassword1" name="salary" required placeholder="请输入员工工资"/>
						
							 <label for="exampleInputPassword1">入职时间</label>
							 <input type="date" name="hirdate"><br>
						
							 <label for="exampleInputPassword1">头像</label>
							 <image src="" alt="" id="photoPreview"width="150">
							 <input type="file" id="exampleInputFile" name="photo"  id="photo"/>
						
							 <label for="exampleInputPassword1">电话</label>
							 <input type="text" class="form-control" id="exampleInputPassword1"  name="tel" required placeholder="请输入员工电话"/>
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
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
	//验证用户名
	var regex=/^[a-zA-Z0-9_]{6,20}$/;
	//或var regex=/^\w{6,20}$/;
	var regex=/^[1-9]\d{4,9}$/
	$(function(){
		$('#photo').on('change',function(){
			if(window.FileReader){
				var file=this.files[0];
				if(/image\/\w+/.test(file.type)){
					var fr=new FileReader();
					fr.onloadend=function(evt){
						$('#photoPreview').attr('src',evt.target.result);
					};
					fr.readAsDataURL(this.files[0]);
				}else{
					$('#photoPreview').attr('src','');
					$(this).val('');
					alert("请选择图片文件");
					
				}
			}else{
				alert("你的浏览器不支持文件上传");
			}
		});
	});
	</script>
</body>
</html>