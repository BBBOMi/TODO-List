package kr.or.connect.Todo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.connect.Todo.dao.TodoDao;

@WebServlet("/todoType")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoTypeServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      doPost(req, resp);
    }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id = Integer.parseInt(request.getParameter("id"));
      String type = request.getParameter("type");
      
      TodoDao dao = new TodoDao();
      dao.updateTodo(id, type);
      
      PrintWriter out = response.getWriter();
      out.print("success");
      out.close();
    }
}
