package com.shop.servlet.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_cart;
import com.shop.entity.shop_category;
import com.shop.entity.shop_user;
import com.shop.service.shop_CartDao;
import com.shop.service.shop_CateDao;

/**
 * Servlet implementation class ShowMyCart
 */
@WebServlet("/showmycart")
public class ShowMyCart extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//?????ַ???
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
				
		ArrayList<shop_category> flist =  shop_CateDao.selectcat("father");
		request.setAttribute("flist", flist);
				
		ArrayList<shop_category> clist =  shop_CateDao.selectcat("child");
		request.setAttribute("clist", clist);
		
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		shop_user user=(shop_user)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
			String uid=(String)user.getUSER_ID();
			
			ArrayList<shop_cart> list = shop_CartDao.getCart(uid);
			request.setAttribute("shoplist", list);
			System.out.print(list);
			
			
			request.getRequestDispatcher("myorderq.jsp").forward(request, response);
		}else {
			response.sendRedirect("/shop/login.jsp");
		}
	}
}
