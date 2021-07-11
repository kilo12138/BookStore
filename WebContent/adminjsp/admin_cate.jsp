<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        <div class="result-wrap">
            <form action="/shop/adminjsp/admin_docatedel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr> 
                            <th>ID</th>
                            <th>姓名</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="cate" items="${catelist }">
	                        <c:if test="${cate.CATE_PARENT_ID == 0 }"><!--根分类-->
	                        <tr>
	                        	
	                        	<td style="width:50px;">${cate.CATE_ID }</td>
	                        	<td>|--${cate.CATE_NAME }</td>
	                        	<td>
	                        		<a href="admin_tocateupdate?id=${cate.CATE_ID }">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:catedel(${cate.CATE_ID })">删除</a>
	                        	</td>
	                        
	                        </tr>
	                        <c:forEach var="zcate" items="${catelist }">
	                        	<c:if test="${zcate.CATE_PARENT_ID == cate.CATE_ID }">
	                        		<tr>
			                        	<td style="width:50px;">${zcate.CATE_ID }</td>
			                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--${zcate.CATE_NAME }</td>
			                        	<td>
			                        		<a href="admin_tocateupdate?id=${zcate.CATE_ID }">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:catedel(${zcate.CATE_ID })">删除</a>
			                        	</td>
	                        		
	                        		</tr>
	                        	
	                        	</c:if>
	                        </c:forEach>
	                        
	                        </c:if>
                        
                        </c:forEach>
                        
                    </table>
                    
                    <script>
                    	function catedel(id){
                    		
                    		if(confirm("你确定删除")){
                    			location.href="admin_docatedel?id="+id;
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