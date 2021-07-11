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
 * Servlet implementation class DoUserDel
 */
@WebServlet("/adminjsp/admin_douserdel")
public class DoUserDel extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		String id = request.getParameter("id");

		//���뵽���ݿ���û�����
		
		
		int count = shop_UserDao.del(id);
		
		
		//�ɹ���ʧ��
		
		
		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		}else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('�û�scʧ��ʧ��')");
			out.write("localtion.href='adminjsp/admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ַ���
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
		
		String ids[] = request.getParameterValues("id[]");

		//���뵽���ݿ���û�����
		
		for(int i=0; i<ids.length;i++) {
			shop_UserDao.del(ids[i]);
		}
	
		//�ɹ���ʧ��
			response.sendRedirect("admin_douserselect");
	}

}
