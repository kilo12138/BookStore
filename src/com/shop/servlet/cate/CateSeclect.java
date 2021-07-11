package com.shop.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_category;
import com.shop.service.shop_CateDao;

/**
 * Servlet implementation class CateSeclect
 */
@WebServlet("/adminjsp/admin_cateseclect")
public class CateSeclect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<shop_category> list = shop_CateDao.selectAll();
		request.setAttribute("catelist",list);
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);
	}


}
