<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最书</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <link rel="stylesheet" type="text/css" href="css/proList.css"/>
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


<!-------------------------轮播图--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
        	<li>
                <div class="slide"><img src="img/2000-480.jpg" style="height:405px;"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/毕业季.jpeg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/相处之道.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/谢谢.jpg"/></div>
            </li>
        </ul>
    </div>
</div>






<!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix">
    <a href="selectflowerder?fid=34"><img src="img/123.png"/></a>
    <a href="selectflowerder?fid=37"><img src="img/true.jpg"/></a>
    <a href="selectflowerder?fid=40"><img src="img/e.jpeg"/></a>
    </div>
</div>





<!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper"><h2><img src="img/ih1.jpg"/></h2>
    
    <div class="top clearfix" style="margin-left:380px;">
    	<c:forEach var="c3" items="${list4 }">
        <a href="selectproductview?id=${c3.PRODUCT_ID }"><img src="images/product/${c3.PRODUCT_FILENAME }" style="width:120px;height:200px;"/>
            <p></p>
            </a>
         </c:forEach>  
    </div>

            
            
            
 
            
        <h2><img src="img/ih2.jpg"/></h2>
        <div class="bottom" style="margin-left:100px;">
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                <c:forEach var="cl" items="${list1 }">
                <a href="selectproductview?id=${cl.PRODUCT_ID }">
                    <dl>
                        <dt><img src="images/product/${cl.PRODUCT_FILENAME }" style="height:120px;width:80px;"/></dt>
                        <dd>【最书】${cl.PRODUCT_NAME }</dd>
                        <dd>￥${cl.PRODUCT_PRICE }.00</dd>
                    </dl>
                </a>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </div>
</div>


<!------------------------------ad------------------------------>
<a href="selectflowerder?fid=40" class="ad"><img src="img/书里的长城.png" style="height:300px;"/></a>
<!------------------------------people------------------------------>




<div class="people">
    <div class="wrapper"><h2><img src="img/ih3.jpg"/></h2>
        <div class="pList clearfix tran" >
        <c:forEach var="c" items="${list2 }">
        <a href="selectproductview?id=${c.PRODUCT_ID }">
            <dl>
                <dt><span class="abl"></span><img src="images/product/${c.PRODUCT_FILENAME }"style="width:300px;height:300px;"/><span class="abr"></span></dt>
                <dd>【最书--计算机--信息指导】${c.PRODUCT_NAME }</dd>
                <dd><span>￥${c.PRODUCT_PRICE }.00</span></dd>
            </dl>
        </a>
        </c:forEach>
        </div>
        
        
        
        <div class="pList clearfix tran">
        <c:forEach var="c1" items="${list3 }">
        <a href="selectproductview?id=${c1.PRODUCT_ID }">
            <dl>
                <dt><span class="abl"></span><img src="images/product/${c1.PRODUCT_FILENAME }"style="width:300px;height:300px;"/><span class="abr"></span></dt>
                <dd>【最书--计算机--实践】${c1.PRODUCT_NAME }</dd>
                <dd><span>￥${c1.PRODUCT_PRICE }.00</span></dd>
            </dl>
        </a>
        </c:forEach>
        </div>
        
    </div>
</div>



<!--返回顶部-->
<div class="gotop"><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a></div>
    <!-------------------login--------------------------><!--footer-->
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
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">
$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});
</script>
</body>
</html>