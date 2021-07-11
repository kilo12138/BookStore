package com.shop.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_category;
import com.shop.entity.shop_product;
import com.shop.entity.shop_user;
import com.shop.service.shop_CateDao;
import com.shop.service.shop_ProductDao;
import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class DoSelectProduct
 */
@WebServlet("/doselectproduct")
public class DoSelectProduct extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<shop_category> flist =  shop_CateDao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<shop_category> clist =  shop_CateDao.selectcat("child");
		request.setAttribute("clist", clist);
		
		//接受用户搜索关键字
		String keyword = request.getParameter("keywords");
		request.setAttribute("title", keyword);
		
		//获取所有用户记录
		ArrayList<shop_product> list = shop_ProductDao.selectAll(keyword);
		request.setAttribute("productlist", list);
		
		
		if(keyword != null)
		{
			request.setAttribute("searchParams", "$keywords="+keyword);
		}
		request.getRequestDispatcher("searchproduct.jsp").forward(request, response);
	}
}
