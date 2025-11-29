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
import java.time.LocalDate;
import java.util.List;

/**
 * Servlet implementation class VenteServlet
 */
@WebServlet("/ventes/*")
public class VenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
		
		if("/add".equals(path)) {
			try {
				em.getTransaction().begin();
	            DrugRepository repo = new DrugRepository(em);
	            UserRepository u_repo= new UserRepository(em);
	            
	            HttpSession session=request.getSession();
	            
	            if(session.getAttribute("email")==null){
	            	em.getTransaction().rollback();
	        		request.getRequestDispatcher("login.jsp").forward(request, response);
	        		return;
	        	}
	            
				String email= (String) session.getAttribute("email");
				
				User u=u_repo.findByEmail(email);
				
				List<Drug> drugs=repo.findById_user(u.getId());
	            
				request.setAttribute("drugs", drugs);
        		request.getRequestDispatcher("/venteAdd.jsp").forward(request, response);
				
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            request.getRequestDispatcher("/ventes.jsp").forward(request, response);
	        } finally {
	            em.close();
	        }
			
            return;
        }
		
		if(path==null) {
        	
        	try {
        		em.getTransaction().begin();
	            UserRepository u_repo= new UserRepository(em);
	            VenteRepository repo=new VenteRepository(em);
	            
	            HttpSession session=request.getSession();
	            
	            if(session.getAttribute("email")==null){
	            	em.getTransaction().rollback();
	        		request.getRequestDispatcher("login.jsp").forward(request, response);
	        		return;
	        	}
	            
	            String msg="";
	            
	            if(session.getAttribute("successMessage") != null){
	                msg = (String) session.getAttribute("successMessage");
	                request.setAttribute("successMessage", msg);
	                session.removeAttribute("successMessage");
	            }
	            if(session.getAttribute("errorMessage") != null){
	                msg = (String) session.getAttribute("errorMessage");
	                request.setAttribute("errorMessage", msg);
	                session.removeAttribute("errorMessage");
	            }
				String email= (String) session.getAttribute("email");
				
				User u=u_repo.findByEmail(email);
				
				List<Vente> ventes=repo.findById_user(u.getId());
	            
				request.setAttribute("ventes", ventes);
        		
        		request.getRequestDispatcher("/ventes.jsp").forward(request, response);
				
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            request.getRequestDispatcher("/ventes.jsp").forward(request, response);
	        } finally {
	            em.close();
	        }
			
        	
        	return;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        
		if("/add".equals(path)) {
			try {
				em.getTransaction().begin();
	            DrugRepository d_repo = new DrugRepository(em);
	            UserRepository u_repo= new UserRepository(em);
	            VenteRepository repo= new VenteRepository(em);
	            
	            HttpSession session=request.getSession();
	            
	            if(session.getAttribute("email")==null){
	            	em.getTransaction().rollback();
	        		request.getRequestDispatcher("login.jsp").forward(request, response);
	        		return;
	        	}
	            int id_medoc = Integer.parseInt(request.getParameter("medoc"));
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            LocalDate today = LocalDate.now();
	            
	            
				String email= (String) session.getAttribute("email");
				
				User u=u_repo.findByEmail(email);
				Drug d=d_repo.find(id_medoc);
				
				if(quantity>d.getQuantite() || quantity<=0 || d.getQuantite()<=0) {
					em.getTransaction().rollback();
	                session.setAttribute("errorMessage", "La Stock n'est pas suffissant pour effectuer cet achat");
	                
					response.sendRedirect(request.getContextPath() + "/ventes");
	        		return;
				}
				
				d.setQuantite(d.getQuantite()-quantity);
				
				Vente v= new Vente();
				v.setQuantitySold(quantity);
				v.setDate(today);
				v.setDrug(d);
				v.setUser(u);
				v.setTotal(d.getPrix()*quantity);
				
				repo.create(v);
				d_repo.update(d);
				em.getTransaction().commit();
				
				session.setAttribute("successMessage", "Ventes ajoutés avec succès");
				
				response.sendRedirect(request.getContextPath() + "/ventes");
		
				
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            HttpSession session=request.getSession();
	            session.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            
				response.sendRedirect(request.getContextPath() + "/ventes");
	        } finally {
	            em.close();
	        }
			
            return;
        }
	}

}
