package com.prince;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;

import jakarta.servlet.annotation.WebListener;

@WebListener
public class JPAListerner implements ServletContextListener {
    private EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory("mapharma");
        sce.getServletContext().setAttribute("emf", emf);
        System.out.println("EMF initialisée.");
        
        EntityManager em = emf.createEntityManager();
        em.close();
        System.out.println("BD initialisée.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        if (emf != null && emf.isOpen()) emf.close();
        System.out.println("EMF fermée.");
    }
}
