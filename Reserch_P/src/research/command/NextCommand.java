package research.command;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;
import research.main.Person;
import research.main.Research;

public class NextCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "research_run.jsp";
		HttpSession session = request.getSession();
		if (session.getAttribute("before") != null) {
			session.removeAttribute("before");
		}
		String answerStr = request.getParameter("rAnswer");
		if (answerStr == null) {
			session.setAttribute("error", "NOT_SELECT");
		} else {
			if (session.getAttribute("error") != null) {
				session.removeAttribute("error");
			}
			ResearchDAO dao = new ResearchDAO();			
			Research research = (Research)session.getAttribute("research");
			int qCount = Integer.parseInt(request.getParameter("qCount"));
			Person person = (Person)session.getAttribute("person");
			qCount++;
			int answer = Integer.parseInt(answerStr);
			Connection conn = (Connection)session.getAttribute("connection");
			dao.joinResearchAnswer(conn, person, qCount, SQL);
			person.saveAnswerArray(qCount - 2, answer);
			session.setAttribute("qCount", qCount);
			if (research.getMax_qnum() < qCount) {
				viewPage = "research_result.jsp";
				String SQL = makeSQL(research);
				dao.joinResearch(person, SQL);
				session.setAttribute("function", "JOIN_RESEARCH");	
			}		
		}		
		return viewPage;
	}
	
	public String makeSQL(Research research) {
		String SQL = "INSERT INTO research_result(research_id, sex, age, job";
		for (int i = 1; i <= research.getMax_qnum(); i++) {
			SQL += ", " + i + "_qus"; 
		}
		SQL += ") VALUES (" + research.getResearch_id() + ", ?, ?, ?";
		for (int i = 1; i <= research.getMax_qnum(); i++) {
			SQL += ", ?"; 
		}
		return SQL + ")";
	}
	
	public String makeUpdateAnswerSQL(int targetNum) {
		String SQL = "UPDATE SET " + targetNum + "_qus = ? WHERE pid = LAST_INSERT_ID()";

	}
}
