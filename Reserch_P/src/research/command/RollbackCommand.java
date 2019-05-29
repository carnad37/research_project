package research.command;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;

public class RollbackCommand extends NextCommand implements ResearchCommand  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "main.do";
		HttpSession session = request.getSession();
		ResearchDAO dao = new ResearchDAO();
		Connection conn = (Connection)session.getAttribute("connection");
		dao.updateRollback(conn);	
		return viewPage;
	}

}
