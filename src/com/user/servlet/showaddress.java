package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_category;
import com.shop.entity.shop_user;
import com.shop.entity.user_address;
import com.shop.service.shop_CateDao;
import com.shop.service.user_AddressDao;

/**
 * Servlet implementation class showaddress
 */
@WebServlet("/showaddress")
public class showaddress extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
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
			ArrayList<user_address> list = user_AddressDao.selectAll(uid);
			request.setAttribute("addresslist",list);
			
			
			request.getRequestDispatcher("address.jsp").forward(request, response);
		}else {
			response.sendRedirect("/shop/login.jsp");
		}
	}
}
