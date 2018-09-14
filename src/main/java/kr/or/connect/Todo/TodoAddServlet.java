package kr.or.connect.Todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.connect.Todo.dao.TodoDao;
import kr.or.connect.Todo.dto.TodoDto;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoAddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  String name = (String)request.getParameter("name");
	  String title = (String)request.getParameter("title");
	  int sequence = Integer.parseInt(request.getParameter("sequence"));
	  
	  TodoDto todo =  new TodoDto(title, name, sequence);
	  TodoDao dao = new TodoDao();
	  dao.addTodo(todo);
	  response.sendRedirect("main");
	}
}
