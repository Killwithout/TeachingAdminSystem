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
	function she(){
		document.getElementById("h").value="sheTeacher";
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
    <li><a href="#">数据表</a></li>
    <li><a href="#">图书信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
    	<a href="addTeacher.jsp">
        <li class="click">
       
        <span><img src="images/t01.png" />
        </span>添加
        </li></a>
        <a onclick="upd()"><li class="click"><span><img src="images/t02.png" /></span>修改</li></a>
        <a onclick="del()"><li><span><img src="images/t03.png" /></span>删除</li></a>
        <a onclick="she()"><li><span><img src="images/t04.png" /></span>设置权限</li></a>
        </ul>
      
      
      
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    <form action="teacher" id="booksFrom" method="post">
    	<input type="hidden" name="struts" value="" id="h"/>
    <table class="tablelist">
    	<thead>
    	<tr>
		    	<th width="100px;">选择</th>
			    <th width="100px;">头像</th>
			    <th>工号</th>
			    <th>姓名</th>
			    <th>性别</th>
			    <th>年龄</th>
			    
			    <th>职务</th>
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
			    
			    <td>${teacs.t_Manger}</td>
			    <td></td>
		    </tr>
	    </c:forEach>
    </table>
    </form>
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        
        </ul>
    </div>

    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>