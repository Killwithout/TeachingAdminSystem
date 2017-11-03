<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>

</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <!--*********************************学生进入*******************************-->
   	<c:if test="${type==1}">
   	<dd>
        <div class="title">
        <span><img src="images/leftico01.png"/></span>信息查询
        </div>
            <ul class="menuson">
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findallstudent" target="rightFrame">个人信息</a><i></i></li>
            <li class="active"><cite></cite><a href="/TeachingAdminSystem/students?struts=findalljiaoshi" target="rightFrame">教室信息</a><i></i></li>
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findallteacher" target="rightFrame">教师查询</a><i></i></li>
            </ul>    
        </dd>
        <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>成绩查询
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findallgrade" target="rightFrame">查看所有成绩</a><i></i></li>
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findalldanke" target="rightFrame" >查看单科成绩</a><i></i></li>
            </ul>     
        </dd> 
        <dd><div class="title"><span><img src="images/leftico03.png" /></span>其他操作</div>
        <ul class="menuson">
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findallxuanke" target="rightFrame">选课</a><i></i></li>
            <li><cite></cite><a href="/TeachingAdminSystem/students?struts=findallxuanke1" target="rightFrame">选课查询</a><i></i></li>
            <li><cite></cite><a href="kechebiao.html" target="rightFrame">课表查询</a><i></i></li>
        </ul>    
        </dd>
  
          <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>网上课堂
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="video.jsp" target="rightFrame">在线直播</a><i></i></li>
            </ul>     
        </dd> 
        <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>论坛
        </div>
        	<ul class="menuson">
        		<li><cite></cite><a href="LeaveMessage.jsp" target="rightFrame">留言板</a><i></i></li>
            </ul>     
        </dd> 
      
   	</c:if>
   	
    <!--*****************************教师进入*****************************-->
   	<c:if test="${type==2}">
   		 <dd>
            <div class="title">
        	<span><img src="images/leftico01.png" /></span>信息查询
        </div>
            <ul class="menuson">
            <li><cite></cite><a href="teachers?struts=dAllTea" target="rightFrame">个人信息</a><i></i></li>
            <li ><cite></cite><a href="right.html" target="rightFrame">教务信息</a><i></i></li>
            <li ><cite></cite><a href="teachers?struts=studentfindAllTea" target="rightFrame">学生信息</a><i></i></li>
            </ul>    
        </dd>
        <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>成绩查询
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="teachers?struts=Allgrade" target="rightFrame">查看所有成绩</a><i></i></li>
            <li><cite></cite><a href="teachers?struts=dangreade" target="rightFrame">查看单科成绩</a><i></i></li>
            </ul>     
        </dd> 
        
        
        <dd><div class="title"><span><img src="images/leftico03.png" /></span>其他操作</div>
        <ul class="menuson">
            <li><cite></cite><a href="kechebiao.html" target="rightFrame">课表查询</a><i></i></li>
            <li><cite></cite><a href="teachers?struts=teacherup" target="rightFrame">教师查询</a><i></i></li>
        </ul> 
        </dd>  
         <dd>
        <div class="title">
        <span><img src="images/leftico02.png" /></span>网上课堂
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="video.jsp" target="rightFrame">在线直播</a><i></i></li>
            <li><cite></cite><a href="uploadVideo.jsp" target="rightFrame">上传视频</a><i></i></li>
            </ul>     
        </dd> 
   	</c:if>
   	
    <!--*****************************管理员进入**************************-->
   
   	<c:if test="${type==3}">
   		<dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>老师信息
    </div>
        <ul class="menuson">
    	<li><cite></cite><a href="teacher?struts=findAllTea" target="rightFrame">显示所有</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">人员列表</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">我的帖子</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">我的好友</a><i></i></li>
        <li><cite></cite><a href="tools.html" target="rightFrame">个人信息</a><i></i></li>
        <li><cite></cite><a href="filelist.html" target="rightFrame">板块信息</a><i></i></li>
       </ul>
    </dd>
    <dd>
    	<div class="title">
   			 <span><img src="images/leftico01.png" /></span>学生信息
    	</div>
    	<ul class="menuson">
    	<li><cite></cite><a href="student?struts=findAllStu" target="rightFrame">显示所有</a><i></i></li>
        <li><cite></cite><a href="imgtable.html" target="rightFrame">人员列表</a><i></i></li>
        <li><cite></cite><a href="imglist.html" target="rightFrame">我的帖子</a><i></i></li>
        <li><cite></cite><a href="imglist1.html" target="rightFrame">我的好友</a><i></i></li>
        <li><cite></cite><a href="tools.html" target="rightFrame">个人信息</a><i></i></li>
        <li><cite></cite><a href="filelist.html" target="rightFrame">板块信息</a><i></i></li>
       </ul>
    </dd>
    <dd>
    	<div class="title">
   			 <span><img src="images/leftico01.png" /></span>权限管理
    	</div>
    	<ul class="menuson">
    		<li><cite></cite><a href="teacher?struts=showRoleAll" target="rightFrame">权限列表</a><i></i></li>
     		<li><cite></cite><a href="teacher?struts=show_role" target="rightFrame">学生管理权限</a><i></i></li>
     		<li><cite></cite><a href="teacher?struts=show_role" target="rightFrame">教师管理权限</a><i></i></li>
    	</ul>
    </dd>
   	</c:if>
    </dl>
</body>
</html>
