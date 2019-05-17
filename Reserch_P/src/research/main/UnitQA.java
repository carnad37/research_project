package research.main;

import java.util.List;

public class UnitQA
{

	private String question = null;
	private List<String> answer = null;
	
	public String getQuestion() {
		return question;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}
	
//	public UnitQA(String question, List<String> answer)
//	{
//		this.question = question;
//		this.answer = answer;
//	}	
//		
//	public String getQuestion()
//	{
//		return question;
//	}
//	
//
//	
//	public void printQA()
//	{
//		System.out.println("Q : "+question);
//		for(int i=0;i<answer.size();i++)
//		{
//			int aNumber = i+1;
//			String unitAnswer = answer.get(i);
//			System.out.println(aNumber+"."+unitAnswer);
//		}				
//	}
//	
//	public void addAnswer(String unitAnswer)
//	{
//		answer.add(unitAnswer);
//	}
//	
//	public void setAnswer(int index, String unitAnswer)
//	{
//		answer.set(index, unitAnswer);
//	}
//	
//	public void setQuestion(String question)
//	{
//		this.question = question;
//	}
	
//	
//	public void addQuestion(String unitQuestion)
//	{
//		question.add(unitQuestion);
//	}
//	
//	public void addAnswer(List<String> unitAnswer)
//	{
//		answer.add(unitAnswer);
//	}
//	
//	public void removeQuestion(String unitQuestion)
//	{
//		question.add(unitQuestion);
//	}
//	
//	public void removeAnswer(List<String> unitAnswer)
//	{
//		answer.add(unitAnswer);
//	}
//	
//	public String getQuestion(int index)
//	{
//		return question.get(index);
//	}
//	
//	public List<String> getAnswer(int index)
//	{
//		return answer.get(index);
//	}
//	
//	public void setQuestion(int questionNumber, String unitQuestion)
//	{
//		question.set(questionNumber, unitQuestion);
//	}
//	
//	public void setAnswer(int questionNumber, List<String> unitAnswer)
//	{
//		answer.set(questionNumber, unitAnswer);
//	}	
//	
//	public int getAnswerNumber(int index)
//	{
//		List<String> targetAnswer = answer.get(index);
//		return targetAnswer.size();
//	}
}
