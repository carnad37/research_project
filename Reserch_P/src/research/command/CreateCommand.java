package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;
import research.main.Research;

public class CreateCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "research_result.jsp";
		
		String customer = request.getParameter("CUSTOMER");
		String title = request.getParameter("TITLE");
		String subject = request.getParameter("SUBJECT");
		int max_qnum = Integer.parseInt(request.getParameter("MAX_QNUM"));
		String open = request.getParameter("OPEN");
		String close = request.getParameter("CLOSE");
		Research research = new Research(title, customer, subject, max_qnum, open, close);
		
		ResearchDAO dao = new ResearchDAO();
		HttpSession session = request.getSession();
		String function = "CREATE_RESEARCH";
		
		int retval = dao.createResearch(research);
		if (retval != 1) {
			System.out.println("SQLDB ERROR : data insert error");
		} else {
			int targetResearchID = dao.getResearchID();
			research.setResearch_id(targetResearchID);
			String SQL = makeCreateTableSQL(targetResearchID);
			dao.createTableToDB(SQL);
			if (retval != 1) {
				System.out.println("SQLDB ERROR : can't make research table");
				retval = -1;
			} else {
				session.setAttribute("qCount", 1);
				session.setAttribute("research", research);
			}
		}
		session.setAttribute("function", function);
		session.setAttribute("result", retval);
		return viewPage;
	}
	
	private String makeCreateTableSQL(int research_id) {
		String SQL = "create table " + "research_" + research_id + " ( qid int(3) primary key Auto_increment, question varchar(100) not null, 1_ans varchar(50) null";
		for (int i = 1; i < 100; i++) {
			SQL += ", " + (i + 1) + "_ans VARCHAR(50) NULL";
		}
		return SQL + ")";
	}

}
