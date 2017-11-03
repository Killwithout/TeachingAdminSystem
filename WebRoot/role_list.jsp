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
		/* 删除 */
		function d(){
			
			document.getElementById("h").value="delRole";
			document.getElementById("from_books").action="teacher";
			document.getElementById("from_books").submit();
			
		}
		
		/* 更改 */
		function u(){
			alert("dsfds");
			document.getElementById("h").value="forUpdate";
			document.getElementById("from_books").action="book";
			document.getElementById("from_books").submit();
			//var size=document.getElementsByName("choose").isSelect();
			//alert(size.length);
		}
</script>
</head>


<body>

	<div class="place">
	    <span>ch位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">权限列表</a></li>
	    </ul>
    </div>
   
    
	    <div class="rightinfo">
		    <div class="tools">
		    	<ul class="toolbar">
			        <a href="addRole.jsp"><li class="add"><span><img src="images/t01.png" /></span>添加</li></a>
			   	</ul>
		    </div>
		</div>
    
    <table class="imgtable">
	    <thead>
		    <tr>
		    	<th width="100px;">选择</th>
			   
			    <th>角色id</th>
			    <th>角色名</th>
			    <th>角色权限</th>
			   	<th>保存权限设置</th>
		    </tr>
	    </thead>
    
	   	<c:forEach items="${roles}" var="role">
	   		<form action="teacher" id="from_books" method="get">
   				 <input type="hidden" id="h" name="struts" value="saveRoleOption">
   				 <input type="hidden" id="h" name="role_id" value="${role.role_idString}">
		    <tr>
		    	<td><input type="checkbox" name="choo" value="${role.role_idString}"/></td>
			   	<td>${role.role_idString}</td>
			    <td>${role.role_nameString}</td>
			    <input type="hidden" id="h" name="role_iid" value="${role.role_idString}">
			     <td>
			  
			   	 <input type="checkbox" name="op"   ${role.a} value="checked=a">增
			   
			  
			    <input type="checkbox" name="op"    ${role.d} value="checked=d">删
			   
			   
			    <input type="checkbox" name="op"     ${role.u} value="checked=u">改
			   
			   
			    <input type="checkbox" name="op"     ${role.s} value="checked=s">查
			    
			    </td>
			  
			   	<td>
			   		<input type="submit" value="保存"><a href="teacher?role_iid=${role.role_idString}&struts=delRole">删除</a>
			   	</td>
			   
		    </tr>
		    </form>
	   	</c:forEach>
    	
    </table>
    
    
</body>
</html>
