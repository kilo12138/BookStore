package com.shop.servlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_category;
import com.shop.service.shop_CateDao;

/**
 * Servlet implementation class DoCateDel
 */
@WebServlet("/adminjsp/admin_docatedel")
public class DoCateDel extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id =  Integer.parseInt(request.getParameter("id"));
		shop_CateDao.del(id);
		
		response.sendRedirect("admin_cateseclect");
	}

}
