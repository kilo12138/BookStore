package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html/charset=utf-8");
				
				String name = request.getParameter("name");
				
				int count = shop_UserDao.selectByName(name);
				
				
				PrintWriter out = response.getWriter();
				if(count>0) {
					out.print("false");
				}else {
					out.print("true");
				}
				out.close();
	}


}
