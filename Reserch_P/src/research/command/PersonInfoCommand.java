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
		
		ResearchDAO dao = new ResearchDAO();
		String SQL = makePInfoSQL(person, research.getResearch_id());
		Connection conn = dao.joinResearch(person, SQL);
		session.setAttribute("connection", conn);
		
		return viewPage;
	}
	
	private String makePInfoSQL(Person person, int research_id) {
		return "INSERT INTO research_result(research_id, sex, age,job) VALUES (" + research_id + ", ?, ?, ?)";	
	}
}
