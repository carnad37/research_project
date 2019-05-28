package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.main.Person;

public class RunCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "research_run.jsp";

		Person person = null;
		HttpSession session = request.getSession();
		int qCount = Integer.parseInt(request.getParameter("qCount"));

		//조사대상자의 객체를 만든다.
		person = new Person();
		session.setAttribute("person", person);

		qCount++;
		session.setAttribute("qCount", qCount);
		return viewPage;
	}

}
