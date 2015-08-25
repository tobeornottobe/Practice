package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pet
 */
@WebServlet("/Pet")
public class Pet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		//response.setCharacterEncoding("BIG5");
		doGet(request, response);   ///req & res Committed!!!!!!!!!
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>感謝填寫</title>");		
		out.println("</head>");
		out.println("<body>");
		out.println("連絡人:<a href='mailto:" + 
				request.getParameter("email") + "'>" + 
				request.getParameter("user") + "</a>");
		out.println("<br>喜愛的幒物類型");
		out.println("<ul>");
		for(String type : request.getParameterValues("type")){
			out.println("<li>" + type + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
