package research.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class TestDB {
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String DBName = "research_db";
		String ssl = "?useSSL=false";
		String dbURL = "jdbc:mysql://localhost:3306/" + DBName + ssl;
		String tableName = "research_management";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, "root", "user1234");
			
			int i = 1;
			String SQL = "insert into " + tableName + " values(?, ?, ?, ?, curdate(), curdate())";
			pstmt = conn.prepareStatement(SQL);
			
			for (int k = 0; k < 100; k++) {
				pstmt.clearParameters();
				for (int j = 0; j < 4; j++) {
					pstmt.setString(j+1, String.valueOf(i));
					i++;
				}
				int retval = pstmt.executeUpdate();
				if (retval != 1) {
					return;
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수가 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLTimeoutException e) {
			System.out.println("서버와의 연결 시간이 초과하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL데이터 베이스에서 오류가 발생하였습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
		}
	}
}
