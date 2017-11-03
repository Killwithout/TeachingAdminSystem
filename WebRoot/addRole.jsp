<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登录后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="js/jquery.js"></script>
	<script src="js/cloud.js" type="text/javascript"></script>
</script> 
  </head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

	</script>

</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">添加权限</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加职位</span></div>
    <form action="teacher" method="post">
    <input type="hidden" name="struts" value="addRole">
    <ul>
			    职位名称：  <li>
			    		<input type="text" name="r_name" class="dfinput">
                     </li>
 				
                </li>
			    <li>
			    	<input name="option" type="checkbox"  value="a"/>增加
			    	<input name="option" type="checkbox"  value="d"/>删除
			    	<input name="option" type="checkbox"  value="u"/>更改
			    	<input name="option" type="checkbox"  value="s"/>查询
                </li>
			   	 <li style="padding-left:50px; padding-top:10px;">
            
			 	<input name="tijiao" type="submit" class="loginbtn" value="确认添加"/>
			    </li>
		    </ul>
    </form>
 
   
   
    </div>
    
   
    
</body>
</html>
