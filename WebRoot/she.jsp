<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <li><a href="#">设置权限 </a></li>
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
    	<li><input type="hidden" id="h" name="struts" value="saveRole"></li>
    	<li><input type="hidden" id="h" name="t_id" value="${teac.t_id}"></li>
    	<li><label>相片</label><input name="t_img" type="text" class="dfinput" value="${pic_name}"/></li>
	    <li><label>工号</label>${teac.t_id}</li>
	    <li><label>姓名</label><input name="t_name" type="text" class="dfinput" value="${teac.t_name}"/></li>
	   <li><label>职务</label>	  	
	  		<select name="roleselect" class="dfinput">
			    	<c:forEach items="${roles}" var="role">
			    		<option  value="${role.role_idString}">${role.role_nameString}</option>
			    	</c:forEach> 
			</select>
	  	</li>
	  	
	  	<li>
	  	
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="设置"/></li>
	    
    </ul>
    </form>
    
    
        </div>
</body>
</html>