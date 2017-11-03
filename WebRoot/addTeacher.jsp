<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">添加 </a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="up" enctype="multipart/form-data" method="post">
    <ul class="shangchuan">
    	<li><label>头像</label><input type="file" name="pic" class="dfinput"/></li>
    	<li><input type="submit" value="上传" class="btn"/></li>
    </ul>
    </form>
    <form action="teacher" method="post">
    <ul class="forminfo">
    	<li><label>相片</label><input name="t_img" type="text" class="dfinput" value="${pic_name}"/></li>
	    <li><label>工号</label><input name="t_id" type="text" onblur="yanzheng(this.value)" class="dfinput" /><span id="vali"></span></li>
	    <li><label>姓名</label><input name="t_name" type="text" class="dfinput" /></li>
	    <li><label>性别</label><cite><input name="t_sex" type="radio" value="" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input name="t_sex" type="radio" value=""
	    />女</cite></li>
	   	<li><label>年龄</label><input name="t_age" type="text" class="dfinput" /></li>
	    
	    
	    
	    <li><label>入职时间</label><input name="t_time" type="text" value="" class="dfinput" /></li>
	   
	   	<li><label>地址</label><input name="t_address" type="text" class="dfinput" /></li>
	   	<li><label>电话</label><input name="t_phoneNum" type="text" class="dfinput" /></li>
	   	
	   	<li><label>生日</label><input name="t_birthday" type="text" class="dfinput" /></li>
	  	<li><label>简介</label><input name="t_about" type="text" class="dfinput" /></li>
	  
	  	
	  	<li>
	  	<input type="hidden" name="struts" value="addTeacher"/></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确定"/></li>
	    
    </ul>
    </form>
    
    </div>
</body>
</html>