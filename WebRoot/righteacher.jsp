<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function del(){
		document.getElementById("h").value="delTeacher";
		document.getElementById("booksFrom").submit();
	}
	function upd(){
		document.getElementById("h").value="updTeacher";
		document.getElementById("booksFrom").submit();
	}
	

</script>
<title>Insert title here</title>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">教师</a></li>
    <li><a href="#">个人信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="teacher" id="booksFrom" method="post">
    	<input type="hidden" name="struts" value="" id="h"/>
    <table class="tablelist" style="margin-top:50px">
    	<thead>
    		<caption><font style="font-size:24px;text-align:center">个人信息<br/></font></caption>
    	<tr>
    			<th>选择</th>
    			<th>头像</th>
			    <th>工号</th>
			    <th>姓名</th>
			    <th>性别</th>
			    <th>年龄</th>
			    <th>入职时间</th>
			    <th>地址</th>
			    <th>电话</th>
			    <th>出生日期</th>
			    <th>简介</th>
			    <th>操作</th>
		    </tr>
        </thead>
        <c:forEach items="${teacs}" var="teacs">
		    <tr>
		    	<td><input type="checkbox" name="choose" value="${teacs.t_id}"/></td>
			    <td class="imgtd"><img width="50" height="50" src="up/${teacs.t_img}"/></td>
			    <td>${teacs.t_id}</td>
			    <td>${teacs.t_name}</td>
			    <td>${teacs.t_sex}</td>
			    <td>${teacs.t_age}</td>
			    <td>${teacs.t_time}</td>
			    <td>${teacs.t_address}</td>
			    <td>${teacs.t_phoneNum}</td>
			    <td>${teacs.t_birthday}</td>
			    <td><a href="#">详情</a></td>
			    <td>
			    <a onclick="upd()" href="teachers?struts=updTeacher">完善个人信息</a>&nbsp;&nbsp;
			    <a onclick="del()" href="teachers?struts=delTeacher">删除</a>
			    </td>
		    </tr>
	    </c:forEach>
      </table>
    </form>
  </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>