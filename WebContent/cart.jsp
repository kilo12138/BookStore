<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body><!--------------------------------------cart--------------------->
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





<div class="cart mt" style="margin-top:30px;"><!-----------------logo------------------->
    <!--<div class="logo">
    <h1 class="wrapper clearfix"><a href="index.html">
    <img class="fl" src="img/temp/logo.png">
    </a><img class="top" src="img/temp/cartTop01.png">
    </h1></div>-->
    <!-----------------site------------------->
    
    <div class="site">
    <p class=" wrapper clearfix"><span class="fl">购物车</span>
    <img class="top" src="img/temp/cartTop01.png">
    <a href="indexservlet" class="fr">继续购物&gt;</a>
    </p>
    </div>
    
    
    
    <!-----------------table------------------->
    <div class="table wrapper">
        <div class="tr">
            <div>商品</div>
            <div>单价</div>
            <div>数量</div>
            <div>小计</div>
            <div>操作</div>
        </div>
        
        <c:forEach var="rs" items="${shoplist }">
        <c:if test="${rs.CART_VALID ==1 }">
        <div class="th">
            <div class="pro clearfix"><label class="fl">
            <input name="ck" type="checkbox" value="${rs.CART_P_ID }"/><span></span></label>
            <a class="fl" href="selectproductview?id=${rs.CART_P_ID }">
                <dl class="clearfix">
                    <dt class="fl"><img src="images/product/${rs.CART_P_FILENAME }" style="width:80px;height:120px;"></dt>
                    <dd class="fl"> <p>${rs.CART_P_NAME }</p>
                     </dd>
                </dl>
            </a>
            </div>
            <div class="price">￥${rs.CART_P_PRICE }.00</div>
            <div class="number">
            <p class="num clearfix">
            
            <img class="fl sub" src="img/temp/sub.jpg">
            <span datesrc="${rs.CART_ID }" class="fl">${rs.CART_QUANTITY }</span>
            <img class="fl add" src="img/temp/add.jpg">
            
            </p>
            </div>
            <div class="price sAll">￥${rs.CART_P_PRICE*rs.CART_QUANTITY }.00</div>
            <div class="price"><a class="del" datasrc="${rs.CART_ID }" href="#2">删除</a></div>
        </div>
        </c:if>
        </c:forEach>
        
        

        <div class="goOn">空空如也~<a href="indexservlet">去逛逛</a></div>
        
        
        <div class="tr clearfix">
        <label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>
            <p class="fl"><a href="#">全选</a><a href="#" class="del">删除</a></p>
            
            <p class="fr"><span>共<small id="sl">0</small>件商品</span><span>合计:&nbsp;<small id="all">￥0.00</small></span>
            <a href="javascript:toorder()" class="count">结算</a></p></div>
    </div>
</div>

<script>
	function toorder(){
		var str="";
		$("input[name='ck']:checked").each(function(index,item){
			if($("input[name='ck']:checked").length-1 == index){
				str+=$(this).val();
			}else{
				str+=$(this).val()+",";
			}
		});
		
		location.href="orderselect?eids="+str;
	}


</script>




<div class="mask"></div>
<div class="tipDel"><p>确定要删除该商品吗？</p>
    <p class="clearfix"><a class="fl cer" href="#">确定</a><a class="fr cancel" href="#">取消</a></p></div><!--返回顶部-->
<div class="gotop">
<a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
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
        
        <!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="img/temp/off.jpg"/>
    <div class="proCon clearfix">
        <div class="proImg fr"><img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img
                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"
                                                                                          data-src="img/temp/proDet03_big.jpg"><img
                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fl">
            <div class="proIntro change"><p>颜色分类</p>
                <div class="smallImg clearfix"><p class="fl on"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                     data-src="img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>
                </div>
            </div>
            <div class="changeBtn clearfix">
            <a href="#2" class="fl"><p class="buy">确认</p></a>
            <a href="#2" class="fr"><p class="cart">取消</p></a>
            </div>
        </div>
    </div>
</div>
<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>