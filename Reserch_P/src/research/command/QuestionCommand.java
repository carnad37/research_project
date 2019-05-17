package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuestionCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "answer_view.do";
		
		String str_Anum = request.getParameter("MAX_ANUM");
		HttpSession session = request.getSession();
		int maxAnum = 0;
		try {
			maxAnum = Integer.parseInt(str_Anum);
		} catch (NumberFormatException e) {
			session.setAttribute("error", "NMExc");
			System.out.println("NumberFormatException");
			viewPage = "research_question.jsp";
			return viewPage;
		}
		String question = request.getParameter("QUESTION");
		session.setAttribute("question", question);
		session.setAttribute("max_anum", maxAnum);
		return viewPage;
	}
}
