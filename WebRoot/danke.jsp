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
  
    <form action="book" id="from_books" method="post">
    <input type="hidden" id="h" name="struts" value="">
    <center><font style="font-size:28px">单科成绩</font></center>
    <table class="imgtable">
	    <thead>
		    <tr>
		    	
			    <th>姓名</th>
			    <th>课程</th>
			    <th>分数</th>
		   </tr>
	    </thead>
	    <c:forEach items="${danke_geade}" var="danke_geade">
		    <tr>
		    	<%-- <td><input type="checkbox" name="choose" value="${student.s_id}"/></td>
			    <td class="imgtd"><img width="50" height="50" src="up/${student.s_img"/></td> --%>
			    <td>${danke_geade.s_name}</td>
			    <td>${danke_geade.ct_id}</td>
			    <td>${danke_geade.g_fenshu}</td>
		    </tr>
	    </c:forEach>
    </table>
    </form>
</body>
</html>
