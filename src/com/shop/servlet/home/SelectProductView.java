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
 * Servlet implementation class SelectProductView
 */
@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
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

		
		
		
		String id = request.getParameter("id");
		shop_product p = null;
		if(id!=null) {
			p = shop_ProductDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		
		if(p !=null) {
			int cid = p.getPRODUCT_CID();
			ArrayList<shop_product> classlist = shop_ProductDao.selectByCid(cid);
			request.setAttribute("classlist", classlist);
			shop_category cate = shop_CateDao.selectById(cid);
			request.setAttribute("cate", cate);
			int fid = p.getPRODUCT_FID();
			
			ArrayList<shop_product> flasslist = shop_ProductDao.selectByFid(fid);
			request.setAttribute("flasslist", flasslist);
			shop_category date = shop_CateDao.selectById(fid);
			request.setAttribute("date", date);
		}
		
		
		
		
		request.getRequestDispatcher("proDetail.jsp").forward(request, response);
	}
}
