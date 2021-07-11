package com.shop.servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_product;
import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class productselect
 */
@WebServlet("/adminjsp/admin_productselect")
public class productselect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<shop_product> plist = shop_ProductDao.selectAll();
		
		
		request.setAttribute("plist", plist);
		
		
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}
}
