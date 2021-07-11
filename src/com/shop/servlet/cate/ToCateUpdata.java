package com.shop.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_category;
import com.shop.entity.shop_user;
import com.shop.service.shop_CateDao;
import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class ToCateUpdata
 */
@WebServlet("/adminjsp/admin_tocateupdate")
public class ToCateUpdata extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		//ͨ��ID�����������ѯ
		shop_category cate = shop_CateDao.selectById(id);
		ArrayList<shop_category> list = shop_CateDao.selectAll();
		request.setAttribute("catelist",list);
		request.setAttribute("cate1", cate);
		
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}

}
