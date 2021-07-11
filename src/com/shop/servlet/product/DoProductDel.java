package com.shop.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class DoProductDel
 */
@WebServlet("/adminjsp/admin_doproductdel")
public class DoProductDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id =  Integer.parseInt(request.getParameter("id"));
		shop_ProductDao.del(id);
		
		response.sendRedirect("admin_productselect");
	}

}
