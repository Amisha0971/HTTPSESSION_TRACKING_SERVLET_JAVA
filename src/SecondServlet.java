

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();

	            HttpSession session = request.getSession(false);
	            String userName = (String) session.getAttribute("userName");
	            String userCity = (String) session.getAttribute("userCity");
	            String userEducation = (String) session.getAttribute("userEducation");
	            String userHobby = (String) session.getAttribute("userHobby");


	            // Generating HTML for extended information
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<meta charset='ISO-8859-1'>");
	            out.println("<title>User Information</title>");
	            out.println("<style>");
	            out.println("body { display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
	            out.println(".container { text-align: center; background-color:yellow; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); max-width: 500px; width: 100%; }");
	            out.println("</style>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<div class='container'>");
	            out.println("<h1>My Introduction</h1>");
	            out.println("<p>My name is " + userName + ". I'm living in " + userCity + ". Currently, I have graduated in "
	                    + userEducation + ". My hobby is " + userHobby + ".</p>");
	            out.println("</div>");
	            out.println("</body>");
	            out.println("</html>");
	            out.close();

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
