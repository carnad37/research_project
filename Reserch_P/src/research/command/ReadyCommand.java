package research.command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import research.dao.ResearchDAO;
import research.main.Research;
import research.main.UnitQA;

public class ReadyCommand implements ResearchCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "research_ready.jsp";
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Research> researchList = (List<Research>) session.getAttribute("researchList");
		ResearchDAO dao = new ResearchDAO();
		
		int research_id = Integer.parseInt(request.getParameter("RESEARCH_ID"));
		int maxAnswerNum = Integer.parseInt(request.getParameter("MAX_ANUM"));
		int index = Integer.parseInt(request.getParameter("INDEX"));
		List<UnitQA> listQA = dao.getListQA(research_id, maxAnswerNum);		
		Research research = researchList.get(index);
		research.setListQA(listQA);
		session.setAttribute("research", research);
		
		String result = compareDate(research.getOpendate(), research.getClosedate());
		session.setAttribute("result", result);
		return viewPage;
	}
	
	private String compareDate(String openDate, String closeDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowDate = sdf.format(new Date());
		String result = null;;
		//년 검사-> 월검사 -> 일검사
		int open = Integer.parseInt(openDate.replace("-",""));
		int close = Integer.parseInt(closeDate.replace("-",""));
		int now = Integer.parseInt(nowDate);
		int openCheck = now - open;
		int closeCheck = close - now;
		if ((openCheck >= 0) && (closeCheck >= 0)) {
			result = "IN";
		} else {
			result = "OUT";
		}
		return result;
	}
}
