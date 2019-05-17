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
//	//1.���� �󼼵���� �Ϸ�������� �����͸� ����Ѵ�.
//	//1-1.(Data�� key���� DB�� ������ List�� ��)
//	//1-2.(DB�� �ִ� ������ ���� Data�� size�� ������ ��).
//	//2.������ �����͸� �ҷ��� �����Ѵ�.
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
//		System.out.println("�������� �ý��� �Է�");
//		while(true)
//		{
//			System.out.println("=======================================");
//			System.out.println("1. �̵�� �������� ���� �Է�");
//			System.out.println("2. �������� ���� �϶�");
//			System.out.println("3. ���� �������� ���� ����");
//			System.out.println("4. �ڷΰ���");
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
//			//Ÿ�� Ÿ��Ʋ�� ��������.
//			//������ ������ Ÿ��Ʋ�� DB���� �����͸� �ҷ��;��Ѵ�.
//			//�ҷ��� �����ʹ� ��� QuestionNumber�� ����ϴ�...
//			
//			Research targetResearch = getTargetResearch(targetTitle);	
//			int targetQuestionNumber = targetResearch.getQuestionNumber();	//�ִ� ������
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
//			System.out.println("�̵�� �������簡 �����ϴ�");
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
//		//�����ϰ���� ���� ����.
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
//			System.out.println("�����ϰ���� ���� ��ȣ�� �Է����ּ���.");
//			selectQuestionNumber = MainSystem.selectInputSystem(1, targetQuestionNumber);
//			selectQuestionNumber--;
//			targetResearch.printUnitQA(listQA, selectQuestionNumber);
//			System.out.println("�����Ͻ� ������ �����ʴϱ�?");
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
//			System.out.println("1.�亯 �߰��ϱ�");
//			System.out.println("2.������ ����, �亯 �����ϱ�");
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
//			System.out.println("������ �����ðڽ��ϱ�?");
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
//		System.out.println("�߰��� �亯�� �Է����ּ���");
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
//		System.out.println("�����Ͻð� ���� ������ �������ּ���.");
//		UnitQA unitQA = listQA.get(selectQuestionNumber);
//
//		String question = unitQA.getQuestion();
//		System.out.println("1."+question);
//		List<String> currentAnswer = unitQA.getAnswer();
//		for (int i = 0; i<currentAnswer.size(); i++)
//		{
//			int number = i+2;	//+������(1��)+�ε���(+1)
//			String data = currentAnswer.get(i);
//			System.out.println(number+"."+data);
//		}
//		int selectSize = currentAnswer.size();
//		int select = MainSystem.selectInputSystem(1, selectSize);
//		select--;	//������(-1)
//		
//		String newData = null;
//		while (true)
//		{
//			System.out.println("���ο� ������ �Է����ּ���.");
//			System.out.print(">");
//			newData = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(newData);
//			if(wordCheck == ERROR)
//			{
//				continue;
//			}
//			break;
//		}
//		//1�̸� question.
//		//1�̻��̸� answer��.
//		if(select==QUESTION_TITLE)
//		{
//			unitQA.setQuestion(newData);
//		}
//		else
//		{
//			select--;	//�ε���(-1)
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
//		System.out.println("������ �亯 ����� �����մϴ�.");
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
//			System.out.println("��" + index + "��° ������ �Է����ּ���.");
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
//			System.out.println(startNum+"��° �亯�� �Է����ּ���.");
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
//				System.out.println("�亯�� �� �߰��Ͻðڽ��ϱ�?");
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
