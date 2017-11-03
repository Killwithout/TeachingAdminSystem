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
    <li><a href="#">成绩信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="teacher" id="booksFrom" method="post">
    	<input type="hidden" name="struts" value="" id="h"/>
    <table class="tablelist" style="margin-top:20px">
    	<thead>
    		<caption><font style="font-size:24px;text-align:center">所有学生成绩<br/></font></caption>
    		  <div class="tools">
    
    	<ul class="toolbar">
    	<a href="addTeacher.jsp">
        <li class="click">
       
        <span><img src="images/t01.png" />
        </span>添加
        </li></a>
        <a onclick="upd()"><li class="click"><span><img src="images/t02.png" /></span>修改</li></a>
        <a onclick="del()"><li><span><img src="images/t03.png" /></span>删除</li></a>
        </ul>
    </div>
    	<tr>
    			<th>选择</th>
			    <th>学号</th>
			    <th>成绩号</th>
			    <th>分数</th>
			    <th>课程名</th>
			    <th>授课教师</th>
			    <th>操作</th>
		    </tr>
        </thead>
        <c:forEach items="${grade}" var="grade">
		    <tr>
		    	<td><input type="checkbox" name="choose" value="${teacs.t_id}"/></td>
			    <td>${grade.s_id}</td>
			    <td>${grade.ct_id}</td>
			    <td>${grade.g_fenshu}</td>
			    <td>${grade.ct_name}</td>
			    <td>${grade.ct_teacher_name}</td>
			    <td>查看</td>
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