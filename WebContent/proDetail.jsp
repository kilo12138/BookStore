<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${p.PRODUCT_NAME }</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
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





<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    <a href="indexservlet">首页</a><span>/</span>
    <a href="selectflowerder?fid=${p.PRODUCT_FID }">${date.CATE_NAME }</a><span>/</span>
    <a href="selectprolist?cid=${p.PRODUCT_CID }">${cate.CATE_NAME }</a><span>/</span>
    <a href="#" class="on">【最书】${p.PRODUCT_NAME }</a>
    </div>

<!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
            <img class="det" src="images/product/${p.PRODUCT_FILENAME }"/>
                <div class="smallImg clearfix">
                <img src="images/product/${p.PRODUCT_FILENAME }" data-src="images/product/${p.PRODUCT_FILENAME }"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>【最书】${p.PRODUCT_NAME }</h4>
                    <p>【破损补寄】【${p.PRODUCT_DESCRIPTION }】【无理由退换货】【包邮】【${p.PRODUCT_NAME }】</p><span>￥${p.PRODUCT_PRICE }.00</span></div>
                    <br/>
                <div class="proIntro"><p>选择商品</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img src="images/product/${p.PRODUCT_FILENAME }" alt="${p.PRODUCT_NAME }" data-src="images/product/${p.PRODUCT_FILENAME }"></p></div>
                    <p>&nbsp;&nbsp;库存<span>${p.PRODUCT_STOCK }</span>件</p>
                    
                    
                    
                    <div class="num clearfix">
                    <img class="fl sub" src="img/temp/sub.jpg">
                    <span id="count" class="fl" contentEditable="true">1</span>
                    <img class="fl add" src="img/temp/add.jpg">
                    
                    
                        <p class="please fl">请选择商品!</p>
                    </div>
                </div>
                
                
                <div class="btns clearfix">
                <a href="javascript:shopAdd(${p.PRODUCT_ID },'z')"><p class=" fl" style="background: #C10000;color: #fff;border: 1px solid #000;">立即购买</p></a>
                <a href="javascript:shopAdd(${p.PRODUCT_ID },'s')" style="margin-left:100px;"><p class="cart fr">加入购物车</p></a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
	function shopAdd(id,url){
		var count = document.getElementById("count").innerHTML;
		location.href='cartadd?id='+id+'&count='+count+'&url='+url;
	}
</script>


<div class="like"><h4>为你推荐</h4>
    <div class="bottom" style="margin-left:100px;">
        <div class="hd"><span class="prev">
        <img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                <c:forEach var="cl" items="${classlist }">
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



<!--返回顶部-->
<div class="gotop">
<a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
</div>
<div class="msk"></div>




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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>