package com.shop.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_category;
import com.shop.entity.shop_user;
import com.shop.service.shop_CartDao;
import com.shop.service.shop_CateDao;

/**
 * Servlet implementation class Docartye
 */
@WebServlet("/docartye")
public class Docartye extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html/charset=utf-8");
				
		ArrayList<shop_category> flist =  shop_CateDao.selectcat("father");
		request.setAttribute("flist", flist);
		
		ArrayList<shop_category> clist =  shop_CateDao.selectcat("child");
		request.setAttribute("clist", clist);
				
		HttpSession session=request.getSession();
		String isLogin=(String)session.getAttribute("isLogin");
		shop_user user=(shop_user)session.getAttribute("name");
				
		String eids = request.getParameter("id");
		System.out.print(eids);
		String ids[] = eids.split(",");
		String uid=(String)user.getUSER_ID();
		for(int i=0;i<ids.length;i++) {
			int count = shop_CartDao.updatevalid(ids[i],uid);
			if(count == ids.length) {
				response.sendRedirect("ok.jsp");
			}
		}		
	}
}
