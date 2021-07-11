package com.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	static {
		
		//��������
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public static Connection getconn() {
		//����һ�����Ӷ���
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC","root","171393");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return conn;
		
		
	}
	
	public static int exectuIUD(String sql,Object[] params) {
		int count = 0;
		
		Connection conn = Basedao.getconn();
		
		//׼��sql���
		
		PreparedStatement ps = null;
		
		//insert into user("""""""","") value(?,?,?)
		try {
			
			//׼��sql
			ps = conn.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1, params[i]);
			}
			
			count = ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally {
			Basedao.closeall(null, ps, conn);
		}
		return count;
		
	}
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
		
	}
}
