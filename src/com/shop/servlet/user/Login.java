package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_user;
import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		//获取用户名
		String name = request.getParameter("userid");
		String pwd = request.getParameter("userpaw");
		
		int count = shop_UserDao.selectByNM(name,pwd);
		
		
		if(count>0) {
			HttpSession session = request.getSession();
			shop_user user = shop_UserDao.selectAdmin(name,pwd);
			
			
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			
			response.sendRedirect("indexservlet");
			
		}else {
			response.sendRedirect("/shop/login.jsp");
		}
	}

}
