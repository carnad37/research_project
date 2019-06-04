package research.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import research.dao.ResearchDAO;

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
	
	public void saveAllResearchData(List<Research> researchList, Map<Integer, List<Person>> resultMap, String path)
	{
//		String path = mainPath+subPath;
		String dateData = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		List<String> saveList = new ArrayList<String>();
		String savePath = path + "backup_" + dateData + ".txt";
		for (Research research : researchList) {
			int researchID = research.getResearch_id();
			saveList.add("*****start*****");
			saveList.add(research.getTitle());
			saveList.add(research.getCustomer());
			saveList.add(research.getSubject());
			saveList.add(String.valueOf(research.getMax_qnum()));
			saveList.add(String.valueOf(research.getMax_anum()));
			saveList.add(research.getOpendate());
			saveList.add(research.getClosedate());
			saveList.add(String.valueOf(research.getRegister()));
			saveList.add("");
			List<UnitQA> listQA = research.getListQA();
			
			for(int i=0;i<research.getMax_qnum();i++)
			{
				UnitQA unitQA = listQA.get(i);
				String question = unitQA.getQuestion();
				
				saveList.add(question);
				List<String> answer = unitQA.getAnswer();
				for(String unitAnswer : answer)
				{
					saveList.add(unitAnswer);
				}
				saveList.add("");
			}
			
			if (resultMap.containsKey(researchID)) {
				saveList.add("*****result*****");
				List<Person> resultList = resultMap.get(researchID);
				for (Person person : resultList) {
					String resultData = String.valueOf(person.getAge());
					resultData += ", " + person.getSex();
					resultData += ", " + person.getJob();
					int[] answerArray = person.getAnswerArray();
					for (int answer : answerArray) {
						resultData += ", " + String.valueOf(answer);
					}
					saveList.add(resultData);
				}
				saveList.add("");
			}
		}
		System.out.println(saveList);
		FileWrite fw = new FileWrite();
		fw.writeSystem(saveList, savePath);
		
		
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
	}
	
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
	
	public void setData()
	{
		String path = "D:\\HHS\\git_researchP\\Reserch_P\\WebContent\\backupData\\backup_20190603104134.txt";
		FileOpen fo = new FileOpen();
		List<String> backupData = fo.openSystem(path);
		ResearchDAO dao = new ResearchDAO();
//		List<String> backupData = setFileData(path, subPath);
//		List<Research> researchList = new ArrayList<Research>();	
		int i = 0;
		for(i=0;i<backupData.size();i++)
		{
			Research research = null;
			String start = backupData.get(i);
			if (!start.equals("*****start*****")) {
				System.out.println("backupFile start break");
				break;
			}
			i++;
			
			String title = backupData.get(i);
			i++;
			String customer = backupData.get(i);
			i++;
			String subject = backupData.get(i);
			i++;
			int qNum = Integer.parseInt(backupData.get(i));
			i++;
			int aNum = Integer.parseInt(backupData.get(i));
			i++;
			String openDate = backupData.get(i);
			i++;
			String closeDate = backupData.get(i);
			i++;
			int register = Integer.parseInt(backupData.get(i));
			i++;
			
			if (!backupData.get(i).equals("")) {
				System.out.println("backupFile QA break");
				break;
			} else {
				research = new Research(title, customer, subject, qNum, openDate, closeDate);
				research.setMax_anum(aNum);
				research.setRegister(register);
				i++;
			}
			Connection conn = dao.insertBackup(research);
			int last_id = dao.getLastInsertID(conn);
			dao.updateCommit(conn);
			
			List<UnitQA> listQA = research.getListQA();
			
			for (int j = 0; j < qNum; j++) {
				String question = backupData.get(i);	//질문	
				List<String> answer = new ArrayList<String>();	//답변
				i++;

				int qusCount = 0;
				while (qusCount < qNum)
				{
					String unitAnswer = backupData.get(i);
					i++;
					
					if(unitAnswer.equals("")) {
						qusCount++;
					} else {
						answer.add(unitAnswer);
					}
				}				
				UnitQA unitQA = new UnitQA();
				unitQA.setQuestion(question);
				unitQA.setAnswer(answer);
				listQA.add(unitQA);
			}
			//이 시점에서 DAO를 통해서, research를 update한다.
			//그리고 해당 자료의 research_id값을 가져온다.
			//위에서 얻은 research_id값으로 답변들을 research_result테이블에 등록.
			String SQL = makeCreateTableSQL(last_id);
			dao.createTableToDB(SQL);
			i++;
			start = backupData.get(i);
			List<String[]> resultList = new ArrayList<String[]>();
			if (start.equals("*****result*****")) {
				while(true) {
					i++;
					String result = backupData.get(i);
					if (result.equals("")) {
						break;
					}
					String[] resultArray = result.split(",");
					resultList.add(resultArray);
					//dao를 소 ㅡ 환
				}
				SQL = makeResultDataSQL(last_id, qNum, resultList.size());
				System.out.println("result SQL : " + SQL);
				i++;
			}
		}
	}
	
	private String makeResultDataSQL(int research_id, int qNum, int arrayLength) {
		String SQL = "INSERT INTO research_result" + "(research_id, age, sex, job";
		for (int i = 1; i <= qNum; i++) {
			SQL += ", " + i + "_qus";
		}
		SQL += ") VALUES ";
		for (int i = 0; i < arrayLength; i++) {
			SQL += "( " + research_id + ", ?, ?, ?";
			for (int j = 1; j <= qNum; j++) {
				SQL += ", " + j + "_qus";
			}
			SQL += ")";
			if (i != arrayLength - 1) {
				SQL +=",";
			}
		}
		return SQL;
	}
	
	
	private String makeCreateTableSQL(int research_id) {
		String SQL = "create table " + "research_" + research_id + " ( qid int(3) primary key Auto_increment, question varchar(100) not null, 1_ans varchar(50) null";
		for (int i = 1; i < 100; i++) {
			SQL += ", " + (i + 1) + "_ans VARCHAR(50) NULL";
		}
		return SQL + ")";
	}
}
