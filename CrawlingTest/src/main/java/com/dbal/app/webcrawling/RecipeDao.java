package com.dbal.app.webcrawling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String password = "1234";

	public Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	public RecipeDao() {
		try {
			Class.forName(driver); // 드라이버 로드
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace(); // 어떤 오류가 떴는지 알수있음
		}
	}
	
	private String InsertRecipe = "insert into recipe(R_ID, R_TITLE, R_CONTENT, R_IMAGE, R_DATE) values(rec_seq.nextval,?,?,?,sysdate)";
	public int InsertRecipe(RecipeVo vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(InsertRecipe);
			psmt.setString(1, vo.getR_TITLE());
			psmt.setString(2, vo.getR_CONTENT());
			psmt.setString(3, vo.getR_IMAGE());
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private String InsertRecipeMaterial =
			"insert into recipe_material(MAT_ID, MAT_NAME, MAT_VOL) values(mat_seq.nextval, ?, ?)";
	public int InsertRecipeMaterial(RecipeVo vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(InsertRecipeMaterial);
			psmt.setString(1, vo.getMAT_NAME());
			psmt.setString(2, vo.getMAT_VOL());
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
