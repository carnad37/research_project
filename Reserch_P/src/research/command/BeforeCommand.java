package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.main.Person;

public class BeforeCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "research_run.jsp";
		HttpSession session = request.getSession();

		Person person = (Person)session.getAttribute("person");
		int[] answerArray = person.getAnswerArray();
		
		int qCount = Integer.parseInt(request.getParameter("qCount"));
		int lastAnswer = answerArray[qCount - 1];

		session.setAttribute("qCount", qCount);
		session.setAttribute("before", lastAnswer);
		return viewPage;
	}
}
