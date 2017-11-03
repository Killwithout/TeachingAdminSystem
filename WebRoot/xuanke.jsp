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
    
    <title>My JSP 'book_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript">
		function d(){
			document.getElementById("h").value="delbook";
			document.getElementById("from_books").action="book";
			document.getElementById("from_books").submit();
		}
</script>
</head>


<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">图片列表</a></li>
	    </ul>
    </div>

    
   
      <center><font style="font-size:28px">选课</font></center>
    <table class="imgtable">
	    <thead>
		    <tr>
		    	<th width="100px;">选择</th>
		    	<th>课程号</th>
			    <th>课程</th>
			    <th>教师</th>
			    <th>简介</th>
			    <th>选择课程</th>
		    </tr>
	    </thead>
	   
	    <c:forEach items="${xuanke}" var="xuanke">
	    <form action="selectClass" method="post">
		    <tr>
		    	<td><input type="checkbox" name="choose" value="${xuanke.ct_id}"/></td>
			    <%--<td class="imgtd"><img width="50" height="50" src="up/${book.book_image_path}"/></td>--%>
			    
			   <td> <input type="text" value="${xuanke.ct_id}" name="id"/></td>
			   <td> <input type="text" value="${xuanke.ct_name}" name="name"/></td>
			   <td> <input type="text" value="${xuanke.ct_teacher_name}" name="t_name"/></td>
			   <td> <input type="text" value="${xuanke.ct_jieshao}" name="jieshao"/>
			   		<input type="hidden" value="add" name="struts"/></td>
			    <td> <input type="submit" value="添加"/></td>
			    <!-- <td>${xuanke.ct_id}</td>
				    <td>${xuanke.ct_name}</td>
				    <td>${xuanke.ct_teacher_name}</td>
				    <td>${xuanke.ct_jieshao}</td> 
				    <td><a href="user?struts=add&id=${xuanke.ct_id}">添加</a></td>
			    -->
		    </tr>
		</form>
	    </c:forEach>
    </table>   
</body>
</html>
