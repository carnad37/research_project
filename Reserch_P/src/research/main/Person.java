package research.main;

public class Person {
	private int age = 0;
	private String sex =  null;
	private String job = null;
//	private List<Integer> answerList = new ArrayList<Integer>() ;
	private int[] answerArray = null;
	
	public void setAnswerArray (int length) {
		answerArray = new int[length];
	}
	public void saveAnswerArray (int index, int value) {
		answerArray[index] = value;
	}
	
	public int[] getAnswerArray() {
		return answerArray;
	}

	//	public void saveAnswer(int answer) {
//		answerList.add(answer);
//	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
//	public List<Integer> getAnswerList() {
//		return answerList;
//	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	
}
