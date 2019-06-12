package research.front;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import research.command.AnswerCommand;
import research.command.BackupCommand;
import research.command.BeforeCommand;
import research.command.RollbackCommand;
import research.command.CreateCommand;
import research.command.DeleteCommand;
import research.command.NextCommand;
import research.command.OpenTableCommand;
import research.command.PersonInfoCommand;
import research.command.QuestionCommand;
import research.command.ReadyCommand;
import research.command.ResearchCommand;


/**
 * Servlet implementation class ResearchFrontConn
 */
@WebServlet("*.do")
public class ResearchFrontConn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final boolean BEFORE = false;
    private static final boolean NEXT = true;
//	private Map<String, ResearchCommand> commandMap = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearchFrontConn() {
        super();
//        if (commandMap == null) {
//        	commandMap = new Hashtable<String, ResearchCommand>();
//		}
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		actionDo(request, response);
//	}
//
//		
//	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String uri = request.getRequestURI();
//		int start = uri.lastIndexOf("/");
//		String action = uri.substring(start + 1);
//		System.out.println(action);
//		ResearchCommand command = null;
//		String viewPage = null;	
//	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int start = uri.lastIndexOf("/");
		String action = uri.substring(start + 1);
		System.out.println(action);
		ResearchCommand command = null;
		String viewPage = null;		
		
		if (action.equals("main.do")) {
			viewPage = "research_main.jsp";			
		} else if (action.equals("create_view.do")) {
			viewPage = "research_create.jsp";
		} else if (action.equals("create.do")) {
			command = new CreateCommand();			
			viewPage = command.execute(request, response);
			
		} else if (action.equals("question_view.do")) {
			viewPage = "research_question.jsp";
		} else if (action.equals("question.do")) {
			command = new QuestionCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("answer_view.do")) {
			viewPage = "research_answer.jsp";			
		} else if (action.equals("answer.do")) {
			command = new AnswerCommand();			
			viewPage = command.execute(request, response);
			
		} else if (action.equals("open_table.do")) {
			command = new OpenTableCommand();
			
			viewPage = command.execute(request, response);
		} else if (action.equals("ready.do")) {
			command = new ReadyCommand();
			viewPage = command.execute(request, response);
		}
		  /*else if (action.equals("run.do")) {
			command = new RunCommand();
			command.execute(request, response);
			viewPage = "research_run.jsp";
		}*/
		  else if (action.equals("next.do")) {
			command = new NextCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("before.do")) {
			command = new BeforeCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("rollback.do")) {
			command = new RollbackCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("pInfo_view.do")) {
			viewPage = "research_pInfo.jsp";
		} else if (action.equals("pInfo.do")) {
			command = new PersonInfoCommand();
			viewPage = command.execute(request, response);
			
		} else if (action.equals("backup_view.do")) {
			command = new OpenTableCommand();
			command.execute(request, response);
			viewPage = "research_backup.jsp";
		} else if (action.equals("backup.do")) {
			command = new BackupCommand();
			viewPage = command.execute(request, response);
			
		} else if (action.equals("delete_view.do")) {
			command = new OpenTableCommand();
			command.execute(request, response);
			viewPage = "research_delete.jsp";
		} else if (action.equals("delete.do")) {
			command = new DeleteCommand();
			viewPage = command.execute(request, response);
			
		} else {
			System.out.println("SERVLET ERROR : NOT FOUND ACTION. CHECK FORM TAG ACTION.");
		}
		response.sendRedirect(viewPage);
	}
	
}