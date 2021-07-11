<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>简单通用文章系统后台管理模板</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">首页</a></li>
                <li><a href="../indexservlet" target="_blank">网站首页</a></li>
                <li><a href="/shop/adminjsp/adminloginout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/shop/adminjsp/admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="/shop/adminjsp/admin_cateseclect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="/shop/adminjsp/admin_productselect"><i class="icon-font">&#xe006;</i>图书管理</a></li>
                        <li><a href="/shop/adminjsp/admin_showorder"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>