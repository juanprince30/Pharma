package com.prince;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		try {
            em.getTransaction().begin();
            UserRepository repo = new UserRepository(em);
            
            if (repo.findByEmail(email) == null) {
                em.getTransaction().rollback();
                request.setAttribute("errorMessage", "Identifiants incorrects! Veullez Reesayer plus tard");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            
            User u = repo.findByEmail(email);
            
            if(email.equalsIgnoreCase(u.getEmail()) && PasswordTool.verify(password, u.getPassword())) {
    			
    			//SESSION
    			HttpSession session=request.getSession();
    			session.setAttribute("email", email);
    			
    			String successMessage="Vous etes connecte avec succes";
    			request.setAttribute("successMessage", successMessage);
    			
    			response.sendRedirect(request.getContextPath() + "/medicaments");
    		}else {
    			String errorMessage="Identifiants incorrects! Veullez Reesayer plus tard";
    			request.setAttribute("errorMessage", errorMessage);
    			request.getRequestDispatcher("login.jsp").forward(request, response);
    		}
        } catch(Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } finally {
            em.close();
        }
		
	}

}
