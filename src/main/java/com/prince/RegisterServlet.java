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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String confirm_password = request.getParameter("confirm_password");
        
        if(!password.equals(confirm_password)) {
        	String errorMessage="Les Mots de passes ne correspondent pas!";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
        }

        try {
            em.getTransaction().begin();
            UserRepository repo = new UserRepository(em);

            if (repo.findByEmail(email) != null) {
                em.getTransaction().rollback();
                request.setAttribute("errorMessage", "Email déjà utiliser! Veuillez choisir un autre");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            
            if (repo.findByTelephone(telephone) != null) {
                em.getTransaction().rollback();
                request.setAttribute("errorMessage", "Numero de Telephone déjà utiliser! Veuillez choisir un autre");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            User u = new User();
            u.setEmail(email);
            u.setPassword(PasswordTool.hash(password));
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setTelephone(telephone);
            repo.create(u);

            em.getTransaction().commit();
            String successMessage="Utilisateur Inscrire avec succes";
			request.setAttribute("successMessage", successMessage);
			
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			
			response.sendRedirect(request.getContextPath() + "/medicaments");
        } catch(Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } finally {
            em.close();
        }
	}

}
