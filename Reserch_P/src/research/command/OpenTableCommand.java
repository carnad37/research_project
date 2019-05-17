package research.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;
import research.main.Research;

public class OpenTableCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "research_table.jsp";
		
		HttpSession session = request.getSession();
		ResearchDAO dao = new ResearchDAO();
		
		List<Research> researchList = dao.getResearch();		
		if (researchList != null) {
			session.setAttribute("result", "PASS");
		} else {
			session.setAttribute("result", "ERROR");
		}
		session.setAttribute("researchList", researchList);
		return viewPage;
	}
}
