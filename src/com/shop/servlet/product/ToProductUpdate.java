package com.shop.servlet.product;

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
 * Servlet implementation class ToProductUpdate
 */
@WebServlet("/adminjsp/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//通过ID到数据里面查询
		shop_product p = shop_ProductDao.selectById(id);
		request.setAttribute("p", p);
		request.setAttribute("p1", p.getPRODUCT_CID());
		
		
		request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);
	}
}
