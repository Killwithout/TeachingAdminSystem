<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>网上课堂</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
	  	#cc1{border:1px solid red; 
			 margin:0 auto;
			 width:100%;
			 height:100%;
			}
		video{margin-left:30px;}
		span{border:1px solid red; margin-left:120px; }
    </style>
  </head>
  
  <body>
  	
  	<table>
  	 <!--<c:forEach items="${filename}" var="video"></c:forEach>-->
  		<tr>
  			<td>
	  			<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
	      		</video>
      		</td>
      		<td>
	  			<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
	      		</video>
      		</td>
      		<td>
	  			<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
	      		</video>
      		</td>
      		<td>
	  			<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
	      		</video>
      		</td>
  		</tr>
  		
  		<tr>
  			<td align="center" style="font-weight:800;">JAVA购物车教学视频</td>
  			<td align="center" style="font-weight:800;">JavaScript教学视频</td>
  			<td align="center" style="font-weight:800;">SQLserver教学视频</td>
  			<td align="center" style="font-weight:800;">English教学视频</td>
  		</tr>
  		<tr>
  			<td>
	  			<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
	      		</video>
      		</td>
  			<td>
  				<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
      			</video>
  			</td>
  			<td>
  				<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
     			</video>
  			</td>
  			<td>
  				<video src="up/${video_pic_name}" width="250px" height="150px" autoplay controls>
      			</video>
  			</td>
  		</tr>
  		<tr>
  			<td align="center" style="font-weight:800;">大学语文教学视频</td>
  			<td align="center" style="font-weight:800;">大学数学教学视频</td>
  			<td align="center" style="font-weight:800;">html5教学视频</td>
  			<td align="center" style="font-weight:800;">jsp&jquary教学视频</td>
  		</tr>
  		<tr>
  			<td calspan="4">
  				<br/><br/>
  			</td>
  		</tr>
  		<tr align="center">
  			<td><font style="font-weight:900; color:#0099FF;">一共${maxPage}页/第${curPage}页</font></td>
  			
  			<td>
  			<!-- <c:if test="${curPage>1}"></c:if>
  			sub?ding=${curPage - 1}&struts=findallbook -->
  			<font style="font-weight:900; color:#0099FF;"><a href="#">上一页</a></font>
  			</td>
  			<td>
  				<!--<c:if test="${curPage > 0 && curPage < maxPage}">
  		 sub?ding=${curPage + 1}&struts=findallbook </c:if>-->
  			<font style="font-weight:900; color:#0099FF;"><a href="#">下一页</a></font>
  			
  			</td>
  			<td><font style="font-weight:900; color:#0099FF;"><a href="sub?ding=${maxPage}&struts=findallbook">尾页</a></font></td>
  		</tr>
  	</table>  	 		
  </body>
</html>
