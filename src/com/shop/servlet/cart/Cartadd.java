package com.shop.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_cart;
import com.shop.entity.shop_product;
import com.shop.entity.shop_user;
import com.shop.service.shop_CartDao;
import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class Cartadd
 */
@WebServlet("/cartadd")
public class Cartadd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		shop_product p=null;
		String pid=request.getParameter("id");
		String count=request.getParameter("count");
		String url=request.getParameter("url");
		
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		shop_user user=(shop_user)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid=(String)user.getUSER_ID();
			
			//通过用户ID和购物车商品ID 查找有没有这条记录
			
			shop_cart srcsp = shop_CartDao.getCartShop(uid,pid);
			if(srcsp!=null) {
				int srccount = srcsp.getCART_QUANTITY();
				int newcount = srccount+Integer.parseInt(count);
				if(newcount >= 5) {
					newcount = 5;
				}
				shop_CartDao.update(srcsp.getCART_ID(),newcount);
				if(url.equals("s")) {
					response.sendRedirect("selectproductview?id="+pid);
				}else {
					response.sendRedirect("showcart");
				}
			}else {
				
				if(pid!=null) {
					p=shop_ProductDao.selectById(Integer.parseInt(pid));
				}
				
				
				shop_cart cart=new shop_cart(
						0,
						p.getPRODUCT_FILENAME(),
						p.getPRODUCT_NAME(),
						p.getPRODUCT_PRICE(),
						Integer.parseInt(count),
						p.getPRODUCT_STOCK(),
						p.getPRODUCT_ID(),
						uid,
						1
						
						);
				
				shop_CartDao.insert(cart);
				if(url.equals("s")) {
					response.sendRedirect("selectproductview?id="+pid);
				}else {
					response.sendRedirect("showcart");
				}
				//response.sendRedirect("/shop/proDetail.jsp");
			}
			}else {
				response.sendRedirect("/shop/login.jsp");
			}
			
			
		
	}
}
