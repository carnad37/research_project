package research.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class JdbcAggregation {
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String DBName = "sample1";
		String ssl = "?useSSL=false";
		String dbURL = "jdbc:mysql://localhost:3306/" + DBName + ssl;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String SQL = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, "root", "user1234");
			SQL = "SELECT COUNT(*) AS COUNT FROM mem WHERE age >= ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 20);
			result = pstmt.executeQuery();
			while(result.next())
			{
				System.out.println("count : " + result.getInt("count"));
				System.out.println("count : " + result.getInt(1));
			}
			SQL = "SELECT MIN(age) AS MIN FROM mem WHERE age >= ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 20);
			result = pstmt.executeQuery();
			while(result.next())
			{
				System.out.println("min : " + result.getInt("min"));
			}
			SQL = "SELECT MAX(age) AS MAX FROM mem WHERE age >= ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 20);
			result = pstmt.executeQuery();
			while(result.next())
			{
				System.out.println("max : " + result.getInt("max"));
			}
			SQL = "SELECT AVG(age) AS AVG FROM mem WHERE age >= ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 20);
			result = pstmt.executeQuery();
			while(result.next())
			{
				System.out.println("avg : " + result.getDouble("avg"));
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
			
		}
	}
}
