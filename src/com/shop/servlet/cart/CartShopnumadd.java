package com.shop.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.shop_CartDao;

/**
 * Servlet implementation class CartShopnumadd
 */
@WebServlet("/cartshopnumadd")
public class CartShopnumadd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String count = request.getParameter("count");
		String esid = request.getParameter("esid");
		
		shop_CartDao.update(Integer.parseInt(esid), Integer.parseInt(count));
	}

}
