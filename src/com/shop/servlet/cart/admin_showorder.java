package com.shop.servlet.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_cart;
import com.shop.service.shop_CartDao;

/**
 * Servlet implementation class admin_showorder
 */
@WebServlet("/adminjsp/admin_showorder")
public class admin_showorder extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		
		ArrayList<shop_cart> list = shop_CartDao.getCart();
		request.setAttribute("shoplist", list);
		
		request.getRequestDispatcher("admin_order.jsp").forward(request, response);
	}
}
