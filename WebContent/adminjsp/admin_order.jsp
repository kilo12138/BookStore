<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">订单管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="/shop/adminjsp/admin_doproductdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品数量</th>
                            <th>购买用户ID</th>
                            <th>价格</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="rs" items="${shoplist }">
	                        <tr>
	                        	<td style="width:20px;">
	                        		${rs.CART_ID }
	                        	</td>
	                        	<td style="width:700px;">
	                        		<img src="../images/product/${rs.CART_P_FILENAME }" style="width: 80px;height:100px;"/>
	                        		${rs.CART_P_NAME }
	                        	</td>
	                        	<td style="width:80px;">
	                        		${rs.CART_P_PRICE }
	                        	</td>
	                        	<td style="width:80px;">
	                        		${rs.CART_QUANTITY}
	                        	</td>
	                        	<td style="width:80px;">
	                        		${rs.CART_U_ID}
	                        	</td>
	                        	<td style="width:80px;">
	                        		${rs.CART_P_PRICE * rs.CART_QUANTITY}
	                        	</td>
	                        	
	                        	
	                        	<td style="width:120px;">
	                        		<a href="admin_docartye?uid=${rs.CART_U_ID }&pid=${rs.CART_P_ID }&stock=${rs.CART_P_STOCK }&num=${rs.CART_QUANTITY }">点击发货</a>
	                        	</td>
	                        </tr>
	                        
                        
                        </c:forEach>
                        
                    </table>
                    
                    <script>
                    	function catedel(id){
                    		
                    		if(confirm("你确定删除")){
                    			location.href="admin_doproductdel?id="+id;
                    		}
                    	
                    	}
                    </script>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</body>
</html>