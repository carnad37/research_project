package research.main;
//package research.main;
//
//import java.util.List;
//
//public class ResearchCreation
//{
//	static final int CREATE_RESEARCH = 1;
//	static final boolean ERROR = MainSystem.ERROR;
//	static final boolean PASS = MainSystem.PASS;
//	static final boolean YES = MainSystem.YES;
//	static final boolean NO = MainSystem.NO;
//	
//	public void createDB(List<String> titleList, String mainPath)
//	{
//		while(true)
//		{			
//			System.out.println("=======================================");
//			System.out.println("�������� ����� �������ּ���.");
//			System.out.println("=======================================");
////			Research research = setResearchData(titleList);
//			research.printResearchSummary();
//			System.out.println("�� ������ �Է��Ͻðڽ��ϱ�?");
//			boolean answer = MainSystem.setAnswer();
//			if(answer==YES)
//			{
//				String key = research.getTitle();
//				titleList.add(key);	//�ʿ� �־���
//				DataManager dm = new DataManager();
//				dm.connectDBToUapdate(research, CREATE_RESEARCH);
//				return;
//			}
//			System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�?");
//			answer = MainSystem.setAnswer();
//			if(answer==NO)
//			{
//				return;
//			}
//		}
//	}
//		
//	private Research setResearchData(List<String> titleList)
//	{
//		String title = setResearchtitle(titleList);
//		String customer = setCustomer();
//		String subject = setResearchSubject();
//		String questionNumber = String.valueOf(setQuestionNumber());
//		int[]opendateArray = setOpendate();
//		int[]closedateArray = setClosedate(opendateArray);
//		String opendate = dateArrayToString(opendateArray);
//		String closedate = dateArrayToString(closedateArray);
////		Research research = new Research(title, customer, subject, questionNumber, opendate, closedate);
//		return research;
//	}
//
//	private String setCustomer()
//	{
//		System.out.println("�Ƿ�ó�� �Է����ּ���.");
//		while(true)
//		{
//			System.out.print(">");
//			String customer = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(customer);
//			if(wordCheck == ERROR)
//			{
//				continue;
//			}
//			return customer;
//		}
//	}
//	
//	private String setResearchtitle(List<String> titleList)
//	{
//		String researchtitle=null;
//		System.out.println("���������̸��� �Է����ּ���.");
//		mainLoop:
//		while(true)
//		{			
//			System.out.print(">");
//			researchtitle = MainSystem.scan.nextLine();
//			boolean wordCheck = MainSystem.banBlank(researchtitle);
//			if(wordCheck == ERROR)
//		{
//			continue;
//		}
//		for(String comparetitle : titleList)
//		{
//			if(comparetitle.equals(researchtitle))
//			{
//				System.out.println("�̹� ��ϵ� ���������Դϴ�.");
//				System.out.println("�ٽ� �Է����ּ���.");
//				continue mainLoop;
//			}
//		}
//		return researchtitle;
//		}
//	}
//	
//	private String setResearchSubject()
//	{
//		System.out.println("�������� �о߸� �������ּ���.");
//		System.out.println("---------------------------------------");
//		System.out.println("1. �ι�");
//		System.out.println("2. ��ȸ");
//		System.out.println("3. ����");
//		System.out.println("4. ���");
//		System.out.println("5. ����");
//		System.out.println("---------------------------------------");
//		int select = MainSystem.selectInputSystem(1, 5);
//		String researchSubject = null;
//		switch(select)
//		{
//			case 1:
//				researchSubject = "�ι�";
//				break;
//			case 2:
//				researchSubject = "��ȸ";
//				break;
//			case 3:
//				researchSubject = "����";
//				break;
//			case 4:
//				researchSubject = "���";
//				break;
//			case 5:
//				researchSubject = "����";
//				break;
//				//
//		}
//		return researchSubject;
//	}
//	
//	private int setQuestionNumber()
//	{
//		System.out.println("������ ������ �Է����ּ���.");
//		int qNumber = MainSystem.selectInputSystem(1, 500);
//
//		return qNumber;
//	}	
//
//	private int[] setOpendate()
//	{
//		System.out.println("���� �������� �Է����ּ���.");
//		System.out.print("Year");
//		int year = MainSystem.selectInputSystem(2018, 2030);
//		System.out.print("Month");
//		int month = MainSystem.selectInputSystem(1, 12);
//		System.out.print("Day");
//		int day = MainSystem.selectInputSystem(1, 31);
//		int[] opendate = {year,month,day};
//		return opendate;
//	}
//	
//	private int[] setClosedate(int[] opendate)
//	{
//		System.out.println("���� �������� �Է����ּ���.");
//		int openYear = opendate[0];
//		int openMonth = opendate[1];
//		int openDay = opendate[2];
//		int cloesYear =0,cloesMonth =0,cloesDay =0;
//		boolean sameTime = NO;
//		
//		System.out.println("(������ : "+openYear+"."+openMonth+"."+openDay+")");
//		
//		while(true)
//		{
//			System.out.print("Year");
//			cloesYear = MainSystem.selectInputSystem(2018, 2030);
//			if(cloesYear<openYear)
//			{
//				System.out.println("���۳⵵ ���ĸ� �������ּ���.");
//			}
//			else if(cloesYear == openYear)
//			{
//				sameTime = YES;
//				break;
//			}
//			else
//			{
//				break;
//			}
//		}		
//		while(true)
//		{
//			System.out.print("Month");
//			cloesMonth = MainSystem.selectInputSystem(1, 12);
//			if(sameTime)
//			{
//				if(openMonth>cloesMonth)
//				{
//					System.out.println("������ �����Դϴ�.");
//					continue;
//				}
//				else if(openMonth<cloesMonth)
//				{
//					sameTime = NO;
//					break;
//				}
//				else
//				{
//					break;
//				}
//			}
//			else
//			{
//				break;
//			}
//		}
//		while(true)
//		{
//			System.out.print("Day");
//			cloesDay = MainSystem.selectInputSystem(1, 31);
//			if(sameTime)
//			{
//				if(openDay>cloesDay)
//				{
//					System.out.println("������ �����Դϴ�.");
//				}
//				else
//				{
//					break;
//				}
//			}
//			else
//			{
//				break;
//			}
//		}
//		int[] closedate = {cloesYear,cloesMonth,cloesDay};
//		return closedate;
//	}
//	
//	private String dateArrayToString(int[] dateArray)
//	{
//		String year = String.valueOf(dateArray[0]);
//		String month = null;
//		String day = null;
//		if (dateArray[1] < 10) {
//			month = "0" + String.valueOf(dateArray[1]);
//		} else {
//			month = String.valueOf(dateArray[1]);
//		}
//		if (dateArray[2] < 10) {
//			day = "0" + String.valueOf(dateArray[2]);
//		} else {
//			day = String.valueOf(dateArray[2]);
//		}
//		String date = year+"."+month+"."+day;
//		return date;
//	}
//}