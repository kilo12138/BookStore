package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.shop_cart;
import com.shop.entity.shop_category;
import com.shop.entity.shop_product;

public class shop_CartDao {
	public static int insert(shop_cart cart){
		String sql="insert into shop_cart values(null,?,?,?,?,?,?,?,1)";
		Object[] params= {
				
				cart.getCART_P_FILENAME(),
				cart.getCART_P_NAME(),
				cart.getCART_P_PRICE(),
				cart.getCART_QUANTITY(),
				cart.getCART_P_STOCK(),
				cart.getCART_P_ID(),
				cart.getCART_U_ID()
				
				
		};
		return Basedao.exectuIUD(sql, params);
	}
	
	//查询所有
		public static ArrayList<shop_cart> getCart(String id){

			ArrayList<shop_cart> list = new ArrayList<shop_cart>();
			
			
			//声明结果集，获取连接对象
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			
			
			
			try {
				String sql ="select * from shop_cart where CART_U_ID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					shop_cart cart = new shop_cart(
												rs.getInt("CART_ID"),
												rs.getString("CART_P_FILENAME"),
												rs.getString("CART_P_NAME"),
												rs.getInt("CART_P_PRICE"),
												rs.getInt("CART_QUANTITY"),
												rs.getInt("CART_P_STOCK"),
												rs.getInt("CART_P_ID"),
												rs.getString("CART_U_ID"),
												rs.getInt("CART_VALID")
												
							);
					list.add(cart);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			return list;
		}
		
		public static shop_cart getCartShop(String uid,String pid) {

			
			shop_cart cart = null;
			//声明结果集，获取连接对象
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			
			
			
			try {
				String sql ="select * from shop_cart where CART_U_ID = ? and CART_P_ID = ? and CART_VALID = 1";
				ps = conn.prepareStatement(sql);
				ps.setString(1, uid);
				ps.setInt(2, Integer.parseInt(pid));
				rs = ps.executeQuery();
				while(rs.next()) {
				cart = new shop_cart(
												rs.getInt("CART_ID"),
												rs.getString("CART_P_FILENAME"),
												rs.getString("CART_P_NAME"),
												rs.getInt("CART_P_PRICE"),
												rs.getInt("CART_QUANTITY"),
												rs.getInt("CART_P_STOCK"),
												rs.getInt("CART_P_ID"),
												rs.getString("CART_U_ID"),
												rs.getInt("CART_VALID")
												
							);
					
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			return cart;
		}
		
public static shop_cart getCartShop(String id) {

			
			shop_cart es = null;
			//声明结果集，获取连接对象
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			
			
			
			try {
				String sql ="select * from shop_cart where CART_P_ID = ? and CART_VALID = 1";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
				es = new shop_cart(
												rs.getInt("CART_ID"),
												rs.getString("CART_P_FILENAME"),
												rs.getString("CART_P_NAME"),
												rs.getInt("CART_P_PRICE"),
												rs.getInt("CART_QUANTITY"),
												rs.getInt("CART_P_STOCK"),
												rs.getInt("CART_P_ID"),
												rs.getString("CART_U_ID"),
												rs.getInt("CART_VALID")
												
							);
					
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			return es;
		}
		
		/**
		 * 加入数据库
		 * @param u
		 * @return
		 */
		public static int update(int esid,int count) {
			
			String sql = "update shop_cart set CART_QUANTITY = ? where CART_ID = ?";	
			
			
			
			Object[] params = {
					count,esid
					
			};
			return Basedao.exectuIUD(sql,params);
		}
		
		
		public static int getDeleteID(int id) {
			String sql="delete from shop_cart where CART_ID =?";
			Object[] params= {
					id
			};
			
			return Basedao.exectuIUD(sql, params);
					
		}
		
		
		/**
		 * 加入数据库
		 * @param u
		 * @return
		 */
		public static int updatevalid(String pid,String uid) {
			
			String sql = "update shop_cart set CART_VALID = 2 where CART_P_ID = ? and CART_U_ID = ?";	
			
			
			
			Object[] params = {
					pid,uid
					
			};
			return Basedao.exectuIUD(sql,params);
		}
		
		/**
		 * 加入数据库
		 * @param u
		 * @return
		 */
		public static int cartupdateid(String pid,String uid) {
			
			String sql = "update shop_cart set CART_VALID = 3 where CART_P_ID = ? and CART_U_ID = ?";	
			
			
			
			Object[] params = {
					pid,uid
					
			};
			return Basedao.exectuIUD(sql,params);
		}
		
		
		//查询所有
				public static ArrayList<shop_cart> getCart(){

					ArrayList<shop_cart> list = new ArrayList<shop_cart>();
					
					
					//声明结果集，获取连接对象
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_cart where CART_VALID = 2";
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_cart cart = new shop_cart(
														rs.getInt("CART_ID"),
														rs.getString("CART_P_FILENAME"),
														rs.getString("CART_P_NAME"),
														rs.getInt("CART_P_PRICE"),
														rs.getInt("CART_QUANTITY"),
														rs.getInt("CART_P_STOCK"),
														rs.getInt("CART_P_ID"),
														rs.getString("CART_U_ID"),
														rs.getInt("CART_VALID")
														
									);
							list.add(cart);
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return list;
				}
}
