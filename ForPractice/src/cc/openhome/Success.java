package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Success
 */
@WebServlet("/success.view")
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);  //committed
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC" + "'-//W3C//DTD HTML 4.0.1 Transitional//EN'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta content='text/html;charset=UTF-8'" + "http-equiv='content-type'");
		out.println("<title>新增會員成功</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>會員" + request.getParameter("username") + "註冊成功</h1>");		
		out.println("<a href='index.html'>返回首頁登入</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
