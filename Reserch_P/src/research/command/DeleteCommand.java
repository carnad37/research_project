package research.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import research.dao.ResearchDAO;

public class DeleteCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "delete_view.do";
		
		String[] targetID = request.getParameterValues("check_id");
		ResearchDAO dao = new ResearchDAO();
		String delInfo = makeDeleteResearchSQL(targetID);
		String dropTalbe = makeDropResearchSQL(targetID);
		String dropResult = makeDeleteResultSQL(targetID);
		dao.deleteToDB(delInfo, dropTalbe, dropResult);
		
		return viewPage;
	}
	private String makeDeleteResearchSQL(String[] targetID) {
		String SQL = "DELETE FROM research_info WHERE research_id = "+ targetID[0];
		if (targetID.length > 1) {
			for (int i = 1; i < targetID.length; i++) {
				SQL += " OR research_id = " + targetID[i];
			}
		}
		return SQL;
	}
	private String makeDropResearchSQL(String[] targetID) {
		String SQL = "DROP TABLE research_" + targetID[0];
		if (targetID.length > 1) {
			for (int i = 1; i < targetID.length; i++) {
				SQL += ", research_" + targetID[i];
			}
		}
		return SQL;
	}

	private String makeDeleteResultSQL(String[] targetID) {
		String SQL = "DELETE FROM research_result WHERE research_id = "+ targetID[0];
		if (targetID.length > 1) {
			for (int i = 1; i < targetID.length; i++) {
				SQL += " OR research_id = " + targetID[i];
			}
		}
		return SQL;
	}
}
