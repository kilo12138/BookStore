<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl" style="boder:1px solid red;height:79px; line-height:79px; font-size:20px;"><a href="indexservlet">最书</a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            
            <c:if test="${isLogin !=1}">
            <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            </c:if>
            <c:if test="${isLogin ==1 }">
            	你好：${name.USER_NAME }
            </c:if>
            
            </p>
                <form action="doselectproduct" method="get" class="fl">
                <input type="text" name="keywords" value="${param.keywords}" placeholder="热门搜索：干花花瓶"/>
                <input type="submit" value=""/>
                </form>
                        
                        
                        
                <div class="btn fl clearfix">
                <a href="showmy"><img src="img/grzx.png"/></a>
                <a href="showcart"><img src="img/gwc.png"/></a>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexservlet">首页</a></li>
            
            
            <c:forEach var="f" items="${flist }">
            <li><a href="selectflowerder?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
                <div class="sList2">
                    <div class="clearfix">
                    <c:forEach var="c" items="${clist }">
                   		<c:if test="${f.CATE_ID == c.CATE_PARENT_ID }">
                    		<a href="selectprolist?cid=${c.CATE_ID }">${c.CATE_NAME }</a>
                    	</c:if>
                    </c:forEach>
                   </div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>



<!------------------------------idea------------------------------>
<div class="address mt" style="margin-top:30px;">
    <div class="wrapper clearfix"><a href="indexservlet" class="fl">首页</a><span>/</span><a href="showmy" class="on">个人信息</a>
    </div>
</div>






<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#">
            <img src="img/tx.png"/></a>
                <p class="clearfix">
                <span class="fl">${name.USER_NAME } </span>
                <span class="fr"><a href="loginout">[退出登录]</a></span>
                </p>
            </h3>
            <div>
            <h4>我的交易</h4>
                <ul>
                    <li><a href="showcart">我的购物车</a></li>
                    <li><a href="showmycart">我的订单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="showaddress">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li class="on"><a href="showmy">个人信息</a></li>
                    <li><a href="showremima">修改密码</a></li>
                </ul>
            </div>
        </div>
        
        
        
        <div class="you fl">
        <h2>个人信息</h2>
            <div class="gxin">
            
                <div class="tx">
                <a href="#"><img src="img/tx.png"/><p id="avatar"></p></a>
                </div>
                
                
                <div class="xx">
                <h3 class="clearfix">
                <strong class="fl">基础资料</strong>
                <a href="#" class="fr" id="edit1">编辑</a>
                </h3>
                	<div>编号：${name.USER_ID }</div>
                    <div>姓名：${name.USER_NAME }</div>
                    <div>生日：${name.USER_BIRTHDAY }</div>
                    <div>性别：${name.USER_SEX }</div>
                    <div>邮箱：${name.USER_EMAIL }</div>
                    <div>电话：${name.USER_MOBILE }</div>
                </div>
            </div>
        </div>
    </div>
</div>








<!--遮罩-->
<div class="mask"></div><!--编辑弹框-->
<div class="bj">
    <div class="clearfix">
    <a href="#" class="fr gb">
    <img src="img/icon4.png"/>
    </a>
    </div>
    <h3>编辑基础资料</h3>
    <form action="douserupdate" method="post">
    <input type="hidden" name="password" value="${name.USER_PASSWORD }"/>
    <input type="hidden" name="address" value="${name.USER_ADDRESS }"/>
    <input type="hidden" name="userStatus" value="${name.USER_STATUS }"/>
    	<p><label>编号：</label><input type="text" value="${name.USER_ID }" name="username"/></p>
    	<p><label>姓名：</label><input type="text" value="${name.USER_NAME }" name="name" /></p>
        <p><label>生日：</label><input type="text" value="${name.USER_BIRTHDAY }" name="birthday"/></p>
        <p><label>性别：</label><span><input type="radio" name="sex" value="T" ${name.USER_SEX=='T'?"checked":"" } style="width:25px;heighe:25px;"/>男</span><span>
        <input type="radio" name="sex" value="F" ${name.USER_SEX=='F'?"checked":"" } style="width:25px;heighe:25px;"/>女</span></p>
        <p><label>邮箱：</label><input type="text" value="${name.USER_EMAIL }" name="email"/></p>
        <p><label>电话：</label><input type="text" value="${name.USER_MOBILE }" name="mobile"/></p>
        
        
        
        <div class="bc">
        <input type="submit" value="提交"/>
        <input type="button" value="取消"/>
        </div>
    </form>
</div>
<!--修改头像-->









<!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">&copy;公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：123-456-7890，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>