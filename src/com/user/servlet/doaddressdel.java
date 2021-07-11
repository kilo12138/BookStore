package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.shop_UserDao;
import com.shop.service.user_AddressDao;

/**
 * Servlet implementation class doaddressdel
 */
@WebServlet("/doaddressdel")
public class doaddressdel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//…Ë÷√◊÷∑˚ºØ
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		String uid = request.getParameter("id");
		String pid = request.getParameter("pid");
		
		
		int count = user_AddressDao.del(uid,pid);
		
		
		if(count>0) {
			response.sendRedirect("showaddress");
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('”√ªßsc ß∞‹ ß∞‹')");
			out.write("localtion.href='adminjsp/admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}
}
