package research.command;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import research.dao.ResearchDAO;
import research.main.DataManager;
import research.main.Research;

public class BackupCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String path = request.getServletContext().getRealPath("") + "backupData";		
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			path += File.separator;
			System.out.println(path);

			String[] checkArray = request.getParameterValues("check_id");
			ResearchDAO dao = new ResearchDAO();
			String tSQL = makeResearchSQL(checkArray);
			System.out.println(tSQL);
			List<Research> researchList = dao.getTargetResearch(tSQL);
			int maxAnswer = 0;
			List<Integer> checkList = new ArrayList<Integer>();

			for (Research research : researchList) {			
				checkList.add(research.getResearch_id());
				if (maxAnswer < research.getMax_qnum()) {
					maxAnswer = research.getMax_qnum();
				}
			}
			
			String uSQL = makeResultSQL(maxAnswer, checkList);
			DataManager dm = new DataManager();
			dm.saveAllResearchData(researchList, dao.getResultMap(uSQL, maxAnswer), path);
			return null;
	}
	
	private String makeResearchSQL(String[] checkArray) {
		String SQL = "SELECT * FROM research_info WHERE research_id = " + checkArray[0];
		for (int i = 1; i < checkArray.length; i++) {
			SQL += " OR research_id = " + checkArray[i];
		}
		return SQL;
	}
	
	private String makeResultSQL(int maxAnswer, List<Integer> checkList) {

		
		String SQL = "SELECT research_id, sex, age, job";
		for (int i = 0; i < maxAnswer; i++) {
			SQL += ", " + (i + 1) + "_qus"; 
		}
		
		SQL += " FROM research_result WHERE research_id = " + checkList.get(0);
		for (int i = 1; i < checkList.size(); i++) {
			SQL += " OR research_id = " + checkList.get(i);
		}
		System.out.println("result SQL" + SQL);
		return SQL;
	}
	
//	private String makeUnionSQL(List<Research> researchList) {
//		String fSQL = "SELECT sex, age, job, 1_qus";
//		String mSQL = " FROM ";
//		String uSQL = " UNION ALL ";
//		int maxQnum = researchList.get(0).getMax_qnum();
//		for (int i = 1; i < researchList.size(); i++) {
//			int targetQnum = researchList.get(i).getMax_qnum();
//			if (targetQnum > maxQnum) {
//				maxQnum = targetQnum;
//			}
//		}
//		String fullSQL = "";
//		for (int i = 0; i < researchList.size(); i++) {
//			Research research = researchList.get(i);
//			String tableName = "research_" + research.getResearch_id() + "_result";
//			int qNum = researchList.get(i).getMax_qnum();
//			String tSQL = fSQL;
//			for (int j = 1; j < qNum; j++) {
//				tSQL += ", " + (j + 1) +"_qus";
//			}
//			for (int j = qNum; j < maxQnum; j++) {
//				tSQL += ", null AS " + (j + 1) + "_qus";
//			}
//			tSQL += ", " + researchList.get(i).getResearch_id() + " AS research_id";
//			tSQL += mSQL + tableName;
//			if (i != (researchList.size() - 1)) {
//				tSQL += uSQL;
//			}
//			fullSQL += tSQL;
//		}
//		return fullSQL;
//	}
}
