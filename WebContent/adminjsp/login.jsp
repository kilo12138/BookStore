<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『学习猿地』后台管理</title>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="/shop/adminjsp/adminlogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="userid" value="" id="user" size="40" class="admin_input_style"  style="width:250px;"/>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="userpaw" value="" id="pwd" size="40" class="admin_input_style"  style="width:250px;"/>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="../indexservlet" target="_blank">返回首页</a> </p>
</div>
</body>
</html>