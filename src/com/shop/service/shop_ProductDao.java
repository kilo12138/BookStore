package com.shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.dao.Basedao;
import com.shop.entity.shop_category;
import com.shop.entity.shop_product;
import com.shop.entity.shop_user;

public class shop_ProductDao {

	/**
	 * �������ݿ�
	 * @param u
	 * @return
	 */
	public static int insert(shop_product p) {
		
		String sql = "insert into shop_product value(null,?,?,?,?,?,?,?)";	
		
		
		
		Object[] params = {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_FILENAME()
				
		};
		return Basedao.exectuIUD(sql,params);
	}
	
	/**
	 * �������ݿ�
	 * @param u
	 * @return
	 */
	public static int update(shop_product p) {
		
		String sql = "update shop_product set PRODUCT_NAME=?,PRODUCT_DESCRIPTION=?,PRODUCT_PRICE=?,PRODUCT_STOCK=?,PRODUCT_FID=?,PRODUCT_CID=?,PRODUCT_FILENAME=? where PRODUCT_ID=?";	
		
		
		
		Object[] params = {
				p.getPRODUCT_NAME(),
				p.getPRODUCT_DESCRIPTION(),
				p.getPRODUCT_PRICE(),
				p.getPRODUCT_STOCK(),
				p.getPRODUCT_FID(),
				p.getPRODUCT_CID(),
				p.getPRODUCT_FILENAME(),
				p.getPRODUCT_ID()
				
		};
		return Basedao.exectuIUD(sql,params);
	}
	
	/**
	 * �������ݿ�
	 * @param u
	 * @return
	 */
	public static int updatestock(String pid,int over) {
		
		String sql = "update shop_product set PRODUCT_STOCK = ? where PRODUCT_ID=?";	
		
		
		
		Object[] params = {
				over,pid
				
		};
		return Basedao.exectuIUD(sql,params);
	}
	
	
	//��ѯ����
		public static ArrayList<shop_product> selectAll(){

			ArrayList<shop_product> list = new ArrayList<shop_product>();
			
			
			//�������������ȡ���Ӷ���
			ResultSet rs = null;
			Connection conn = Basedao.getconn();
			PreparedStatement ps = null;
			
			
			
			try {
				String sql ="select * from shop_product";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					shop_product p = new shop_product(
									rs.getInt("PRODUCT_ID"),
									rs.getString("PRODUCT_NAME"),
									rs.getString("PRODUCT_DESCRIPTION"),
									rs.getInt("PRODUCT_PRICE"),
									rs.getInt("PRODUCT_STOCK"),
									rs.getInt("PRODUCT_FID"),
									rs.getInt("PRODUCT_CID"),
									rs.getString("PRODUCT_FILENAME"));
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			
			return list;
		}
	
		
		//��ѯ����
				public static ArrayList<shop_product> selectByFid(int id){

					ArrayList<shop_product> list = new ArrayList<shop_product>();
					
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_product where PRODUCT_FID = ?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_product p = new shop_product(
											rs.getInt("PRODUCT_ID"),
											rs.getString("PRODUCT_NAME"),
											rs.getString("PRODUCT_DESCRIPTION"),
											rs.getInt("PRODUCT_PRICE"),
											rs.getInt("PRODUCT_STOCK"),
											rs.getInt("PRODUCT_FID"),
											rs.getInt("PRODUCT_CID"),
											rs.getString("PRODUCT_FILENAME"));
							list.add(p);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return list;
				}
				
				//��ѯ����
				public static ArrayList<shop_product> selectByFid1(int id){

					ArrayList<shop_product> list = new ArrayList<shop_product>();
					
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_product where PRODUCT_FID = ? limit 3";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_product p = new shop_product(
											rs.getInt("PRODUCT_ID"),
											rs.getString("PRODUCT_NAME"),
											rs.getString("PRODUCT_DESCRIPTION"),
											rs.getInt("PRODUCT_PRICE"),
											rs.getInt("PRODUCT_STOCK"),
											rs.getInt("PRODUCT_FID"),
											rs.getInt("PRODUCT_CID"),
											rs.getString("PRODUCT_FILENAME"));
							list.add(p);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return list;
				}
				
