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
 * Servlet implementation class SelectFlowerDer
 */
@WebServlet("/selectflowerder")
public class SelectFlowerDer extends HttpServlet {
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
		
		
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id = 0;
		ArrayList<shop_product> list = null;
		if(fid !=null) {
			id = Integer.parseInt(fid);
			list = shop_ProductDao.selectByFid(id);
		}
		
		if(cid !=null){
			id = Integer.parseInt(cid);
			list = shop_ProductDao.selectByCid(id);
		}
		
		request.setAttribute("title", shop_CateDao.selectById(id).getCATE_NAME());
		//request.setAttribute("title2", shop_CateDao.selectById(id2).getCATE_NAME());
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("flowerDer.jsp").forward(request, response);
	}

}
