package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_user;
import com.shop.entity.user_address;
import com.shop.service.shop_ProductDao;
import com.shop.service.user_AddressDao;

/**
 * Servlet implementation class doaddressadd
 */
@WebServlet("/doaddressadd")
public class doaddressadd extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uid = request.getParameter("uid");
		
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String addresss = request.getParameter("addresss");
		
		user_address a = new user_address(0,name,mobile,address,addresss,uid);
		
		int count = user_AddressDao.insert(a);
		
		if(count>0) {
			response.sendRedirect("showaddress");
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('ÓÃ»§ĞŞ¸ÄÊ§°Ü');");
			out.write("localtion.href='indexservlet'");
			out.write("</script>");
		}
	}

}
