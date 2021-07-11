package com.shop.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.entity.shop_user;
import com.shop.service.shop_UserDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/adminjsp/admin_douserselect")
public class DoUserSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int cpage = 1;//��ǰҳ
		int count = 5;//ÿһҳ��ʾ����
		
		//��ȡ�û�ָ��ҳ��
		String cp = request.getParameter("cp");
		if(cp!=null) {
			cpage = Integer.parseInt(cp);
		}
		
		//�����û������ؼ���
		String keyword = request.getParameter("keywords");
		
		int arr[] = shop_UserDao.totalpage(count, keyword);
		
		
		
		
		//��ȡ�����û���¼
		ArrayList<shop_user> list = shop_UserDao.selectAll(cpage,count,keyword);
		
		//���������������
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
		if(keyword != null)
		{
			request.setAttribute("searchParams", "$keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
		
	}
}
