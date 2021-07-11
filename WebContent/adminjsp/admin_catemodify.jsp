<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/shop/adminjsp/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span><a class="crumb-name" href="/shop/adminjsp/admin_cateseclect">分类管理</a>
            <span class="crumb-step">&gt;</span><span>修改分类</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/shop/adminjsp/admin_docateupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="cateid" value="${cate1.CATE_ID }"/>
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>上级分类：</th>
                                <td>
                                    <select class="common-text required" name="parentid">
                                    	<option value="0">一级分类</option>
	                                    	<c:forEach var="cate" items="${catelist }">
	                                    		<c:if test="${cate.CATE_PARENT_ID == 0 }">
	                                    			<c:if test="${cate1.CATE_PARENT_ID == cate.CATE_ID }">
	                                    				<option value="${cate.CATE_ID }" selected="selected">${cate.CATE_NAME }</option>
	                                    			</c:if>
	                                    			<c:if test="${cate1.CATE_PARENT_ID != cate.CATE_ID }">
	                                    				<option value="${cate.CATE_ID }">${cate.CATE_NAME }</option>
	                                    			</c:if>
	                                    		</c:if>
	                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>分类名称：</th>
                                <td>
                                    <input class="common-text required" name="name" size="50" type="text" value="${cate1.CATE_NAME }">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>