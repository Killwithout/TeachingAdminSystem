<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<style>

</style>

</head>

<body style="background:url(images/topbg.gif) repeat-x;">

<div style="width:85px;height:85px; border:1px solid red; position:absolute;z-index:1; margin-left:50px;">
	<img src="images/sjcr.jpg" width="80" height="88"/>
</div>

   <div class="topleft"><img src="images/loginlogo.png" title="系统首页" /> 
    </div>     
    <div class="topright">    
    <ul>
    <li><a>你是第${count}位访问此网站</a></li>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="fangke?struts=fangke" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>欢迎</span>
    <i>${name}  &nbsp;&nbsp;登录</i>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>
</body>
</html>
