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
    
    <form action="teacher" method="post" style="margin-top:100px;padding-left:210px">
    <ul class="forminfo">
	    <li><label>学号</label><input name="s_id" type="text" onblur="yanzheng(this.value)" class="dfinput" /><span id="vali"></span></li>
	    <li><label>课程号</label><input name="ct_id" type="text" class="dfinput" /></li>
	    <li><label>分数</label><cite><input name="g_fenshu" type="text" class="dfinput" /></li>
	  	<li><input type="hidden" name="struts" value="addgrade"/></li>
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="添加"/> 
	    						 <input name="" type="submit" class="btn" value="修改"/></li>
    </ul>
    </form>
    </div>
</body>
</html>