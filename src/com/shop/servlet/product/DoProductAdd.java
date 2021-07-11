package com.shop.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.shop.entity.shop_product;
import com.shop.service.shop_ProductDao;

/**
 * Servlet implementation class DoProductAdd
 */
@WebServlet("/adminjsp/admin_doproductadd")
public class DoProductAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ΪͼƬ��Ҫ�ϴ�����from�Ķ����ϴ���Ҫjre��
		//����SmartUpload����
		SmartUpload su = new SmartUpload();
		
		//��ʼ��
		su.initialize(this.getServletConfig(), request, response);
		
		//�ϴ�����
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		//��ȡ�ϴ��ļ�����
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		
		//��ȡ�ϴ����ļ�����
		String fname = f.getFileName();
		
		try {
			su.save("/images/product");
		} catch (SmartUploadException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Request req1 = su.getRequest();
		
		String pname = req1.getParameter("productname");
		String id = req1.getParameter("parentid");
		String price = req1.getParameter("price");
		String desc = req1.getParameter("dest");
		String stock = req1.getParameter("num");
		
		
		//SmartUpload �ַ�ת�������
		String pname1 = new String(pname.getBytes(),"utf-8");
		String id1 = new String(id.getBytes(),"utf-8");
		String price1 = new String(price.getBytes(),"utf-8");
		String desc1 = new String(desc.getBytes(),"utf-8");
		String stock1 = new String(stock.getBytes(),"utf-8");
		//String fname1 = new String(fname.getBytes(),"utf-8");
		
		shop_product p = new shop_product(
										0,
										pname1,
										desc1,
										Integer.parseInt(price1),
										Integer.parseInt(stock1),
										Integer.parseInt(id1.split("-")[0]),
										Integer.parseInt(id1.split("-")[1]),
										fname
				);
		
		int count = shop_ProductDao.insert(p);
		
		if(count>0) {
			response.sendRedirect("/shop/adminjsp/admin_productselect");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alert('tushuʧ��');");
			out.write("location.href='adminjsp/admin_useradd.jsp';");
			out.write("</script>");
		}
	}

}
