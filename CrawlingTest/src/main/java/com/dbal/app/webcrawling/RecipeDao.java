package com.dbal.app.webcrawling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "project145";
	private String password = "1234";

	public Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	

	public RecipeDao() {
		try {
			Class.forName(driver); // 드라이버 로드
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace(); // 어떤 오류가 떴는지 알수있음
			System.out.println("실패");
		}
	}

	// 레시피 테이블에 입력
	private String InsertRecipe = "insert into recipe(R_ID, R_TITLE, R_CONTENT, R_IMAGE, R_DATE) values('rec' || r_seq.nextval,?,?,?,sysdate)";
	// 재료 테이블에 입력
	private String InsertRecipeMaterial = "insert into recipe_material(MAT_ID, MAT_NAME, MAT_VOL, R_ID ) values('mat' || mat_seq.nextval, ?, ?, 'rec' || r_seq.currval)";
	
	public int InsertRecipe(ArrayList<RecipeVo> list, ArrayList<MaterialVo> mlist) {
		int n = 0;
		try {
			for(RecipeVo vo : list) {
				psmt = conn.prepareStatement(InsertRecipe);
				psmt.setString(1, vo.getR_title());
				psmt.setString(2, vo.getR_content());
				psmt.setString(3, vo.getR_image());
				n = psmt.executeUpdate();
				
				for (MaterialVo mvo : mlist) {
					psmt = conn.prepareStatement(InsertRecipeMaterial);
					psmt.setString(1, mvo.getMat_name());
					psmt.setString(2, mvo.getMat_vol());
	
					n = psmt.executeUpdate();
					System.out.println("재료성공");
				}

				System.out.println("Recipe 성공");
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Recipe 실패");
		} finally {
			close();
		}
		return n;
	}

	// 재료 테이블에 입력
//	private String InsertRecipeMaterial = "insert into recipe_material(MAT_ID, MAT_NAME, MAT_VOL) values(mat_seq.nextval, ?, ?)";
//
//	public int InsertRecipeMaterial(ArrayList<RecipeVo> list) {
//		int n = 0;
//		try {
//			for (RecipeVo vo : list) {
//				psmt = conn.prepareStatement(InsertRecipeMaterial);
//				psmt.setString(1, vo.getMat_name());
//				psmt.setString(2, vo.getMat_vol());
//
//				n = psmt.executeUpdate();
//				System.out.println("재료성공");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("재료실패");
//		} finally {
//			close();
//		}
//		return n;
//	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