				//��ѯ����
				public static ArrayList<shop_product> selectByCid(int id){

					ArrayList<shop_product> list = new ArrayList<shop_product>();
					
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_product where PRODUCT_CID = ?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_product p = new shop_product(
											rs.getInt("PRODUCT_ID"),
											rs.getString("PRODUCT_NAME"),
											rs.getString("PRODUCT_DESCRIPTION"),
											rs.getInt("PRODUCT_PRICE"),
											rs.getInt("PRODUCT_STOCK"),
											rs.getInt("PRODUCT_FID"),
											rs.getInt("PRODUCT_CID"),
											rs.getString("PRODUCT_FILENAME"));
							list.add(p);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return list;
				}
				
				//��ѯ����
				public static ArrayList<shop_product> selectByCid1(int id){

					ArrayList<shop_product> list = new ArrayList<shop_product>();
					
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_product where PRODUCT_CID = ? limit 4";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_product p = new shop_product(
											rs.getInt("PRODUCT_ID"),
											rs.getString("PRODUCT_NAME"),
											rs.getString("PRODUCT_DESCRIPTION"),
											rs.getInt("PRODUCT_PRICE"),
											rs.getInt("PRODUCT_STOCK"),
											rs.getInt("PRODUCT_FID"),
											rs.getInt("PRODUCT_CID"),
											rs.getString("PRODUCT_FILENAME"));
							list.add(p);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return list;
				}
				
				//��ѯ����
				public static shop_product selectById(int id){

					shop_product p = null;
					
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();
					PreparedStatement ps = null;
					
					
					
					try {
						String sql ="select * from shop_product where PRODUCT_ID = ?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while(rs.next()) {
							p = new shop_product(
											rs.getInt("PRODUCT_ID"),
											rs.getString("PRODUCT_NAME"),
											rs.getString("PRODUCT_DESCRIPTION"),
											rs.getInt("PRODUCT_PRICE"),
											rs.getInt("PRODUCT_STOCK"),
											rs.getInt("PRODUCT_FID"),
											rs.getInt("PRODUCT_CID"),
											rs.getString("PRODUCT_FILENAME"));
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					
					
					return p;
				}
				
				/**
				 * �޸��û�
				 */
				public static int del(int id) {
					
					String sql = "delete from shop_product where PRODUCT_ID=?";	
					
					
					
					Object[] params = {id};
					return Basedao.exectuIUD(sql,params);
				}
				
				
				
				//
				public static ArrayList<shop_product> selectAll(String keyword){
					ArrayList<shop_product> list = new ArrayList<shop_product>();
					
					//�������������ȡ���Ӷ���
					ResultSet rs = null;
					Connection conn = Basedao.getconn();					
					PreparedStatement ps = null;					
					try {
						String sql = "";
						if(keyword != null) {
							sql = "select * from shop_product where PRODUCT_NAME like ?";
							ps = conn.prepareStatement(sql);
							ps.setString(1, "%"+keyword+"%");
						}else {
							sql = "select * from shop_product ";
							ps = conn.prepareStatement(sql);
						}
						rs = ps.executeQuery();
						while(rs.next()) {
							shop_product u = new shop_product(
									rs.getInt("PRODUCT_ID"),
									rs.getString("PRODUCT_NAME"),
									rs.getString("PRODUCT_DESCRIPTION"),
									rs.getInt("PRODUCT_PRICE"),
									rs.getInt("PRODUCT_STOCK"),
									rs.getInt("PRODUCT_FID"),
									rs.getInt("PRODUCT_CID"),
									rs.getString("PRODUCT_FILENAME"));
							list.add(u);
						}
					} catch (SQLException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}finally {
						Basedao.closeall(rs, ps, conn);
					}
					return list;
				}
	
}
