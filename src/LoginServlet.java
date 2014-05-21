
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//crear sesion, comprobar se existe
		HttpSession session = req.getSession(false);
		if(session == null){
			System.out.println("Tenemos las session expirada");
			
			session = req.getSession(true);			
		}
		System.out.println(session);
		resp.setContentType("text/html");
		String user = req.getParameter("user");
		String pass = req.getParameter("password");

		//creamos un objeto de lista para gardar os datos do usuario
		ArrayList<String> listGuardada = (ArrayList<String>) session.getAttribute("listaUsuarios");
		if (listGuardada!= null )
				listGuardada.add(add(user,pass));
		else{
			  listGuardada = new ArrayList<String>();
			  listGuardada.add(add(user,pass));
		}
		session.setAttribute("listaUsuarios", listGuardada);
        
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Listado");
		requestDispatcher.forward(req, resp);

	}

	private String add(String user, String pass){
		String lista = "usuario: " + user; 
		String con = " contraseña: " + pass;	
		return lista + "</br>" + con;
	}
	
}