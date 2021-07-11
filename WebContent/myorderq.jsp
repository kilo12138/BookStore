<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
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
    <div class="wrapper clearfix"><a href="indexservlet" class="fl">首页</a>
    <span>/</span><a href="showmy">个人中心</a>
    <span>/</span><a href="showmycart" class="on">我的订单</a></div>
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
            <div class="my clearfix">
            <h2 class="fl">我的订单</h2>
            <a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a>
            </div>
            <div class="dlist clearfix">  
            </div>
            
            
            
            
            
            <c:forEach var="rs" items="${shoplist }">
            	<c:if test="${rs.CART_VALID == 2 }">
            		<div class="dkuang clearfix deng">
            <p class="one fl">未发货</p>
                <div class="clearfix">
                    <div class="fl vewwl">
                    
                       
                    </div>
                </div>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>${name.USER_NAME }</li>
                        <li>订单号:${rs.CART_ID }</li>
                        <li>在线支付</li>
                    </ul>
                    <p class="fr">订单金额：<span>￥${rs.CART_P_PRICE*rs.CART_QUANTITY }.00</span>元</p></div>
                <div class="shohou clearfix">
                <a href="selectproductview?id=${rs.CART_P_ID }" class="fl">
                <img src="images/product/${rs.CART_P_FILENAME }" style="width:80px;height:120px;"/></a>
                    <p class="fl">
                    <a href="selectproductview?id=${rs.CART_P_ID }">${rs.CART_P_NAME }</a> 
                    ¥${rs.CART_P_PRICE }.00×${rs.CART_QUANTITY }</p>
                    <p class="fr">
		                    <a href="indexservlet">继续购物</a>
	                 </p>
                    </div>
            	</div>
            	</c:if>
            	
            	<c:if test="${rs.CART_VALID == 3 }">
	            <div class="dkuang">
	            <p class="one">已发货</p>
	                <div class="word clearfix">
	                    <ul class="fl clearfix">
	                        <li>${name.USER_NAME }</li>
	                        <li>订单号:${rs.CART_ID }</li>
	                        <li>在线支付</li>
	                    </ul>
	                    <p class="fr">订单金额：<span>￥${rs.CART_P_PRICE*rs.CART_QUANTITY }.00</span>元</p></div>
	                <div class="shohou clearfix">
	                	<a href="selectproductview?id=${rs.CART_P_ID }" class="fl">
	                	<img src="images/product/${rs.CART_P_FILENAME }" style="width:80px;height:120px;"/></a>
	                    <p class="fl">
		                    <a href="selectproductview?id=${rs.CART_P_ID }">${rs.CART_P_NAME }</a>
		                    ¥${rs.CART_P_PRICE }.00×${rs.CART_QUANTITY }
	                    </p>
	                    <p class="fr">
                    	<a href="#">确认收货</a>
                    	</p>
	                    </div>
	            </div>
            	</c:if>
            	
            </c:forEach>
                        

        </div>
    </div>
</div>







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
        违法和不良信息举报电话：123-456-7890，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
     </div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>