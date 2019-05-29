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
			Connection conn = (Connection)session.getAttribute("connection");
			Research research = (Research)session.getAttribute("research");
			Person person = (Person)session.getAttribute("person");

			int qCount = Integer.parseInt(request.getParameter("qCount"));
			int answer = Integer.parseInt(answerStr);
			String SQL = makeUpdateAnswerSQL(qCount);			
			person.saveAnswerArray(qCount - 1, answer);	//1¿∫ 1∫Œ≈Õ Ω√¿€«ÿº≠ ª©¡‹.
			dao.joinResearchAnswer(conn, answer, SQL);

			qCount++;
			session.setAttribute("qCount", qCount);
			if (research.getMax_qnum() < qCount) {
				dao.updateCommit(conn);
				session.setAttribute("function", "JOIN_RESEARCH");
				viewPage = "research_result.jsp";
			}		
		}		
		return viewPage;
	}
		

	
	private String makeUpdateAnswerSQL(int targetNum) {
		String SQL = "UPDATE research_result SET " + targetNum + "_qus = ? WHERE pid = LAST_INSERT_ID()";
		return SQL;
	}
}
