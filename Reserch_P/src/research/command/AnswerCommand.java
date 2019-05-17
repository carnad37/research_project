package research.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;
import research.main.Research;
import research.main.UnitQA;

public class AnswerCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "research_question.jsp";

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("function", "INSERT_QA");

		Research research = (Research)session.getAttribute("research");
   		List<String> answer = new ArrayList<String>();
		ResearchDAO dao = new ResearchDAO();
		
		int researchID = dao.getResearchID();
		research.setResearch_id(researchID);
		
		String questioin = (String)session.getAttribute("question");
		int maxAnum = (Integer)session.getAttribute("max_anum");
		if (maxAnum > research.getMax_anum()) {
			dao.addAnswerColumn(research, maxAnum);
			research.setMax_anum(maxAnum);
		}
		System.out.println("maxAnum : " + research.getMax_anum());

		for (int i = 1; i <= maxAnum; i++) {
			String key = i + "_ans";
			String unitAnswer = request.getParameter(key);
			answer.add(unitAnswer);
		}
		
		UnitQA unitQA = new UnitQA();
		unitQA.setQuestion(questioin);
		unitQA.setAnswer(answer);
		String SQL = makeInsertDataSQL(research.getResearch_id(), maxAnum);
		int retval = dao.updateQAToDB(unitQA, SQL);
		if (retval != 1) {
			System.out.println("DB ERROR : ANSWER UPDATE FAILE..");
			viewPage = "research_result.jsp";
			return viewPage;
		} else {
			int qCount = (int)session.getAttribute("qCount") + 1;
			System.out.println("QCOUNT : " + qCount);
			if (qCount > research.getMax_qnum()) {
				retval = dao.completeRegistration(research.getResearch_id(), research.getMax_anum());
				SQL = makeResultTableSQL(research.getResearch_id(), research.getMax_qnum());
				dao.createTableToDB(SQL);
				session.setAttribute("result", retval);
				viewPage = "research_result.jsp";
			}
			session.setAttribute("qCount", qCount);
			return viewPage;
		}
	}
	
	private String makeInsertDataSQL(int research_id, int maxAnswerNumber) {
		String startSQL = "insert into " + "research_" + research_id + "(question, 1_ans";
		for (int i = 2; i <= maxAnswerNumber; i++) {
			startSQL += ", " + i + "_ans";
		}
		startSQL += ") ";
		String endSQL = "values ( ?, ?";
		for (int i = 2; i <= maxAnswerNumber; i++) {
			endSQL += ", ?";
		}
		endSQL += ")";
		System.out.println("insert answer SQL : " + startSQL + endSQL);
		return startSQL + endSQL;
	}
	
	private String makeResultTableSQL(int research_id, int maxQuestionNumber) {
		String SQL = "create table " + "research_" + research_id + "_result (pid int(10) primary key Auto_increment, sex varchar(6) not null, age int(2) not null, job varchar(20) not null";
		for (int i = 1; i <= maxQuestionNumber; i++) {
			SQL += ", " + i + "_qus int(3) null";
		}
		return SQL + ")";
	}
}