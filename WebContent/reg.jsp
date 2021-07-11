<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
     <script src="js/jquery-1.12.4.min.js"></script>
    <script src="js/function.js"></script>

    
    <style type="text/css">
		.reg p .error{
			color:red;
			display:inline-block;
		}
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="/shop/register" method="post" onsubmit="return checkFrom(this)">
        <p style="text-align: center;font-size:30px;margin-bottom:50px;">用户注册</p>
        <p><input type="text" name="userid" value="" placeholder="请输入用户ID" onfoucs="FoucsItem(this)" onblur="CheckItem(this)"><span></span></p>
        <p><input type="text" name="userpaw" value="" placeholder="请输入密码"
        onfoucs="FoucsItem(this)" onblur="CheckItem(this)"><span></span></p>
        <p><input type="text" name="repaw" value="" placeholder="请确认密码"
        onfoucs="FoucsItem(this)" onblur="CheckItem(this)"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" placeholder="验证码"
        onfoucs="FoucsItem(this)" onblur="CheckItem(this)"><img src="getcode" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt" style="margin-right:500px;">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt" style="margin-right:500px;"><a href="login.jsp"><span></span>已有账号登录</a></p>
        </form>
</div>
</body>
</html>