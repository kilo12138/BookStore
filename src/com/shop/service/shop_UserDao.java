package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.shop_user;

public class shop_UserDao {
	/**
	 * 加入数据库
	 * @param u
	 * @return
	 */
	public static int insert(shop_user u) {
		
		String sql = "insert into shop_user value(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";	
		
		
		
		Object[] params = {u.getUSER_ID(),
							u.getUSER_NAME(),
							u.getUSER_PASSWORD(),
							u.getUSER_SEX(),
							u.getUSER_BIRTHDAY(),
							u.getUSER_IDENITY_CODE(),
							u.getUSER_EMAIL(),
							u.getUSER_MOBILE(),
							u.getUSER_ADDRESS(),
							u.getUSER_STATUS()};
		return Basedao.exectuIUD(sql,params);
	}
	/**
	 * 获取总记录和总页数
	 * @param count
	 * @return
	 */
	public static int[] totalpage(int count, String keyword) {
		int arr[] = {0,1};
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql="";
			if(keyword!=null) {
				sql = "select count(*) from shop_user where USER_NAME like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
			}else {
				sql = "select count(*) from shop_user";
				ps = conn.prepareStatement(sql);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				arr[0] = rs.getInt(1);
				
				if(arr[0]%count == 0) {
				arr[1] = arr[0]/count;}
				else {
					arr[1] = arr[0]/count+1;
				}
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return arr;
	}
	
	
	
	
	//
	public static ArrayList<shop_user> selectAll(int cpage,int count,String keyword){

		ArrayList<shop_user> list = new ArrayList<shop_user>();
		
		
		//声明结果集，获取连接对象
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "";
			if(keyword != null) {
				sql = "select * from shop_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+keyword+"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}else {
				sql = "select * from shop_user order by USER_BIRTHDAY desc limit ?,?";
				ps = conn.prepareStatement(sql);

				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
			
			
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shop_user u = new shop_user(rs.getString("USER_ID"),
											rs.getString("USER_NAME"),
											rs.getString("USER_PASSWORD"),
											rs.getString("USER_SEX"),
											rs.getString("USER_BIRTHDAY"),
											rs.getString("USER_IDENITY_CODE"),
											rs.getString("USER_EMAIL"),
											rs.getString("USER_MOBILE"),
											rs.getString("USER_ADDRESS"),
											rs.getInt("USER_STATUS"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}
	
	
	/**
	 * 通过ID查找yonghu
	 * @param cpage
	 * @param count
	 * @param keyword
	 * @return
	 */
	public static shop_user selectById(String id){
		shop_user u =null;
		
		//声明结果集，获取连接对象
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *from shop_user where USER_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new shop_user(rs.getString("USER_ID"),
											rs.getString("USER_NAME"),
											rs.getString("USER_PASSWORD"),
											rs.getString("USER_SEX"),
											rs.getString("USER_BIRTHDAY"),
											rs.getString("USER_IDENITY_CODE"),
											rs.getString("USER_EMAIL"),
											rs.getString("USER_MOBILE"),
											rs.getString("USER_ADDRESS"),
											rs.getInt("USER_STATUS"));
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return u;
	}
	
	/**
	 * 修改用户
	 */
	public static int updata(shop_user u) {
		
		String sql = "update shop_user set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=?,USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";	
		
		
		
		Object[] params = {
							u.getUSER_NAME(),
							u.getUSER_PASSWORD(),
							u.getUSER_SEX(),
							u.getUSER_BIRTHDAY(),
							u.getUSER_IDENITY_CODE(),
							u.getUSER_EMAIL(),
							u.getUSER_MOBILE(),
							u.getUSER_ADDRESS(),
							u.getUSER_STATUS(),
							u.getUSER_ID()};
		return Basedao.exectuIUD(sql,params);
	}
	
	
	/**
	 * 修改用户
	 */
	public static int del(String id) {
		
		String sql = "delete from shop_user where USER_ID=?";	
		
		
		
		Object[] params = {id};
		return Basedao.exectuIUD(sql,params);
	}
	
	
	
	
	public static int selectByName(String name)  {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql="select count(*) from shop_user where USER_Name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
	
	public static int selectByNM(String name,String pwd) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql="select count(*) from shop_user where USER_Name = ? and USER_PASSWORD = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
	
	public static shop_user selectAdmin(String name,String pwd) {
		/**
		 * 通过用户名和密码查找出用户的所有资料
		 */
		shop_user u =null;
		
		//声明结果集，获取连接对象
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		
		
		PreparedStatement ps = null;
		
		
		
		try {
			String sql = "select *from shop_user where USER_NAME = ? and USER_PASSWORD = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new shop_user(rs.getString("USER_ID"),
											rs.getString("USER_NAME"),
											rs.getString("USER_PASSWORD"),
											rs.getString("USER_SEX"),
											rs.getString("USER_BIRTHDAY"),
											rs.getString("USER_IDENITY_CODE"),
											rs.getString("USER_EMAIL"),
											rs.getString("USER_MOBILE"),
											rs.getString("USER_ADDRESS"),
											rs.getInt("USER_STATUS"));
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return u;
	}
}



