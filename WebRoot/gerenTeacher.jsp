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
		document.getElementById("h").value="Update_grade";
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
    <li><a href="#">教师信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <form action="teacher" id="booksFrom" method="post">
    	<input type="hidden" name="struts" value="" id="h"/>
    <table class="tablelist" style="margin-top:20px">
    	<thead>
    		<caption><font style="font-size:24px;text-align:center">所有教师信息<br/></font></caption>
    		  <div class="tools">
    
    	
    </div>
    	<tr>
			    <th>工号</th>
			    <th>姓名</th>
			    <th>性别</th>
			    <th>年龄</th>
			    <th>入职时间</th>
			    <th>家庭地址</th>
			    <th>联系电话</th>
			    <th>出生日期</th>
			    <th>学院意见</th>
			    <th>其他</th>
			    
			    
		    </tr>
        </thead>
        <c:forEach items="${teac}" var="teac">
		    <tr>
			    <td>${teac.t_id}</td>
			    <td>${teac.t_name}</td>
			    <td>${teac.t_sex}</td>
			    <td>${teac.t_age}</td>
			    <td>${teac.t_time}</td>
			    <td>${teac.t_address}</td>
			    <td>${teac.t_phoneNum}</td>
			    <td>${teac.t_birthday}</td>
			    <td>${teac.t_about}</td>
			    <td><a href="#">详情</a>
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