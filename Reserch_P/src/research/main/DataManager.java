package research.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class DataManager
{
	public static final int REGEDIT = 1;
	public static final int UNREGEDIT = 2;
	public static final int SAVE = 0;
	public static final int LOAD = 1;
	public static final int UPDATE = 2;
	public static final int DELETE = 3;
	public static final int NO_FUNCTION = 0;
	public static final int CREATE_RESEARCH = 1;
	public static final int CREATE_QUESTION_TABLE = 2;
	public static final int INPUT_RESEARCH = 3;
	public static final int MODIFY_RESEARCH =4;
	public static final int SELECT_TITLE = 1;
	public static final int SELECT_RESEARCH_DB = 2;
	
	public void backUpResearch(List<BackUpData> backUpList) {
		String path = "D:\\HHS\\result\\result.txt";
		List<String> writeWord = new ArrayList<String>();
		
					
		}
	
//	public Map<String,Research> setDBMap(String path)
//	{
//		List<String> dbData = setFileData(path,"researchDB.txt");
//		
//		Map<String,Research> dataBaseMap = new HashMap<String,Research>();
//		
//		for(String data : dbData)
//		{
//			StringTokenizer dbDataToken = new StringTokenizer(data,",");
//			String title = dbDataToken.nextToken();
//			String customer = dbDataToken.nextToken();
//			String subject = dbDataToken.nextToken();
//			String questionNumber = dbDataToken.nextToken();
//			String opendate = dbDataToken.nextToken();
//			String closedate = dbDataToken.nextToken();
//			Research research = new Research(title, customer, subject, questionNumber, opendate, closedate);
//			dataBaseMap.put(title, research);
//		}
//		return dataBaseMap;
//	}
	
//	public void saveAllResearchData(Map<String, Research> researchDB, String mainPath)
//	{
//		String subPath = "researchData.txt";
//		String path = mainPath+subPath;
//
//		List<String> saveList = new ArrayList<String>();
//		
//		Set<String> titleSet = researchDB.keySet();		
//		for(String title : titleSet)
//		{
//			Research research = researchDB.get(title);
//			List<UnitQA> listQA = research.getListQA();
//			if(listQA.isEmpty())
//			{
//				continue;
//			}
//			saveList.add(title);	//타이틀입력
//
//			int questionNumber = research.getQuestionNumber();
//			for(int i=0;i<questionNumber;i++)
//			{
//				UnitQA unitQA = listQA.get(i);
//				String question = unitQA.getQuestion();
//				
//				saveList.add(question);
//				List<String> answer = unitQA.getAnswer();
//				for(String unitAnswer : answer)
//				{
//					saveList.add(unitAnswer);
//				}
//				saveList.add("");
//			}
//		}				
//		saveToTxt(saveList, path);	
//	}
//	
	public void connectDB(Research research, int function) {
		
	}

	
//	public void createResearchinDB(Research research, Connection conn)
//	{
//		PreparedStatement pstmt = null;
//		if (research.getListQA() == null) {
//			String title = research.getTitle();
//			String customer = research.getCustomer();
//			String subject = research.getSubject();
//			int questionNumber = research.getQuestionNumber();
//			String opendate = research.getOpendate();
//			String closedate = research.getClosedate();
//			String sql = "insert into researchdb (title, customer, subject, question_number, open_date, close_date, regedit) values( ?, ?, ?, ?, ?, ?, 1)";
//			try {
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, title);
//				pstmt.setString(2, customer);
//			} catch (SQLException e) {
//			}
//		}
//	}
//	
//	public void loadDataToDB(Research research, String mainPath)
//	{		
//		String title = research.getTitle();
//		String customer = research.getCustomer();
//		String subject = research.getSubject();
//		int questionNumber = research.getQuestionNumber();
//		String opendate = research.getOpendate();
//		String closedate = research.getClosedate();
//		String sql = "select title, customer, subject, question_number, open_date, close_date from researchdb";
//		connectionDB(sql, SAVE);
//	}
//	
//	private PreparedStatement saveResarchData(UnitQA unitQA, PreparedStatement pstmt) throws SQLException	{
//		pstmt.setString(1, research.getTitle());
//		pstmt.setString(2, research.getCustomer());
//		pstmt.setString(3, research.getSubject());
//		pstmt.setInt(4, research.getQuestionNumber());
//		pstmt.setString(5, research.getTitle());
//		pstmt.setString(6, research.getTitle());
//		return pstmt;
//	}
	
	
//	public void deleteDataToDB(Research research, String mainPath)
//	{		
//		String sql = "delete from researchdb where title = ?";
//		connectionDB(sql, DELETE);
//	}	
	
