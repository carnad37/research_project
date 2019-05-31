package research.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import research.main.Person;
import research.main.Research;
import research.main.UnitQA;

public class ResearchDAO {	
	private Connection getConnection() {
		Connection connection = null;
		Context context = null;
		Context envContext = null;
		DataSource dataSource = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MySQLDB");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	//=====================Update
	
	public void updateCommit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	public void updateRollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
	}
	
	
	
	public int updateQAToDB(UnitQA unitQA, String SQL) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			int count = 1;
			pstmt.setString(count, unitQA.getQuestion());
			List<String> answerList = unitQA.getAnswer();
			for (String answer : answerList) {
				count++;
				pstmt.setString(count, answer);
			}
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				conn.rollback();
			} else {
				conn.commit();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int createTableToDB(String SQL) {
		int retval = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			retval = stmt.executeUpdate(SQL);
			if (retval != 1) {
				conn.rollback();
			} else {
				conn.commit();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}

	public int deleteToDB(String delInfo, String dropTalbe, String dropResult ) {
		int retval = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(delInfo);
			stmt.executeUpdate(dropTalbe);
			stmt.executeUpdate(dropResult);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int completeRegistration(int research_id, int maxAnswerNumber) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("UPDATE RESEARCH_INFO SET register=0, answer_number = ? WHERE research_id = ?");
			pstmt.setInt(1, maxAnswerNumber);
			pstmt.setInt(2, research_id);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				conn.rollback();
			} else {
				conn.commit();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int createResearch(Research research) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = null;
		try {
			conn = getConnection();
			SQL = "insert into research_info(title, customer, subject, question_number, answer_number, open_date, close_date, register) values( ?, ?, ?, ?, ?, ?, ?, 1)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, research.getTitle());
			pstmt.setString(2, research.getCustomer());
			pstmt.setString(3, research.getSubject());
			pstmt.setInt(4, research.getMax_qnum());
			System.out.println("µî·Ï : " + research.getMax_anum());
			pstmt.setInt(5, research.getMax_anum());
			pstmt.setString(6, research.getOpendate());
			pstmt.setString(7, research.getClosedate());
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				conn.rollback();
				System.out.println("DB : rollback");
			} else {
				conn.commit();
				System.out.println("DB : commit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}

	public Connection joinResearch(Person person, String SQL) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			int count = 1;
			pstmt.setString(count, person.getSex());
			count++;
			pstmt.setInt(count, person.getAge());
			count++;
			pstmt.setString(count, person.getJob());
//			int[] questionArray = person.getAnswerArray();
//			for (int question : questionArray) {
//				count++;
//				pstmt.setInt(count, question);
//			}
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("DB : personData update fail");
			} else {
				System.out.println("DB : personData update sucess");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
		return conn;
	}
	
	public void joinResearchAnswer(Connection conn, int answer, String SQL) {
		int retval = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, answer);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("DB : answer update fail");
			} else {
				System.out.println("DB : answer update sucess");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
		}
	}
//	public int addAnswerColumn(Research research, int maxAnum) {
//		int retval = 0;
//		int researchID = research.getResearch_id();
//		int lastAnum = research.getMax_anum();
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			conn = getConnection();
//			stmt = conn.createStatement();
//			for (int i = lastAnum + 1; i <= maxAnum; i++) {
//				String SQL = "ALTER TABLE research_" + researchID + " ADD " + i + "_ans VARCHAR(50) NULL";
//				retval = stmt.executeUpdate(SQL);
//				System.out.println("add query : " + retval);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
//			if (conn != null) try {conn.close();} catch (SQLException e) {}
//		}
//		return retval;
//	}
	
	//=====================Query	
		
	public int getLastInsertID(Connection conn) {
		String SQL = "SELECT LAST_INSERT_ID() AS last_id FROM research_result";
		Statement stmt = null;
		ResultSet rs = null;
		int res = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			if (rs != null) {
				while (rs.next()) {
					res = rs.getInt("last_id");
					System.out.println("last_id : " + res);
				}
			} else {
				System.out.println("resultSet is null");
			} 
			
		} catch (Exception e) {
				// TODO: handle exception
		}
		return res;
	}
	
	public int getResearchID() {
		int researchID = 0;
		String SQL = "SELECT MAX(RESEARCH_ID) AS MAX FROM RESEARCH_INFO";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ERROR : NO DATA");
			} else {
				while (rs.next()) {
					researchID = rs.getInt("MAX");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return researchID;
	}
	
	public List<Research> getResearch() {
		String SQL = "SELECT * FROM RESEARCH_INFO ORDER BY research_id";
		ResultSet rs = null;
		Connection conn = null;
		List<Research> researchList = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ERROR : NO DATA");
			} else {
				researchList = new ArrayList<Research>();
				while (rs.next()) {
					String title = rs.getString("TITLE");
					String customer = rs.getString("CUSTOMER");
					String subject = rs.getString("SUBJECT");
					int qNum = rs.getInt("QUESTION_NUMBER");
					String openDate = rs.getString("OPEN_DATE");
					String closeDate = rs.getString("CLOSE_DATE");
					Research research = new Research(title, customer, subject, qNum, openDate, closeDate);
					
					research.setMax_anum(rs.getInt("ANSWER_NUMBER"));
					research.setRegister(rs.getInt("REGISTER"));
					research.setResearch_id(rs.getInt("RESEARCH_ID"));
					researchList.add(research);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return researchList;
	}
	
	public List<Research> getTargetResearch(String SQL) {
		ResultSet rs = null;
		Connection conn = null;
		List<Research> researchList = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ERROR : NO DATA");
			} else {
				researchList = new ArrayList<Research>();
				while (rs.next()) {
					String title = rs.getString("TITLE");
					String customer = rs.getString("CUSTOMER");
					String subject = rs.getString("SUBJECT");
					int qNum = rs.getInt("QUESTION_NUMBER");
					String openDate = rs.getString("OPEN_DATE");
					String closeDate = rs.getString("CLOSE_DATE");
					Research research = new Research(title, customer, subject, qNum, openDate, closeDate);
					
					research.setMax_anum(rs.getInt("ANSWER_NUMBER"));
					research.setRegister(rs.getInt("REGISTER"));
					research.setResearch_id(rs.getInt("RESEARCH_ID"));
					researchList.add(research);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return researchList;
	}
	
	public List<UnitQA> getListQA(int research_id, int maxAnswerNum) {
		String SQL = "SELECT * FROM research_" + research_id + " ORDER BY qid";
		ResultSet rs = null;
		Connection conn = null;
		List<UnitQA> listQA = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ERROR : NO DATA");
			} else {
				listQA = new ArrayList<UnitQA>();
				while (rs.next()) {
					String question = rs.getString("QUESTION");
					List<String> answerList = new ArrayList<String>();
					for (int i = 1; i <= maxAnswerNum; i++) {
						String target = i + "_ans";
						String answer = rs.getString(target);
						if (answer != null) {
							answerList.add(answer);
						}
					}
					UnitQA unitQA = new UnitQA();					
					unitQA.setQuestion(question);
					unitQA.setAnswer(answerList);
					listQA.add(unitQA);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return listQA;
	} 	
	
	public Map<Integer, List<Person>> getResultMap(String SQL) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<Integer, List<Person>> resultMap = new HashMap<Integer, List<Person>>();
//		int res = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			if (rs != null) {
				while (rs.next()) {
					int researchID = rs.getInt("research_id");
					Person person = new Person();
					person.setAge(rs.getInt("age"));
					person.setSex(rs.getString("sex"));
					person.setJob(rs.getString("job"));
					
					int count = 0;
					List<Integer> answerList = new ArrayList<Integer>();
					while (true) {
						int answer = rs.getInt((count + 1) + "_qus");
						if (answer != 0) {
							answerList.add(answer);
						} else {
							break;
						}
						count++;
					}
					count = 0;
					person.setAnswerArray(answerList.size());
					for (Integer integer : answerList) {
						person.saveAnswerArray(count, integer);
						count++;
					}

					if (resultMap.containsKey(researchID)) {
						List<Person> personList = resultMap.get(researchID);
						personList.add(person);
					} else {
						List<Person> personList = new ArrayList<Person>();
						personList.add(person);
						resultMap.put(researchID, personList);
					}
					
				}
			} else {
				System.out.println("resultSet is null");
			} 
			
		} catch (Exception e) {
				// TODO: handle exception
		}
		return resultMap;
	}
	
//	public List<Person> getResultList(String SQL) {
//		
//	}
}
