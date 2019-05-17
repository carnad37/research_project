package research.main;

import java.util.ArrayList;
import java.util.List;

public class Research
{
	private String title;
	private String customer;
	private String subject;
	private int max_qnum;
	private int max_anum;
	private String opendate;
	private String closedate;
	private List<UnitQA> listQA = null;
	
	public void setListQA(List<UnitQA> listQA) {
		this.listQA = listQA;
	}

	private int research_id = 0;
	private int register = 1;
	
	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	public void addListQA(UnitQA unitQA) {
		listQA.add(unitQA);
	}
	
	public int getMax_anum() {
		return max_anum;
	}

	public void setMax_anum(int max_anum) {
		this.max_anum = max_anum;
	}

	public Research(String pTitle, String pCustomer, String pSubject, int pQuestionNumber, String pOpendate, String pClosedate)
	{
		title = pTitle;
		customer = pCustomer;
		subject = pSubject;
		max_qnum = pQuestionNumber;
		max_anum = 1;
		opendate = pOpendate;
		closedate = pClosedate;
		listQA = new ArrayList<UnitQA>();
	}
	
	public void setResearch_id(int research_id) {
		this.research_id = research_id;
	}
	
	public int getResearch_id() {
		return research_id;
	}
	
	public void addQA(UnitQA unitQA)
	{
		listQA.add(unitQA);
	}
	
	public void printResearchSummary()
	{
		System.out.println("설문 조사명 : "+title);
		System.out.println("의뢰처 : "+customer);
		System.out.println("설문 분야 : "+subject);
		System.out.println("질문 갯수 : "+max_qnum);
		System.out.println("설문 시작일 : "+opendate);
		System.out.println("설문 종료일 : "+closedate);
	}
	
	public void printListQA()
	{
		if (listQA.isEmpty())
		{
			System.out.println("시스템 오류 : 질문과 답변의 데이터가 없습니다.");
			return;
		}
		for (UnitQA unitQA : listQA)
		{
			String question = unitQA.getQuestion();
			System.out.println("질문 : "+question);
			List<String> answer = unitQA.getAnswer();
			int answerNumber = 1;
			for (String unitAnswer : answer)
			{
				System.out.println("\t" + answerNumber + "." + unitAnswer);
				answerNumber++;
			}
		}
	}
	
	public void printQuestion(List<UnitQA> listQA, int index)
	{
		int currentNumber = index+1;
		UnitQA unitQA = listQA.get(index);
		String question = unitQA.getQuestion();
		System.out.println(currentNumber + "." + question);
	}	
	
	
	public void printUnitQA(List<UnitQA> listQA, int index)
	{
		printQuestion(listQA, index);
		UnitQA unitQA = listQA.get(index);
		List<String> currentAnswer = unitQA.getAnswer();
		for(int j=0;j<currentAnswer.size();j++)
		{
			int answerNumber = j+1;
			String unitAnswer = currentAnswer.get(j);
			System.out.println("\t"+answerNumber+"."+unitAnswer);
		}
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getCustomer()
	{
		return customer;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public int getMax_qnum() {
		return max_qnum;
	}

	public String getOpendate()
	{
		return opendate;
	}
	
	public String getClosedate()
	{
		return closedate;
	}
	
	public List<UnitQA> getListQA()
	{
		return listQA;
	}


}
