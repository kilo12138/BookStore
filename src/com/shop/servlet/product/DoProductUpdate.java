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
 * Servlet implementation class DoProductUpdate
 */
@WebServlet("/adminjsp/admin_doproductupdate")
public class DoProductUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//因为图片需要上传，将from的对象上传需要jre包
				//创建SmartUpload对象
				SmartUpload su = new SmartUpload();
				
				//初始化
				su.initialize(this.getServletConfig(), request, response);
				
				//上传过程
				try {
					su.upload();
				} catch (SmartUploadException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				
				//获取上传文件对象
				Files fs = su.getFiles();
				File f = fs.getFile(0);
				
				//获取上传的文件名称
				String fname = f.getFileName();
				
				try {
					su.save("/images/product");
				} catch (SmartUploadException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Request req1 = su.getRequest();
				
				String productid = req1.getParameter("productid");
				String pname = req1.getParameter("productname");
				String id = req1.getParameter("parentid");
				String price = req1.getParameter("price");
				String desc = req1.getParameter("dest");
				String stock = req1.getParameter("num");
				
				
				//SmartUpload 字符转码的问题
				String productid1 = new String(productid.getBytes(),"utf-8");
				String pname1 = new String(pname.getBytes(),"utf-8");
				String id1 = new String(id.getBytes(),"utf-8");
				String price1 = new String(price.getBytes(),"utf-8");
				String desc1 = new String(desc.getBytes(),"utf-8");
				String stock1 = new String(stock.getBytes(),"utf-8");
				
				shop_product p = new shop_product(
												Integer.parseInt(productid1),
												pname1,
												desc1,
												Integer.parseInt(price1),
												Integer.parseInt(stock1),
												Integer.parseInt(id1.split("-")[0]),
												Integer.parseInt(id1.split("-")[1]),
												fname
						);
				
				shop_ProductDao.update(p);
				
				response.sendRedirect("/shop/adminjsp/admin_productselect");

	}

}
