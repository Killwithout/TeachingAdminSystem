<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录教务管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="js/clock.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  

		/*登录账号验证*/
function check_ln(){
	var login_name = document.getElementById("login_name").value;
	if(login_name.length==0){
			document.getElementById("login_name").focus();
			document.getElementById("login_error1").innerHTML="账号不能为空！";
			document.getElementById("login_error1").style.color="red";
			document.getElementById("login_name").value="";
	}
	else{
		document.getElementById("login_pass").focus();
	}	
}



		/*登录密码验证*/
function check_lp(){
	var login_pass = document.getElementById("login_pass").value;
	if(login_pass.length==0 || login_pass==""){
		document.getElementById("login_pass").focus();
		document.getElementById("login_error2").innerHTML="密码不能为空！";
		document.getElementById("login_error2").style.color="red";
	}else{
		document.getElementById("login_lznum").focus();
	}
}

	 /**验证吗验证**/
function login_lz(){
	var login_lzinput=document.getElementById("login_lznum").value;
	var login_lzout=document.getElementById("span1").innerHTML.valueOf();
	
	if(login_lzinput!=login_lzout){
		yanzhengma();
		document.getElementById("login_error3").innerHTML="验证码错误";
		document.getElementById("login_error3").style.color="red";
		document.getElementById("login_lznum").value="";
		document.getElementById("login_lznum").focus();	
	}else{
		document.getElementById("login_error3").innerHTML="";	
		document.getElementById("buttons").focus();	
		document.getElementById("login_error3").innerHTML="";
	}
}	 


		/*登录验证码*/
 function yanzhengma(){
	var arr= [0,1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']; 
	var color = ['red','green','yellow','blue','#0FF','#b9d187','#F6F'];
	     str = "";
		for(var i = 0;i<arr.length;i++){
		    ran = parseInt(Math.random()*arr.length);
		    color1 = parseInt(Math.random()*color.length);
			str = str +arr[ran];
			if(i==3){
				break;
				}
			}	
			document.getElementById("span1").style.backgroundColor = color[color1];  
			document.getElementById("span1").innerHTML = str;  	
	 }
</script> 
<style type="text/css">
.quanxian{ margin-left:60px;
			font-size:16px;
			color:#ccc;
			vertical-align:middle;
			position:relative;
			top:-15px;
		}
        	#canvas{ position:absolute; top:80px;left:45px;
	           }
			#clock{ border:0px solid #ccc;}
			#time{ padding-bottom:20px;}

</style>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登教务管理界面平台</span>    
    <ul>
    <li><a href="#">联系我们</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
     <div id="canvas">
        	<H3 id="time" align="center">
            
            </H3>
        	<canvas id="clock" height="150px" width="150px"></canvas>
	</div>
    <form action="login_user" method="post">
    <ul>
    <li>
    	<b id="zhanghao">账号:&nbsp;</b><input name="login_name" type="text" class="loginuser" id="login_name" onBlur="check_ln()"/>
        <i id="login_error1"></i>
    </li>
    <li>
    	<b id="zhanghao">密码:&nbsp;</b><input name="login_pass" type="text" class="loginpwd" id="login_pass" onBlur="check_lp()"/>
    	<i id="login_error2"></i>
    <li>
    	<b id="yanzhengnum">验证码:&nbsp;&nbsp;</b><input name="login_yznum" type="text" class="yanZhenNum" id="login_lznum" onBlur="login_lz()"/>
    <b id="span1" style="background-color:#FFF;font-size:16px; padding:5px 10px 5px 10px;">&nbsp;</b>
    <a href="javascript:yanzhengma()">看不清，换一张</a>
    <i id="login_error3"></i>
    </li>
      <label class="quanxian">
		    	<input type="radio" name="QuanXian" value="teacher"/>&nbsp;教师&nbsp;
		    	<input type="radio" name="QuanXian" value="student" checked="checked"/>&nbsp;学生&nbsp;
		    	<input type="radio" name="QuanXian"value="admin"/>&nbsp;管理员
		    	<input type="hidden" name="login_submit" value="struts"/>
	  </label>
    <li><input type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'" id="buttons"/>				<label>
    <input name="" type="checkbox" value=" " checked="checked" />记住密码</label><label><a href="#">忘记密码？</a>
</label>
</li>
    </ul>
    </form>
    </div>
    
    </div>
    <div class="loginbm">版权所有  cjk  2017  email:1741423063@qq.com</div>
</body>
</html>
