package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.shop_product;
import com.shop.entity.shop_user;
import com.shop.entity.user_address;

public class user_AddressDao {
	/**
	 * 加入数据库
	 * @param u
	 * @return
	 */
	public static int insert(user_address a) {
		
		String sql = "insert into user_address value(null,?,?,?,?,?)";	
		
		
		
		Object[] params = {
				a.getADDRESS_NAME(),
				a.getADDRESS_MOBILE(),
				a.getADDRESS_TEXT(),
				a.getADDRESS_TEXTS(),
				a.getADDRESS_U_ID()
				
		};
		return Basedao.exectuIUD(sql,params);
	}
	
	
	
	//查询所有
			public static ArrayList<user_address> selectAll(String uid){
				ArrayList<user_address> list = new ArrayList<user_address>();
				//声明结果集，获取连接对象
				ResultSet rs = null;
				Connection conn = Basedao.getconn();
				PreparedStatement ps = null;
				try {
					String sql ="select * from user_address where ADDRESS_U_ID = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, uid);
					rs = ps.executeQuery();
					while(rs.next()) {
						user_address p = new user_address(
								rs.getInt("ADDRESS_ID"),
								rs.getString("ADDRESS_NAME"),
								rs.getString("ADDRESS_MOBILE"),
								rs.getString("ADDRESS_TEXT"),
								rs.getString("ADDRESS_TEXTS"),
								rs.getString("ADDRESS_U_ID")
								);
						list.add(p);
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}finally {
					Basedao.closeall(rs, ps, conn);
				}
				return list;
			}
			
			
			public static int del(String uid,String pid) {
				String sql="delete from user_address where ADDRESS_ID =? and ADDRESS_U_ID =?";
				Object[] params= {
						pid,uid
				};
				
				return Basedao.exectuIUD(sql, params);
						
			}
}
