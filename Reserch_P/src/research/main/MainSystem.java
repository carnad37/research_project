package research.main;
//package research.main;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//
//public class MainSystem
//{
//	public static final boolean YES = true;
//	public static final boolean NO = false;
//	public static final boolean PASS = true;
//	public static final boolean ERROR = false;
//	public static final int HAVE_NOT_TARGET = -1;
//	public static final boolean OFF = false;
//	public static final boolean ON = true;
//	public static final String BLANK = "";
//	
//	static Scanner scan;
//	
//	public MainSystem()
//	{
//		scan = new Scanner(System.in);
//	}
//	
//	public void mainSystem(List<String> titleList, String mainPath)
//	{	
//		boolean loopFlag = ON;
//		
//		System.out.println("=======================================");
//		System.out.println("설문조사 시스템 관리");
//		
//		while (loopFlag == ON)
//		{
//			System.out.println("=======================================");
//			System.out.println("1. 설문조사 개요 등록하기");
//			System.out.println("2. 설문조사 개요 확인하기");
//			System.out.println("3. 설문조사 상세 등록/확인하기");
//			System.out.println("4. 설문조사 실행※준비중");
//			System.out.println("5. 종료");
//			System.out.println("=======================================");
//			int select = selectInputSystem(1,5);
//			loopFlag = distributeSevice(select,titleList,mainPath);
//			if (loopFlag == NO)
//			{
//				System.out.println("정말 종료하시겠습니까?");
//				boolean answer = setAnswer();
//				if (answer == YES)
//				{
//					return;
//				}
//			}
//		}		
//	}
//	
//	private boolean distributeSevice(int select,List<String> titleList, String mainPath)
//	{
//		switch(select)
//		{
//		case 1:
//			ResearchCreation createDB = new ResearchCreation();
//			createDB.createDB(titleList, mainPath);
//			break;
//		case 2:
//			printDBData(titleList);
//			break;
//		case 3:
//			ResearchSetting setResearch = new ResearchSetting();
//			setResearch.setResearch(titleList);
//			break;
//		case 4:
//			StartResearch research = new StartResearch();
//			research.runResearchSystem();
//			break;
//		case 5: return OFF;
//		default:
//			System.out.println("시스템 오류");
//			return OFF;
//		}
//		return ON;
//	}
//
//	
//	public static int selectInputSystem(int start, int end)
//	{
//		String selectNumString = null;
//		int selectNum = 0;
//		boolean loopFlag = ON;
//		while (loopFlag == ON)
//		{
//			try
//			{
//				System.out.print(">");
//				selectNumString = scan.nextLine();
//				selectNum = Integer.parseInt(selectNumString);
//				if (selectNum < start || selectNum > end)
//				{
//					System.out.println("잘못된 입력입니다.");
//				}
//				else
//				{
//					loopFlag = OFF;
//				}
//			}
//			catch (NumberFormatException e)
//			{
//				System.out.println("잘못된 입력입니다.");
//			}
//		}
//		return selectNum;		
//	}
//	
//	public static boolean setAnswer()
//	{
//		while (true)
//		{
//			System.out.print("(y/n) > ");
//			String select = scan.nextLine();
//			if (select.length() > 1)
//			{
//				System.out.println("잘못된 입력입니다.");
//				continue;
//			}
//			
//			select = select.toLowerCase();
//			if (select.equals("y"))
//			{
//				return YES;
//			}
//			else if (select.equals("n"))
//			{
//				return NO;
//			}
//			else
//			{
//				System.out.println("잘못된 입력입니다.");
//			}
//		}
//	}
//	
//	public static String setResearch(Iterator<String> researchTitle)
//	{	
//	List<String> titleList = new ArrayList<String>();
//	int titleNumber= 1;	
//	while (researchTitle.hasNext())
//	{			
//		String currenttitle = researchTitle.next();
//		System.out.println(titleNumber + "." + currenttitle);
//		titleList.add(currenttitle);
//		titleNumber++;
//	}
//	System.out.println("원하시는 설문조사 번호를 선택해주세요");
//	System.out.print(">");
//	int selecttitle = MainSystem.selectInputSystem(1, titleNumber);
//	String targettitle = titleList.get(selecttitle-1);
//	return targettitle;
//	}
//	
//	
//	private void printDBData(List<String> titleList)
//	{
////		Set<String> keySet = researchDB.keySet();
////		String targettitle = setResearch(keySet.iterator());
////		Research research = researchDB.get(targettitle);
////		research.printResearchSummary();
//	}
//	
//	public static boolean wordChecker(String target, String banWord)
//	{
//		boolean blankCheck = banBlank(target);
//		if (blankCheck == ERROR)
//		{
//			return ERROR;
//		}
//		int result = target.indexOf(banWord);
//		if (result == HAVE_NOT_TARGET)
//		{
//			return PASS;
//		}
//		System.out.println("포함되서는 안되는 문자가 포함되어있습니다.");
//		return ERROR;
//	}
//	
//	public static boolean banBlank(String word)
//	{
//		if (word.equals(BLANK))
//		{
//			System.out.println("빈칸이 입력되었습니다.");
//			return ERROR;
//		}
//		return PASS;
//	}
//}
