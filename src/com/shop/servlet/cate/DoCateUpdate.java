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
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/adminjsp/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html/charset=utf-8");
				
				int id = Integer.parseInt(request.getParameter("cateid"));
				int fid = Integer.parseInt(request.getParameter("parentid"));
				String name = request.getParameter("name");
				
				shop_category cate = new shop_category(id,name,fid);
				shop_CateDao.updata(cate);
				
				response.sendRedirect("admin_cateseclect");
	}

}
