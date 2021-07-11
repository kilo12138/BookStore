package com.shop.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.shop_CartDao;

/**
 * Servlet implementation class CartShopdel
 */
@WebServlet("/cartshopdel")
public class CartShopdel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String esid = request.getParameter("esid");
		
		shop_CartDao.getDeleteID(Integer.parseInt(esid));
	}

}
