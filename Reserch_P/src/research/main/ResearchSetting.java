package research.main;
//package research.main;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//public class ResearchSetting 
//{
//	//1.아직 상세등록이 완료되지않은 데이터를 등록한다.
//	//1-1.(Data의 key값과 DB의 설문명 List를 비교)
//	//1-2.(DB의 최대 질문수 값과 Data의 size가 같은지 비교).
//	//2.기존의 데이터를 불러와 수정한다.
//	static final boolean PASS = MainSystem.PASS;
//	static final boolean ERROR = MainSystem.ERROR;
//	static final boolean REGISTER = PASS;
//	static final boolean UNREGISTER = ERROR;
//	static final boolean YES = MainSystem.YES;
//	static final boolean NO = MainSystem.NO;
//	static final boolean OFF = false;
//	static final boolean ON = true;
//	public static final int NO_FUNCTION = 0;
//	public static final int CREATE_RESEARCH = 1;
//	public static final int CREATE_QUESTION_TABLE = 2;
//	public static final int INPUT_RESEARCH = 3;
//	public static final int MODIFY_RESEARCH =4;
//	
//	static final int QUESTION_TITLE = 0;
//	
//	public void setResearch(List<String> titleList)
//	{
//		DataManager dm = new DataManager();
//		List<String> registerList = new ArrayList<String>();
//		dm.checkUnRegistertResearch(registerList);
//		
//		System.out.println("=======================================");
//		System.out.println("설문조사 시스템 입력");
//		while(true)
//		{
//			System.out.println("=======================================");
//			System.out.println("1. 미등록 설문조사 질답 입력");
//			System.out.println("2. 설문조사 내용 일람");
//			System.out.println("3. 기존 설문조사 정보 수정");
//			System.out.println("4. 뒤로가기");
//			System.out.println("=======================================");
//			int select = MainSystem.selectInputSystem(1,4);
//			boolean exitFlag = distributeSevice(select, titleList, registerList);
//			if(exitFlag==YES)
//			{
//				return;
//			}
//		}
//	}
//	
//	private boolean distributeSevice(int select,List<String> titleList, List<String> registerList)
//	{
//		switch(select)
//		{
//		case 1:
//			researchRegisterSystem(titleList, registerList);
//			break;
//		case 2:
////			researchPrintSystem(researchDB);
//			break;
//		case 3:
////			changeResearchData(mainPath, researchDB);
//			break;
//		case 4: return true;
//		}
//		return false;
//	}
//	
//	private void researchRegisterSystem(List<String> titleList, List<String> registerList)
//	{
//		List<String> unRegisterList = new ArrayList<String>();
//		for (String title : titleList) {
//			boolean check = UNREGISTER;
//			for (String register : registerList) {
//				if (title.equals(register)) {
//					check = REGISTER;
//					break;
//				}
//			}
//			if (check == UNREGISTER) {
//				unRegisterList.add(title);
//			}
//		}
//		boolean unRegisterEmpty = unRegisterList.isEmpty();
//		if(!unRegisterEmpty)
//		{
//			Iterator<String> selectQuestion = unRegisterList.iterator();
//			String targetTitle = MainSystem.setResearch(selectQuestion);
//			
//			//타겟 타이틀이 정해진다.
//			//다음엔 정해진 타이틀로 DB에서 데이터를 불러와야한다.
//			//불러올 데이터는 사실 QuestionNumber면 충분하다...
//			
//			Research targetResearch = getTargetResearch(targetTitle);	
//			int targetQuestionNumber = targetResearch.getQuestionNumber();	//최대 질문수
//			
//			int answerStartNumber = 1;
//			List<UnitQA> targetListQA = targetResearch.getListQA();
//			makeQA(targetListQA, targetQuestionNumber, answerStartNumber);	
//			
//			DataManager dm = new DataManager();
//			dm.connectDB(targetResearch, CREATE_QUESTION_TABLE);
//		}
//		else
//		{
//			System.out.println("미등록 설문조사가 없습니다");
//		}			
//	}
//	
//	private Research getTargetResearch(String targetTitle) {
//		DataManager dm = new DataManager();
//		Research targetResearch = dm.setResearchData(targetTitle);	
//		return targetResearch;
//	}
//	
//	private void changeResearchData(String mainPath, List<String> registerList)
//	{
//
//		Iterator<String> registerTitle = registerList.iterator();
//		
//		String targetTitle = MainSystem.setResearch(registerTitle);
//		Research targetResearch = getTargetResearch(targetTitle);	
//		//수정하고싶은 설문 선택.
//		System.out.println("=======================================");
//		List<UnitQA> targetListQA = targetResearch.getListQA();
//		int targetQuestionNumber = targetResearch.getQuestionNumber();
//		for(int i=0;i<targetQuestionNumber;i++)
//		{
//			targetResearch.printQuestion(targetListQA, i);
//		}
//		System.out.println("=======================================");
//		
//		List<UnitQA> listQA = targetResearch.getListQA();
//		int selectQuestionNumber = 0;
//		
//		boolean loopFlag = ON;
//		while (loopFlag == ON)
//		{
//			System.out.println("수정하고싶은 질문 번호를 입력해주세요.");
//			selectQuestionNumber = MainSystem.selectInputSystem(1, targetQuestionNumber);
//			selectQuestionNumber--;
//			targetResearch.printUnitQA(listQA, selectQuestionNumber);
//			System.out.println("선택하신 질문이 맞으십니까?");
//			boolean answer = MainSystem.setAnswer();
//			if(answer==YES)
//			{
//				loopFlag = OFF;
//			}
//		}
//		
//		loopFlag = ON;
//		while (loopFlag == ON)
//		{
//			System.out.println("=======================================");
//			System.out.println("1.답변 추가하기");
//			System.out.println("2.기존의 질문, 답변 수정하기");
//			System.out.println("=======================================");
//			int selectMethod = MainSystem.selectInputSystem(1, 2);
//			if(selectMethod == 1)
//			{
//				addData(mainPath, selectQuestionNumber, listQA);
//			}
//			else if(selectMethod == 2)
//			{
//				resetData(mainPath, selectQuestionNumber, listQA);
//			}
//			System.out.println("수정을 끝내시겠습니까?");
//			DataManager setValue = new DataManager();
//			
////			setValue.saveAllResearchData(researchDB, mainPath);
//			
//			boolean answer = MainSystem.setAnswer();
//			if (answer == YES)
//			{
//				loopFlag = OFF;
//			}
//		}
//	}	
//
//	private void addData(String mainPath, int selectQuestionNumber, List<UnitQA> listQA)
//	{
//		System.out.println("추가할 답변을 입력해주세요");
//		DataManager setValue = new DataManager();
//		
//		UnitQA unitQA = listQA.get(selectQuestionNumber);
//		List<String> currentAnswer = unitQA.getAnswer();
//		
//		int answerStartNumber = currentAnswer.size()+1;
//		makeAnswer(answerStartNumber, currentAnswer, setValue);
//		
////		unitQA.setAnswer(selectQuestionNumber, currentAnswer);
//	}
//	
//	private void resetData(String mainPath, int selectQuestionNumber, List<UnitQA> listQA)
//	{
//		System.out.println("수정하시고 싶은 내역을 선택해주세요.");
//		UnitQA unitQA = listQA.get(selectQuestionNumber);
//
//		String question = unitQA.getQuestion();
//		System.out.println("1."+question);
//		List<String> currentAnswer = unitQA.getAnswer();
//		for (int i = 0; i<currentAnswer.size(); i++)
//		{
//			int number = i+2;	//+문제수(1개)+인덱스(+1)
//			String data = currentAnswer.get(i);
//			System.out.println(number+"."+data);
//		}
//		int selectSize = currentAnswer.size();
//		int select = MainSystem.selectInputSystem(1, selectSize);
//		select--;	//문제수(-1)
//		
//		String newData = null;
//		while (true)
//		{
//			System.out.println("새로운 내용을 입력해주세요.");
//			System.out.print(">");
//			newData = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(newData);
//			if(wordCheck == ERROR)
//			{
//				continue;
//			}
//			break;
//		}
//		//1이면 question.
//		//1이상이면 answer로.
//		if(select==QUESTION_TITLE)
//		{
//			unitQA.setQuestion(newData);
//		}
//		else
//		{
//			select--;	//인덱스(-1)
//			currentAnswer.set(select, newData);
////			unitQA.setAnswer(selectQuestionNumber,currentAnswer);
//		}
//	}
//
//
//	private void researchPrintSystem(List<String> registerList)
//	{
//		Iterator<String> regiserTitle = registerList.iterator();
//		String targetTitle = MainSystem.setResearch(regiserTitle);
//		
//		Research targetResearch = getTargetResearch(targetTitle);	
//		targetResearch.printListQA();
//	}
//	
//	
//	public void makeQA(List<UnitQA> listQA, int questionNumber, int startNumber)
//	{
//		System.out.println("=======================================");
//		System.out.println("질문과 답변 등록을 시작합니다.");
//		System.out.println("=======================================");
//		DataManager setValue = new DataManager();
//		for(int i = 1; i <= questionNumber; i++)
//		{
//			String newQuestion = makeQuestion(i,setValue);
//			
//			List<String> newAnswer = new ArrayList<String>();
//			makeAnswer(startNumber, newAnswer,setValue);
//			UnitQA unitQA = new UnitQA(newQuestion, newAnswer);
//			listQA.add(unitQA);
//		}
//	}
//	
//	private String makeQuestion(int index, DataManager setValue)
//	{
//		System.out.println("=======================================");
//		while (true)
//		{
//			System.out.println("※" + index + "번째 질문을 입력해주세요.");
//			System.out.print(">");
//			String question = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(question);
//			if(wordCheck == ERROR)
//			{
//				continue;
//			}
//			return question;
//		}
//	}
//	
//	private void makeAnswer(int startNum, List<String> answer, DataManager setValue)
//	{
//		while(true)
//		{
//			System.out.println(startNum+"번째 답변을 입력해주세요.");
//			System.out.print(">");
//			String newAnswer = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(newAnswer);
//			if (wordCheck == ERROR)
//			{
//				continue;
//			}
//			answer.add(newAnswer);
//			if (startNum>1)
//			{
//				System.out.println("답변을 더 추가하시겠습니까?");
//				boolean select = MainSystem.setAnswer();
//				if (select == NO)
//				{
//					return;
//				}
//			}			
//			startNum++;
//		}
//	}
//}
