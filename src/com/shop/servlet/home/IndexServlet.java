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
import com.shop.service.shop_CateDao;
import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/indexservlet")
public class IndexServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<shop_category> flist =  shop_CateDao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<shop_category> clist =  shop_CateDao.selectcat("child");
		request.setAttribute("clist", clist);
		
		int id1 = 37;
		ArrayList<shop_product> list1 = shop_ProductDao.selectByFid(id1);
		request.setAttribute("list1", list1);
		
		int id2 = 41;
		ArrayList<shop_product> list2 = shop_ProductDao.selectByCid1(id2);
		request.setAttribute("list2", list2);
		
		int id3 = 42;
		ArrayList<shop_product> list3 = shop_ProductDao.selectByCid1(id3);
		request.setAttribute("list3", list3);
		
		int id4 = 34;
		ArrayList<shop_product> list4 = shop_ProductDao.selectByFid1(id4);
		request.setAttribute("list4", list4);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
