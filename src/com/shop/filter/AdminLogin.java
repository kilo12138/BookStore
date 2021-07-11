package com.shop.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
@WebFilter("/adminjsp/*")
public class AdminLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html/charset=utf-8");
		
		
		HttpSession session = req.getSession();
		String flag = (String)session.getAttribute("isAdminLogin");
		
		String request_uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String uri = request_uri.substring(ctxPath.length());
		
		
		if(uri.contains("admin_")) {
			if(flag != null && flag.equals("1")) {
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect("/shop/adminjsp/login.jsp");
				return;
			}
		}else {
			chain.doFilter(request, response);
		}
		
		//return //不通过直接返回
		// pass the request along the filter chain
		//chain.doFilter(request, response);  //通过执行这行代码
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
