package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.shop_category;
import com.shop.entity.shop_user;

public class shop_CateDao {
	//查询所有
	public static ArrayList<shop_category> selectAll(){

		ArrayList<shop_category> list = new ArrayList<shop_category>();
		
		
		//声明结果集，获取连接对象
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		
		
		
		try {
			String sql ="select * from shop_category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				shop_category cate = new shop_category(
											rs.getInt("CATE_ID"),
											rs.getString("CATE_NAME"),
											rs.getInt("CATE_PARENT_ID"));
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}
	
	
	
	//查询所有子分类
		public static ArrayList<shop_category> selectcat(String flag){

			ArrayList<shop_category> list = new ArrayList<shop_category>();
			
			
			//声明结果集，获取连接对象
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			
			
			
			try {
				if(flag != null&& flag.equals("father")) {
					String sql ="select * from shop_category where CATE_PARENT_ID = 0";
					ps = conn.prepareStatement(sql);
				}else {
					String sql ="select * from shop_category where CATE_PARENT_ID != 0";
					ps = conn.prepareStatement(sql);
				}
				rs = ps.executeQuery();
				while(rs.next()) {
					shop_category cate = new shop_category(
												rs.getInt("CATE_ID"),
												rs.getString("CATE_NAME"),
												rs.getInt("CATE_PARENT_ID"));
					list.add(cate);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			return list;
		}
	
public static int insert(shop_category cate) {
		
		String sql = "insert into shop_category value(null,?,?)";
		
		
		
		Object[] params = {
							cate.getCATE_NAME(),
							cate.getCATE_PARENT_ID()
							};
		return Basedao.exectuIUD(sql,params);
	}



public static shop_category selectById(int id){
	shop_category cate =null;
	
	//声明结果集，获取连接对象
	ResultSet rs = null;
	Connection conn = Basedao.getconn();
	
	
	PreparedStatement ps = null;
	
	
	
	try {
		String sql = "select * from shop_category where CATE_ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			cate = new shop_category(rs.getInt("CATE_ID"),
								rs.getString("CATE_NAME"),
								rs.getInt("CATE_PARENT_ID")
										);
			
		}
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}finally {
		Basedao.closeall(rs, ps, conn);
	}
	
	
	return cate;
}


/**
 * 修改用户
 */
public static int updata(shop_category cate) {
	
	String sql = "update shop_category set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID = ?";	
	
	
	
	Object[] params = {
						cate.getCATE_NAME(),
						cate.getCATE_PARENT_ID(),
						cate.getCATE_ID()};
	return Basedao.exectuIUD(sql,params);
}


/**
 * 修改用户
 */
public static int del(int id) {
	
	String sql = "delete from shop_category where CATE_ID=?";	
	
	
	
	Object[] params = {id};
	return Basedao.exectuIUD(sql,params);
}
}
