package com.shop.servlet.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.entity.shop_cart;
import com.shop.entity.shop_category;
import com.shop.entity.shop_user;
import com.shop.entity.user_address;
import com.shop.service.shop_CartDao;
import com.shop.service.shop_CateDao;
import com.shop.service.user_AddressDao;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
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
		
		String eids = request.getParameter("eids");
		request.setAttribute("id", eids);
		
		if(user!=null && isLogin.equals("1")) {
			String uid = user.getUSER_ID();
			int totalprice=0;
			String ids[] = eids.split(",");
			ArrayList<shop_cart> list = new ArrayList<shop_cart>();
			
			for(int i=0;i<ids.length;i++) {
				shop_cart es = shop_CartDao.getCartShop(ids[i]);
				
				int dprice = es.getCART_P_PRICE() * es.getCART_QUANTITY();
				
				totalprice+=dprice;
				list.add(es);
			}	
			
				ArrayList<user_address> list1 = user_AddressDao.selectAll(uid);
				request.setAttribute("addresslist",list1);
				
				request.setAttribute("list4", list);
				request.setAttribute("totalprice", totalprice);
				
				request.getRequestDispatcher("order.jsp").forward(request, response);
				
			
		}else {
			response.sendRedirect("/shop/login.jsp");
		}
	}
}
