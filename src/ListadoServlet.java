import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListadoServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		HttpSession session = req.getSession(false);

		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("</br>");
		
		out.println(session.getAttribute("listaUsuarios"));
		
		out.println("</br>");
		
		// print out cookies
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            String name = c.getName();
            String value = c.getValue();
            out.println(name + " = " + value);
        }

        // set a cookie
        String name = req.getParameter("cookieName");
        if (name != null && name.length() > 0) {
            String value = req.getParameter("cookieValue");
            Cookie c = new Cookie(name, value);
            resp.addCookie(c);
        }
        
		out.println("</br>");
		out.println("</br>");
		out.println("<a href='login.html'>");
		out.println("Mais usuarios");
		out.println("</a");
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}


}
