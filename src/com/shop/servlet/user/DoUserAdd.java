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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/adminjsp/admin_douseradd")
public class DoUserAdd extends HttpServlet {


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		
		shop_user u = new shop_user(username,name,pwd,sex,year,null,email,mobile,address,1);
		
		//加入到数据库的用户表中
		
		
		int count = shop_UserDao.insert(u);
		
		
		//成功或失败
		
		
		if(count>0) {
			response.sendRedirect("/shop/adminjsp/admin_douserselect");
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.href='adminjsp/admin_useradd.jsp';");
			out.write("</script>");
		}
		

	}

}
