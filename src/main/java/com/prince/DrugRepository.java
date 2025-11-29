package com.prince;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class DrugRepository {
	
	private final EntityManager em;

    public DrugRepository(EntityManager em) {
        this.em = em;
    }
    
    // CREATE
    public void create(Drug d) {
        em.persist(d);
    }
    
    // READ by id
    public Drug find(int id) {
        return em.find(Drug.class, id);
    }
    
    // READ by User_id
    public List<Drug> findById_user(int id_user) {
        try {
            return em.createQuery("SELECT u FROM Drug u WHERE u.user.id = :u", Drug.class)
                     .setParameter("u", id_user)
                     .getResultList();
        } catch(NoResultException e) {
            return null;
        }
    }
    
    // UPDATE (merge)
    public Drug update(Drug d) {
        return em.merge(d);
    }

    // DELETE
    public void delete(Drug d) {
        Drug managed = em.contains(d) ? d : em.merge(d);
        em.remove(managed);
    }
    
    // SEARCH par nom (LIKE) + pagination
    public List<Drug> searchByName(String q, int page, int pageSize) {
        return em.createQuery("SELECT u FROM Drug u WHERE LOWER(u.nom) LIKE :q", Drug.class)
                 .setParameter("q", "%" + q.toLowerCase() + "%")
                 .setFirstResult((page-1)*pageSize)
                 .setMaxResults(pageSize)
                 .getResultList();
    }

}
