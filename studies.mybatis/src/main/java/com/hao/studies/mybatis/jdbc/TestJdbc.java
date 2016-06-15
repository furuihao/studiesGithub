package com.hao.studies.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull",
							"hao", "frh123456");
			String sql = "select * from persons";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
