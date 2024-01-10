import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            // Retrieving form data
            String userName = request.getParameter("userName");
            String userCity = request.getParameter("userCity");
            String userEducation = request.getParameter("userEducation");
            String userHobby = request.getParameter("userHobby");

         
            // Creating a session and setting attributes
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("userCity", userCity);
            session.setAttribute("userEducation", userEducation);
            session.setAttribute("userHobby", userHobby);

            // Generating HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='ISO-8859-1'>");
            out.println("<title>User Information</title>");
            out.println("<style>");
            out.println("body { display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
            out.println(".container { text-align: center; background-color:pink; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); max-width: 400px; width: 100%; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Welcome " + userName + "</h1>");
            out.println("<a href='SecondServlet'>Full Introduction</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");


            out.close();

        }catch(Exception e){System.out.println(e);}  

    }
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
