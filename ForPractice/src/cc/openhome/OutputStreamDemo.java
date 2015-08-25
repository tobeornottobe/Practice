package cc.openhome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputStreamDemo
 */
@WebServlet("/download.do")
public class OutputStreamDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;   //invalidclassexception
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputStreamDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());   //commit
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String passwd = request.getParameter("passwd");
		System.out.println(passwd);
		if("123456".equals(passwd)){
			response.setContentType("application/pdf");
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/123.pdf");
			
			response.sendRedirect("https://google.com");   //committed test
			
			OutputStream out = response.getOutputStream();
			
			writeBytes(in, out);   //commit
			
		}
		//doGet(request, response);   //res、req commit
		
		
	}
	
	private void writeBytes(InputStream in, OutputStream out) throws IOException{
		byte[] buffer = new byte[1024];
		int length = -1;
		while( (length = in.read(buffer)) != -1 ){
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}

}
