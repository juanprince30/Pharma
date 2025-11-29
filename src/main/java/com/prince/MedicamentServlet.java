package com.prince;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

/**
 * Servlet implementation class MedicamentServlet
 */
@WebServlet("/medicaments/*")
@MultipartConfig
public class MedicamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicamentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = request.getPathInfo();
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

		
		if("/add".equals(path)) {
            request.getRequestDispatcher("/medicamentAdd.jsp").forward(request, response);
            return;
        }

        if(path!=null && path.startsWith("/edit/")) {
        	
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
	            
	            String idStr = path.substring("/edit/".length());
	            int id = Integer.parseInt(idStr);
	            
	            Drug drug=repo.find(id);
	            
	            if(drug==null) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Oopss!! Aucun Medicaments Trouver!!");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            if(drug.getUser()!=u) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Access Interdit! Vous n'avez pas le droit d'acceder a cette page");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            request.setAttribute("drug", drug);
	            request.getRequestDispatcher("/medicamentEdit.jsp").forward(request, response);
	            
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            HttpSession session=request.getSession();
	            session.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            
				response.sendRedirect(request.getContextPath() + "/medicaments");
	        } finally {
	            em.close();
	        }
			
        	
            return;
        }

        if(path!=null && path.startsWith("/show/")) {
        	
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
	            
	            String idStr = path.substring("/edit/".length());
	            int id = Integer.parseInt(idStr);
	            
	            Drug drug=repo.find(id);
	            
	            if(drug==null) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Oopss!! Aucun Medicaments Trouver!!");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            if(drug.getUser()!=u) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Access Interdit! Vous n'avez pas le droit d'acceder a cette page");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            request.setAttribute("drug", drug);
	            request.getRequestDispatcher("/medicamentShow.jsp").forward(request, response);
	            
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            HttpSession session=request.getSession();
	            session.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            
				response.sendRedirect(request.getContextPath() + "/medicaments");
	        } finally {
	            em.close();
	        }
			
            return;
        }
        
        if(path==null) {
        	
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
				
				List<Drug> drugs=repo.findById_user(u.getId());
	            
				request.setAttribute("drugs", drugs);
	            request.getRequestDispatcher("/medicaments.jsp").forward(request, response);
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            request.getRequestDispatcher("/medicaments.jsp").forward(request, response);
	        } finally {
	            em.close();
	        }
			
        	
        	return;
        }
        
        response.sendError(404);
        

        
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
	            DrugRepository repo = new DrugRepository(em);
	            UserRepository u_repo=new UserRepository(em);
	            
	            
	            String nom = request.getParameter("nom");
	            String category = request.getParameter("category");
	            LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"));
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double price = Double.parseDouble(request.getParameter("price"));
	            
	            LocalDate today = LocalDate.now();

	            if (expirationDate.isBefore(today)) {
	            	em.getTransaction().rollback();
	                request.setAttribute("errorMessage", "La date choisit doit etre superieur a celle D'aujoudhui");
	            	request.getRequestDispatcher("/medicamentAdd.jsp").forward(request, response);
	        		return;
	            }
	            
	            Part filePart = request.getPart("image");  
	            String chemin = getServletContext().getRealPath("/Medocs/");
	            String fileName = filePart.getSubmittedFileName();
	            
	            File directory = new File(chemin);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            filePart.write(chemin + fileName);
	            String cheminDB = "Medocs/" + fileName;
	            
	            HttpSession session=request.getSession();
	            
	            if(session.getAttribute("email")==null){
	            	em.getTransaction().rollback();
	                request.setAttribute("errorMessage", "Session Invalide!! Reconnecter vous Svp");
	        		request.getRequestDispatcher("login.jsp").forward(request, response);
	        		return;
	        	}
				String email= (String) session.getAttribute("email");
				
				User u=u_repo.findByEmail(email);
	            
	            
	            Drug drug= new Drug();
	            drug.setNom(nom);
	            drug.setCategory(category);
	            drug.setDateExpiration(expirationDate);
	            drug.setQuantite(quantity);
	            drug.setPrix(price);
	            drug.setImage(cheminDB);
	            drug.setUser(u);
	            repo.create(drug);
	            
	            em.getTransaction().commit();
				
	            session.setAttribute("successMessage", "Medicaments ajouté avec succès");
				
				response.sendRedirect(request.getContextPath() + "/medicaments");
		
			} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            request.getRequestDispatcher("/medicamentAdd.jsp").forward(request, response);
	        } finally {
	            em.close();
	        }
			
			return;
            
        }

        if(path!=null && path.startsWith("/delete/")) {
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
	            
	            String idStr = path.substring("/delete/".length());
	            int id = Integer.parseInt(idStr);
	            
	            Drug drug=repo.find(id);
	            
	            if(drug==null) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Oopss!! Aucun Medicaments Trouver!!");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            if(drug.getUser()!=u) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Access Interdit! Vous n'avez pas le droit d'acceder a cette page");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            repo.delete(drug);

	            
	            em.getTransaction().commit();
				
	            session.setAttribute("successMessage", "Medicaments Supprimer avec succès");
				
				response.sendRedirect(request.getContextPath() + "/medicaments");
	            
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            HttpSession session=request.getSession();
	            session.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            
				response.sendRedirect(request.getContextPath() + "/medicaments");
	        } finally {
	            em.close();
	        }
			
        	
            return;

        }

        if(path!=null && path.startsWith("/edit/")) {
        	
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
	            
	            String idStr = path.substring("/edit/".length());
	            int id = Integer.parseInt(idStr);
	            
	            Drug drug=repo.find(id);
	            
	            if(drug==null) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Oopss!! Aucun Medicaments Trouver!!");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            if(drug.getUser()!=u) {
	            	em.getTransaction().rollback();
	            	session.setAttribute("errorMessage", "Access Interdit! Vous n'avez pas le droit d'acceder a cette page");
					
					response.sendRedirect(request.getContextPath() + "/medicaments");
	        		return;
	            }
	            
	            String nom = request.getParameter("nom");
	            String category = request.getParameter("category");
	            LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"));
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double price = Double.parseDouble(request.getParameter("price"));
	            
	            LocalDate today = LocalDate.now();

	            if (expirationDate.isBefore(today)) {
	            	em.getTransaction().rollback();
	                request.setAttribute("errorMessage", "La date choisit doit etre superieur a celle D'aujoudhui");
	            	request.getRequestDispatcher("/medicamentAdd.jsp").forward(request, response);
	        		return;
	            }
	            
	            Part filePart = request.getPart("image");  
	            String chemin = getServletContext().getRealPath("/Medocs/");
	            String fileName = filePart.getSubmittedFileName();
	            
	            if (fileName != null && !fileName.isEmpty()) {
	                
	                File directory = new File(chemin);
	                if (!directory.exists()) {
	                    directory.mkdirs();
	                }

	                filePart.write(chemin + fileName);
		            String cheminDB = "Medocs/" + fileName;

	                drug.setImage(cheminDB);
	            }
	            
	            drug.setNom(nom);
	            drug.setCategory(category);
	            drug.setDateExpiration(expirationDate);
	            drug.setQuantite(quantity);
	            drug.setPrix(price);
	            
	            repo.update(drug);

	            em.getTransaction().commit();
				
	            session.setAttribute("successMessage", "Medicaments modifier avec succès");
				
				response.sendRedirect(request.getContextPath() + "/medicaments");
	            
        	} catch(Exception e) {
	            if (em.getTransaction().isActive()) em.getTransaction().rollback();
	            e.printStackTrace();
	            HttpSession session=request.getSession();
	            session.setAttribute("errorMessage", "Erreur Interne du serveur! Veullez Reesayer plus tard");
	            
				response.sendRedirect(request.getContextPath() + "/medicaments");
	        } finally {
	            em.close();
	        }
			
        	
            return;
        }
        
        response.sendError(404);
	}

}
