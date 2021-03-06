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
  
	    <div class="rightinfo">
		    <div class="tools">
		    	<ul class="toolbar">
			       	<a href="/TeachingAdminSystem/user?struts=findallgrade"><li class="add"><span><img src="images/t02.png" /></span>成绩查询</li></a>
			        <a href="XK_student.jsp"><li class="update"><span><img src="images/t02.png" /></span>选课查询</li></a>
			        <a href="KB_student.jsp"><li class="del"><span><img src="images/t02.png" /></span>课表查询</li></a>
			        <a href="JS_student.jsp"><li><span><img src="images/t02.png" /></span>教室查询</li></a>
		    	</ul>
		        <ul class="toolbar1">
		       		<li><span><img src="images/t05.png" /></span>设置</li>
		        </ul>
		    </div>
		</div>
 <form action="book" id="from_books" method="post">
    <input type="hidden" id="h" name="struts" value="">
    <table class="imgtable">
	    <thead>
		    <tr>
			    <th>学号</th>
			    <th>姓名</th>
			    <th>美术</th>
			    <th>体育</th>
			    <th>音乐</th>
			    <th>诗歌鉴赏</th>
		    </tr>
	    </thead>
	    <c:forEach items="${books}" var="book">
		    <tr>
		    	<td><input type="checkbox" name="choose" value="${book.book_id}"/></td>
			    <td class="imgtd"><img width="50" height="50" src="up/${book.book_image_path}"/></td>
			    <td>${book.book_id}</td>
			    <td>${book.book_name}</td>
			    <td>${book.book_class}</td>
			    <td>${book.book_publish}</td>
			    <td>${book.book_author}</td>
			    <td>${book.book_price}</td>
			    <td>${book.book_click}</td>
			    <td>${book.book_allmessage}</td>
		    </tr>
	    </c:forEach>
    </table>
    </form>
     <div class="pagin">
    	<div class="message">
    		共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
    	</div>
        <ul class="paginList">
	        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
	        <li class="paginItem"><a href="javascript:;">1</a></li>
	        <li class="paginItem current"><a href="javascript:;">2</a></li>
	        <li class="paginItem"><a href="javascript:;">3</a></li>
	        <li class="paginItem"><a href="javascript:;">4</a></li>
	        <li class="paginItem"><a href="javascript:;">5</a></li>
	        <li class="paginItem more"><a href="javascript:;">...</a></li>
	        <li class="paginItem"><a href="javascript:;">10</a></li>
	        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
</body>
</html>
