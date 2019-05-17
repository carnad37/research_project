package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.main.Person;
import research.main.Research;

public class PersonInfoCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "research_run.jsp";
		
		Person person = null;
		HttpSession session = request.getSession();
		Research research = (Research)session.getAttribute("research");
		session.removeAttribute("researchList");
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		String sex = request.getParameter("sex");
		
//조사대상자의 객체를 만든다.
		person = new Person();
		person.setAnswerArray(research.getMax_qnum());
		person.setAge(age);
		person.setJob(job);
		person.setSex(sex);
		
		session.setAttribute("person", person);
		session.setAttribute("qCount", 1);
		return viewPage;
	}

}