//	public int connectDBToUapdate(Research research, int function) {
//		int retval = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String SQL = null;
//		try {
////			int maxAnswerNumber = research.getMaxAnswerNumber();
//
//			Class.forName(driveName);
//			conn = DriverManager.getConnection(dbURL, "root", "user1234");
//			conn.setAutoCommit(false);
//			if (function == CREATE_RESEARCH) {
//				SQL = "insert into research_info (title, customer, subject, question_number, open_date, close_date, regedit) values( ?, ?, ?, ?, ?, ?, 1)";
//				pstmt = conn.prepareStatement(SQL);
//				createResearch(research, pstmt);
//				retval = pstmt.executeUpdate();
//				if (retval != 1) {
//					conn.rollback();
//				} else {
//					conn.commit();
//				}
//			}
//			else if (function == CREATE_QUESTION_TABLE) {
//				SQL = makeCreateTableSQL(maxAnswerNumber, research.getResearch_id());
//				pstmt = conn.prepareStatement(SQL);
//				retval = pstmt.executeUpdate();
//				if (retval != 1) {
//					conn.rollback();
//				} else {
//					conn.commit();
//				}
//				function = INPUT_RESEARCH;
//			}
//			else if (function == INPUT_RESEARCH) {
//				SQL = makeInsertDataSQL(maxAnswerNumber, research.getResearch_id());
//				pstmt = conn.prepareStatement(SQL);
//				
//				List<UnitQA> listQA = research.getListQA();
//				for (UnitQA unitQA : listQA) {
//					int count = 1;
//					pstmt.setString(count, unitQA.getQuestion());
//					List<String> answerList = unitQA.getAnswer();
//					for (String answer : answerList) {
//						count++;
//						pstmt.setString(count, answer);
//					}
//					retval = pstmt.executeUpdate();
//					if (retval != 1) {
//						conn.rollback();
//						break;
//					} else {
//						conn.commit();
//					}
//				}
//				function = NO_FUNCTION;
//			}
////			else if (function == MODIFY_RESEARCH) {
////				SQL = "insert into research_info (title, customer, subject, question_number, open_date, close_date) values( ?, ?, ?, ?, ?, ?)";
////				pstmt = createResearch(research, pstmt);
////				pstmt.executeUpdate();
////			}
//			pstmt = conn.prepareStatement(SQL);
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
//			if (conn != null) try {conn.close();} catch (SQLException e) {}
//		}
//		if(function == INPUT_RESEARCH) {
//			connectDBToUapdate(research, function);			
//		}
//		return retval;
//	}

	
//	private String setDataToString(Research research)
//	{
//		String title = research.getTitle();
//		String customer = research.getCustomer();
//		String subject = research.getSubject();
//		String qNumber = String.valueOf(research.getQuestionNumber());
//		String opendate = research.getOpendate();
//		String closedate = research.getClosedate();
//		String lineDBData = title+","+customer+","+subject+","+qNumber+","+opendate+","+closedate;
//		return lineDBData;
//	}	
	
//	public void setData(Map<String,Research> researchDB, String path)
//	{
//		String subPath = "researchData.txt";
//		List<String> researchData = setFileData(path, subPath);
//			
//		int i = 0;
//		for(i=0;i<researchData.size();i++)
//		{
//			String title = researchData.get(i);
//			i++;
//			
//			Research research = researchDB.get(title);
//			List<UnitQA> listQA = research.getListQA();
//			
//			int blankCount = 0;
//			int questionNumber = research.getQuestionNumber();
//			while (true)	//답변
//			{
//				String question = researchData.get(i);	//질문
//				i++;
//				
//				List<String> answer = new ArrayList<String>();	//답변
//				
//				while (true)
//				{
//					String unitAnswer = researchData.get(i);
//					i++;
//					
//					if(unitAnswer.equals(""))
//					{
//						blankCount++;
//						break;
//					}
//					answer.add(unitAnswer);
//				}				
//				UnitQA unitQA = new UnitQA(question, answer);
//				listQA.add(unitQA);
//				
//				if(blankCount==questionNumber)
//				{
//					i--;	//135에서 이미 ++해줬으므로 한번 빼준다.
//					break;
//				}
//			}						
//		}
//	}
}
