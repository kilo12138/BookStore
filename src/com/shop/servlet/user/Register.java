package com.shop.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_user;
import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html/charset=utf-8");
				
				//String username = request.getParameter("username");
				String name = request.getParameter("userid");
				String pwd = request.getParameter("userpaw");

				
				
				shop_user u = new shop_user(name,name,pwd,null,null,null,null,null,null,1);
				
				//加入到数据库的用户表中
				
				
				int count = shop_UserDao.insert(u);
				
				
				//成功或失败
				
				
				if(count>0) {
					response.sendRedirect("/shop/login.jsp");
				}else {
					response.sendRedirect("/shop/reg.jsp");
				}
				
	}

}
