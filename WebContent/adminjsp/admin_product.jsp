<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="/shop/adminjsp/admin_doproductdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_toproductadd"><i class="icon-font"></i>新增图书</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="1000px">
                        <tr>
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="p" items="${plist }">
	                        <tr>
	                        	<td style="width:20px;">
	                        		${p.PRODUCT_ID }
	                        	</td>
	                        	<td style="width:700px;">
	                        		<img src="../images/product/${p.PRODUCT_FILENAME }" style="width: 80px;height:100px;"/>
	                        		${p.PRODUCT_NAME }
	                        	</td>
	                        	<td style="width:80px;">
	                        		${p.PRODUCT_PRICE }
	                        	</td>
	                        	<td style="width:80px;">
	                        		${p.PRODUCT_STOCK }
	                        	</td>
	                        	<td style="width:120px;">
	                        		<a href="admin_toproductupdate?id=${p.PRODUCT_ID }">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:catedel(${p.PRODUCT_ID })">删除</a>
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