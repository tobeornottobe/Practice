package cc.openhome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String USERS = "f:/J2EE/JSP_Work";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "index.html";  //??
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		if(checkLogin(username,password)){
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		}else{
			response.sendRedirect(ERROR_VIEW);
		}
		
	}
	
	private boolean checkLogin(String username,String password) throws IOException{
		if(username != null && password != null){
			for(String file : new File(USERS).list()){
				if(file.equals(username)){
					BufferedReader reader = new BufferedReader(
							new FileReader(USERS + "/" + file + "/profile"));
					String passwd = reader.readLine().split("\t")[1];    //[0] is for email
					if(passwd.equals(password)){
						return true;
					}
				}
			}
		}
		return false;
	}

}
