<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post">
        <p></p>
        <div class="msg-warn hide" style="margin-top:50px; margin-left:80px;"" ><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p style="text-align:center;"><input type="text" name="userid" value="" placeholder="昵称/邮箱/手机号"></p>
        <p style="text-align:center;"><input type="password" name="userpaw" value="" placeholder="密码"
        style="border: 1px solid #dbdbdb; font-size: 20px; padding-left: 10px;"></p>
        <p style="text-align:center;"><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a></p></form>
</div>
</body>
</html>