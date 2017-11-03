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
    <center><font style="font-size:28px">个人信息</font></center>
    <table class="imgtable">
	    <thead>
		    <tr>
		    	
			    <th>学号</th>
			    <th>姓名</th>
			    <th>性别</th>
			    <th>年龄</th>
			    <th>入学时间</th>
			    <th>电话</th>
			    <th>家庭地址</th>
			    <th>出生年月</th>
			    <th>简介</th>
		   </tr>
	    </thead>
	    
	    <c:forEach items="${student}" var="student">
		    <tr>
			    <td>${student.s_id}</td>
			    <td>${student.s_name}</td>
			    <td>${student.s_sex}</td>
			    <td>${student.s_age}</td>
			    <td>${student.s_time}</td>
			    <td>${student.s_address}</td>
			    <td>${student.s_phoneNum}</td>
			    <td>${student.s_birthday}</td>
			    <td>${student.s_banji}</td>
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
