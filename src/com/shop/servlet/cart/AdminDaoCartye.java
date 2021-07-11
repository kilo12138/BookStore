package com.shop.servlet.cart;

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
import com.shop.service.shop_CartDao;
import com.shop.service.shop_CateDao;
import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class AdminDaoCartye
 */
@WebServlet("/adminjsp/admin_docartye")
public class AdminDaoCartye extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		String uid = request.getParameter("uid");
		String pid = request.getParameter("pid");
		String stock = request.getParameter("stock");
		String num = request.getParameter("num");
		int over = Integer.parseInt(stock)-Integer.parseInt(num);
		
		shop_ProductDao.updatestock(pid,over);
		int count = shop_CartDao.cartupdateid(pid,uid);
		
		if(count>0) {
			response.sendRedirect("admin_showorder");
		}else {
			response.sendRedirect("admin_index.jsp");
		}
		
	}
}
